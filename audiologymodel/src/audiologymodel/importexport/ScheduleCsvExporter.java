package audiologymodel.importexport;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emoflon.smartemf.persistence.SmartEMFResourceFactoryImpl;

import audiologymodel.AppointmentAssignment;
import audiologymodel.AppointmentRequest;
import audiologymodel.AudiologyBooking;
import audiologymodel.AudiologymodelPackage;
import audiologymodel.PlanningDay;
import audiologymodel.Room;
import audiologymodel.StaffMember;
import audiologymodel.Timeslot;

public final class ScheduleCsvExporter {

    private static final int SLOT_LENGTH_MINUTES = 15;
    private static final LocalTime DAY_START = LocalTime.of(9, 0);

    private ScheduleCsvExporter() {
    }

    public static void export(
            Path optimisedXmi,
            Path outputCsv
    ) throws IOException {

        AudiologymodelPackage.eINSTANCE.eClass();

        ResourceSet resourceSet = new ResourceSetImpl();

        resourceSet.getPackageRegistry().put(
                AudiologymodelPackage.eNS_URI,
                AudiologymodelPackage.eINSTANCE
        );

        resourceSet.getResourceFactoryRegistry()
                .getExtensionToFactoryMap()
                .put(
                        "xmi",
                        new SmartEMFResourceFactoryImpl("../")
                );

        URI inputUri = URI.createFileURI(
                optimisedXmi.toAbsolutePath()
                        .normalize()
                        .toString()
        );

        Resource resource =
                resourceSet.getResource(inputUri, true);

        EcoreUtil.resolveAll(resourceSet);

        if (resource.getContents().isEmpty()) {
            throw new IOException(
                    "The XMI contains no AudiologyBooking root."
            );
        }

        AudiologyBooking booking =
                (AudiologyBooking) resource.getContents().get(0);

        Path absoluteOutput =
                outputCsv.toAbsolutePath().normalize();

        if (absoluteOutput.getParent() != null) {
            Files.createDirectories(absoluteOutput.getParent());
        }

        try (BufferedWriter writer =
                     Files.newBufferedWriter(absoluteOutput)) {

            writer.write(
                    "Appointment Number,"
                    + "Appointment Type,"
                    + "Staff Number,"
                    + "Staff Band,"
                    + "Room Number,"
                    + "Room Type,"
                    + "Day Index,"
                    + "Day Of Week,"
                    + "Start Slot,"
                    + "Start Time,"
                    + "End Time,"
                    + "Duration Minutes,"
                    + "Ideal Day Index,"
                    + "Delay Days"
            );

            writer.newLine();

            for (AppointmentAssignment assignment :
                    booking.getAppointmentAssignments()) {

                writeAssignment(writer, assignment);
            }
        }

        System.out.println(
                "Exported "
                        + booking.getAppointmentAssignments().size()
                        + " scheduled appointments to:"
        );
        System.out.println(absoluteOutput);
    }

    private static void writeAssignment(
            BufferedWriter writer,
            AppointmentAssignment assignment
    ) throws IOException {

        AppointmentRequest request =
                assignment.getRequest();

        StaffMember staff =
                assignment.getStaffMember();

        Room room =
                assignment.getRoom();

        PlanningDay day =
                assignment.getPlanningDay();

        Timeslot slot =
                assignment.getStartSlot();

        if (request == null
                || staff == null
                || room == null
                || day == null
                || slot == null) {

            throw new IOException(
                    "An AppointmentAssignment has a missing reference."
            );
        }

        int startIndex = slot.getStartIndex();

        int durationMinutes =
                request.getDurationSlots()
                        * SLOT_LENGTH_MINUTES;

        LocalTime startTime =
                DAY_START.plusMinutes(
                        (long) startIndex
                                * SLOT_LENGTH_MINUTES
                );

        LocalTime endTime =
                startTime.plusMinutes(durationMinutes);

        int delayDays = Math.max(
                0,
                day.getDayIndex()
                        - request.getIdealDayIndex()
        );

        writer.write(
                request.getNumber() + ","
                + request.getAppointmentType() + ","
                + staff.getNumber() + ","
                + staff.getBand() + ","
                + room.getNumber() + ","
                + room.getRoomType() + ","
                + day.getDayIndex() + ","
                + day.getDayOfWeek() + ","
                + startIndex + ","
                + startTime + ","
                + endTime + ","
                + durationMinutes + ","
                + request.getIdealDayIndex() + ","
                + delayDays
        );

        writer.newLine();
    }
}