package audiologyrunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.logging.Logger;

import org.emoflon.gips.core.milp.SolverOutput;

import audiologyoptimiser.api.gips.AudiologyoptimiserGipsAPI;
import audiologyrunner.utils.LoggerUtils;
import audiologyrunner.utils.XmiSetupUtils;
import audiologymodel.AudiologyBooking;

public class AudiologyHeadlessRunner {

	/**
	 * Logger for system outputs.
	 */
	protected static final Logger logger = Logger.getLogger(AudiologyHeadlessRunner.class.getName());

	/**
	 * Input model path.
	 */
	private static String inputModelPath = "./initial_model.xmi";

	/**
	 * Output model path.
	 */
	private static String outputModelPath = "./optimized_model.xmi";

	/**
	 * Main method to run the complete project. First argument is the number of
	 * guest nodes to generate and second argument is the number of host nodes to
	 * generate.
	 * 
	 * @param args Arguments (see above).
	 */
	public static void main(final String[] args) {
		Objects.requireNonNull(args);
		if (args.length != 3) {
			throw new IllegalArgumentException("Number of given arguments must be equal to 3.");
		}

		// Configure logging
		LoggerUtils.configureLogging(logger);

		// Parse arguments
		// 0: number of guests to generate
		// 1: number of hosts to generate
		// final int numberOfGuests = Integer.valueOf(args[0]);
		// final int numberOfHosts = Integer.valueOf(args[1]);
		
		//temporary hard coded paths
		inputModelPath = Path.of(args[0]).toAbsolutePath().normalize().toString();
		outputModelPath = Path.of(args[1]).toAbsolutePath().normalize().toString();
		final int numberOfRuns = Integer.valueOf(args[2]);

		if (numberOfRuns <= 0) {
			throw new IllegalArgumentException("Number of runs must be greater than zero.");
		}

		// Generate the corresponding model
		if (!Files.isRegularFile(Path.of(inputModelPath))) {
			throw new IllegalArgumentException(
					"Input XMI model does not exist: " + inputModelPath);
		}
		
		
		// Persist initial model
		final Path outputParent = Path.of(outputModelPath).getParent();

		if (outputParent != null) {
			try {
				Files.createDirectories(outputParent);
			} catch (final IOException e) {
				throw new IllegalStateException(
						"Could not create output directory: " + outputParent, e);
			}
		}

		for (int run = 1; run <= numberOfRuns; run++) {
			logger.info("GIPS run " + run + " of " + numberOfRuns + " started.");
			final long startTime = System.nanoTime();

			// Initialize GIPS
			final AudiologyoptimiserGipsAPI api = new AudiologyoptimiserGipsAPI();
			XmiSetupUtils.checkIfEclipseOrJarSetup(api, inputModelPath);

			// Build MILP problem
			api.buildProblem(true, true);

			// Solve MILP problem
			try (final SolverOutput output = api.solveProblemTimed()) {
				logger.info("=> Solver status: " + output.status());
				
				final String validation = output.toString();
				logger.info("=> Constraints violated: " + (validation.contains("Constant_Constraint_Violation") || validation.contains("Variable_Constraint_Violation")));
				
				if (output.solutionCount() == 0) {
					api.terminate();
					logger.warning("No solution found. Aborting.");
					throw new InternalError("No solution found!");
				}
				logger.info("=> Objective value: " + output.objectiveValue());
			} catch (final OutOfMemoryError err) {
				logger.warning("GIPS solving threw an OOM error. GIPS now terminates the Java process.");
				System.exit(1);
			}

			// Apply solution with GIPS
			api.applyAllNonZeroMappings();
			
			//checks for unmapped appointments
			final AudiologyBooking booking = (AudiologyBooking) api.getResourceSet().getResources().get(0).getContents().get(0);
			final long bookedAppointments = booking.getAppointmentAssignments().stream().map(assignment -> assignment.getRequest()).filter(Objects::nonNull).distinct().count();

			logger.info("=> Appointments booked: " + bookedAppointments);
			logger.info("=> Appointments not booked: " + (booking.getWaitingList().size() - bookedAppointments));

			// Persist model
			try {
				api.saveResult(outputModelPath);
			} catch (final IOException e) {
				e.printStackTrace();
				System.exit(1);
			}

			api.terminate();

			final double runTime = (System.nanoTime() - startTime) / 1_000_000_000.0;
			logger.info("=> Run time: " + runTime + " seconds.");
		}

		// Finish
		logger.info("GIPS run finished.");
		System.exit(0);
	}

}