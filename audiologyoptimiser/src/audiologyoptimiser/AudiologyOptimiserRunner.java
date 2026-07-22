package audiologyoptimiser;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.emoflon.gips.core.milp.SolverOutput;

import audiologymodel.AudiologyBooking;
import audiologymodel.AudiologymodelPackage;
import audiologymodel.importexport.ScheduleCsvExporter;
import audiologyoptimiser.api.gips.AudiologyoptimiserGipsAPI;
import audiologymodel.AppointmentAssignment;
import audiologymodel.AudiologymodelFactory;

public final class AudiologyOptimiserRunner {

    private AudiologyOptimiserRunner() {
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: AudiologyOptimiserRunner "+ "<input.xmi> <output.xmi>");
            System.exit(2);
        }

        Path inputPath = Path.of(args[0])
                .toAbsolutePath()
                .normalize();
        Path outputPath = Path.of(args[1])
                .toAbsolutePath()
                .normalize();

        AudiologyoptimiserGipsAPI api = null;
        boolean initialised = false;

        try {
            if (!Files.isRegularFile(inputPath)) {
                throw new IllegalArgumentException(
                        "Input XMI does not exist: " + inputPath
                );
            }

            if (outputPath.getParent() != null) {
                Files.createDirectories(outputPath.getParent());
            }

            System.out.println("=== Audiology GIPS Optimiser ===");
            System.out.println("Input:  " + inputPath);
            System.out.println("Output: " + outputPath);

            Path modelProject = inputPath.getParent().getParent();
            URI modelProjectUri = URI.createFileURI(
                    modelProject.toString() + File.separator
            );

            EcorePlugin.getPlatformResourceMap().put("audiologymodel",modelProjectUri);

            AudiologymodelPackage.eINSTANCE.eClass();
            EPackage.Registry.INSTANCE.put(
                    AudiologymodelPackage.eNS_URI,
                    AudiologymodelPackage.eINSTANCE
            );

            System.out.println("platform:/resource/audiologymodel/ -> "+ modelProjectUri);

            api = new AudiologyoptimiserGipsAPI();
            URI inputUri = URI.createFileURI(inputPath.toString());

            System.out.println("Initialising generated GIPS API...");
            api.init(inputUri);
            initialised = true;

            AudiologyBooking booking = getBooking(api);
            int requestCount = booking.getWaitingList().size();
            System.out.println("Requests in input model: " + requestCount);

            System.out.println("Building MILP problem...");
            api.buildProblemTimed(true, true);

            int candidateCount = api.getAssignAppt()
                    .getMappings()
                    .size();
            System.out.println("Candidate assignment mappings: " + candidateCount);

            if (candidateCount == 0) {
                throw new IllegalStateException("No assignAppt candidates were generated.");
            }

            System.out.println("Solving MILP problem...");
            SolverOutput output = api.solveProblemTimed();

            if (output.solutionCount() <= 0) {
                throw new IllegalStateException("No feasible appointment schedule was found.");
            }

            System.out.println("Objective value: " + output.objectiveValue());

            int selectedCount = api.getAssignAppt()
                    .getNonZeroVariableMappings()
                    .size();

            System.out.println("Selected assignment mappings: "+ selectedCount);

            if (selectedCount != requestCount) {
                throw new IllegalStateException("Expected exactly " + requestCount+ " selected assignments, but GIPS returned "+ selectedCount);
            }

            System.out.println("Creating AppointmentAssignment objects " + "from selected GIPS mappings...");

            var selectedMappings = new ArrayList<>(api.getAssignAppt().getNonZeroVariableMappings());

            selectedMappings.sort(Comparator.comparingInt(mapping -> mapping.getMatch().getRequest().getNumber()));
            
            System.out.println("Selected GIPS mapping details:");

            for (var mapping : selectedMappings) {
                var match = mapping.getMatch();

                System.out.printf(
                        "%s | request=%d | staff=%d | room=%d " + "| day=%d | start=%d | duration=%d%n",
                        mapping.getName(),
                        match.getRequest().getNumber(),
                        match.getStaffMember().getNumber(),
                        match.getRoom().getNumber(),
                        match.getPlanningDay().getDayIndex(),
                        match.getStartSlot().getStartIndex(),
                        match.getRequest().getDurationSlots()
                );
            }

            booking.getAppointmentAssignments().clear();

            for (var mapping : selectedMappings) {
                var match = mapping.getMatch();

                AppointmentAssignment assignment =AudiologymodelFactory.eINSTANCE.createAppointmentAssignment();

                assignment.setRequest(match.getRequest());

                assignment.setStaffMember(match.getStaffMember());

                assignment.setRoom(match.getRoom());

                assignment.setPlanningDay(match.getPlanningDay());

                assignment.setStartSlot(match.getStartSlot());

                booking.getAppointmentAssignments().add(assignment);
            }

            int assignmentCount = booking.getAppointmentAssignments().size();

            System.out.println("Assignments now in EMF model: "+ assignmentCount);

            if (assignmentCount != requestCount) {
                throw new IllegalStateException("Expected " + requestCount + " AppointmentAssignment objects, but found " + assignmentCount );
            }

            System.out.println("Saving optimised model...");
            api.saveResult(outputPath.toString());

            Path scheduleCsv = outputPath.resolveSibling( "AudiologySchedule.csv" );

            ScheduleCsvExporter.export( outputPath, scheduleCsv );

            System.out.println( "Optimised model saved to: " + outputPath );

            System.out.println ("Readable schedule saved to: "
                            + scheduleCsv
            );

        } catch (Exception exception) {
            System.err.println("Optimisation failed.");
            exception.printStackTrace();

        } finally {
            if (api != null && initialised) {
                try {
                    api.terminate();
                    System.out.println("GIPS terminated.");
                } catch (Exception exception) {
                    System.err.println(
                            "GIPS could not terminate cleanly."
                    );
                    exception.printStackTrace();
                }
            }
        }
    }

    private static AudiologyBooking getBooking(
            AudiologyoptimiserGipsAPI api
    ) {
        return (AudiologyBooking) api.getResourceSet()
                .getResources()
                .get(0)
                .getContents()
                .get(0);
    }
}