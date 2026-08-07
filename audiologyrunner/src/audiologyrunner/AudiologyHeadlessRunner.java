package audiologyrunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import org.emoflon.gips.core.milp.SolverOutput;

import audiologymodel.AudiologyBooking;
import audiologymodel.Room;
import audiologymodel.StaffMember;
import audiologyoptimiser.api.gips.AudiologyoptimiserGipsAPI;
import audiologyrunner.utils.LoggerUtils;
import audiologyrunner.utils.XmiSetupUtils;

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
			long phaseStart;

			// Initialize GIPS
			logger.info("=> Initializing GIPS...");
			phaseStart = System.nanoTime();

			final AudiologyoptimiserGipsAPI api = new AudiologyoptimiserGipsAPI();
			XmiSetupUtils.checkIfEclipseOrJarSetup(api, inputModelPath);

			final double initializationTime =
					(System.nanoTime() - phaseStart) / 1_000_000_000.0;
			logger.info("=> Initialization time: "
					+ initializationTime + " seconds.");

			// Build MILP problem
			logger.info("=> Building MILP problem...");
			phaseStart = System.nanoTime();

			api.buildProblem(true, true);

			final double buildTime =
					(System.nanoTime() - phaseStart) / 1_000_000_000.0;
			logger.info("=> MILP build time: "
					+ buildTime + " seconds.");

			// Solve MILP problem
			logger.info("=> Solving MILP problem...");
			phaseStart = System.nanoTime();

			try (final SolverOutput output = api.solveProblemTimed()) {
				final double solveTime =
						(System.nanoTime() - phaseStart) / 1_000_000_000.0;
				logger.info("=> MILP solve time: "
						+ solveTime + " seconds.");

				logger.info("=> Solver status: " + output.status());

				final String validation = output.toString();
				logger.info("=> Constraints violated: "
						+ (validation.contains("Constant_Constraint_Violation")
						|| validation.contains("Variable_Constraint_Violation")));

				if (output.solutionCount() == 0) {
					api.terminate();
					logger.warning("No solution found. Aborting.");
					throw new InternalError("No solution found!");
				}

				logger.info("=> Objective value: " + output.objectiveValue());
			} catch (final OutOfMemoryError err) {
				logger.warning(
						"GIPS solving threw an OOM error. GIPS now terminates the Java process.");
				System.exit(1);
			}

			// Apply solution with GIPS
			logger.info("=> Applying non-zero mappings...");
			phaseStart = System.nanoTime();
			
			//Apply solution with GIPS
			api.applyAllNonZeroMappings(false);

			final double applicationTime =
					(System.nanoTime() - phaseStart) / 1_000_000_000.0;
			logger.info("=> Mapping application time: "
					+ applicationTime + " seconds.");

			//checks for unmapped appointments
			phaseStart = System.nanoTime();

			final AudiologyBooking booking =
					(AudiologyBooking) api.getResourceSet()
							.getResources()
							.get(0)
							.getContents()
							.get(0);

			final long bookedAppointments =
					booking.getAppointmentAssignments()
							.stream()
							.map(assignment -> assignment.getRequest())
							.filter(Objects::nonNull)
							.distinct()
							.count();

			logger.info("=> Appointments booked: " + bookedAppointments);
			logger.info("=> Appointments not booked: "
					+ (booking.getWaitingList().size() - bookedAppointments));

			printUtilisation(booking);

			final double appointmentCheckTime =
					(System.nanoTime() - phaseStart) / 1_000_000_000.0;
			logger.info("=> Appointment check time: "
					+ appointmentCheckTime + " seconds.");

			// Persist model
			logger.info("=> Saving optimized model...");
			phaseStart = System.nanoTime();

			try {
				api.saveResult(outputModelPath);
			} catch (final IOException e) {
				e.printStackTrace();
				System.exit(1);
			}

			final double saveTime =
					(System.nanoTime() - phaseStart) / 1_000_000_000.0;
			logger.info("=> Model save time: "
					+ saveTime + " seconds.");

			logger.info("=> Terminating GIPS...");
			phaseStart = System.nanoTime();

			api.terminate();

			final double terminationTime =
					(System.nanoTime() - phaseStart) / 1_000_000_000.0;
			logger.info("=> Termination time: "
					+ terminationTime + " seconds.");

			final double runTime =
					(System.nanoTime() - startTime) / 1_000_000_000.0;
			logger.info("=> Run time: " + runTime + " seconds.");
		}
		
		// Finish
		logger.info("GIPS run finished.");
		System.exit(0);
	}

	private static void printUtilisation(final AudiologyBooking booking) {
		final int slotMinutes = 15;
		final List<Double> staffUtilisation = new ArrayList<>();
		final List<Double> roomUtilisation = new ArrayList<>();

		for (final StaffMember staff : booking.getStaff()) {
			final long workingWeeks =
					staff.getWorkingDays()
							.stream()
							.map(day -> day.getWeek())
							.distinct()
							.count();

			if (workingWeeks == 0 || staff.getWeeklyHours() <= 0) {
				continue;
			}

			final int usedMinutes =
					booking.getAppointmentAssignments()
							.stream()
							.filter(assignment ->
									assignment.getStaffMember() == staff)
							.mapToInt(assignment ->
									assignment.getRequest()
											.getDurationSlots()
									* slotMinutes)
							.sum();

			final double availableMinutes =
					staff.getWeeklyHours()
					* 60.0
					* workingWeeks;

			staffUtilisation.add(
					100.0 * usedMinutes / availableMinutes);
		}

		for (final Room room : booking.getRooms()) {
			final long availableMinutes =
					room.getOpenDays().size()
					* (room.getAvailableToSlot()
					- room.getAvailableFromSlot())
					* slotMinutes;

			if (availableMinutes == 0) {
				continue;
			}

			final int usedMinutes =
					booking.getAppointmentAssignments()
							.stream()
							.filter(assignment ->
									assignment.getRoom() == room)
							.mapToInt(assignment ->
									assignment.getRequest()
											.getDurationSlots()
									* slotMinutes)
							.sum();

			roomUtilisation.add(
					100.0 * usedMinutes / availableMinutes);
		}

		printStatistics("Staff", staffUtilisation);
		printStatistics("Room", roomUtilisation);
	}

	private static void printStatistics(
			final String resource,
			final List<Double> values) {

		final double mean =
				values.stream()
						.mapToDouble(Double::doubleValue)
						.average()
						.orElse(0);

		final double standardDeviation =
				Math.sqrt(
						values.stream()
								.mapToDouble(value ->
										Math.pow(value - mean, 2))
								.average()
								.orElse(0));

		logger.info("=> Mean " + resource
				+ " utilisation across all planning weeks: "
				+ String.format("%.2f", mean) + "%");

		logger.info("=> " + resource
				+ " utilisation standard deviation across all planning weeks: "
				+ String.format("%.2f", standardDeviation)
				+ "%");
	}
}