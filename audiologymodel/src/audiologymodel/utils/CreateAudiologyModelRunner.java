package audiologymodel.utils;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import audiologymodel.AudiologyBooking;
import audiologymodel.importexport.CsvToModelLoader;

/**
 * Command-line runner for:
 * rooms.csv + staff.csv + appointments.csv -> AudiologyBooking.xmi
 */
public final class CreateAudiologyModelRunner {

    private CreateAudiologyModelRunner() {
    }

    public static void main(String[] args) {
        if (args.length != 6 && args.length != 7) {
            printUsage();
            System.exit(2);
        }

        try {
            Path roomsCsv = absolutePath(args[0]);
            Path staffCsv = absolutePath(args[1]);
            Path appointmentsCsv = absolutePath(args[2]);
            Path outputXmi = absolutePath(args[3]);

            LocalDate planningStartDate =
                    LocalDate.parse(args[4]);

            int numberOfWorkingDays = parseInteger(
                    args[5],
                    "numberOfWorkingDays"
            );

            int maximumAppointments = args.length == 7
                    ? parseInteger(args[6], "maximumAppointments")
                    : 0;

            System.out.println("Audiology CSV-to-XMI Import");
            System.out.println("Rooms CSV:       " + roomsCsv);
            System.out.println("Staff CSV:       " + staffCsv);
            System.out.println("Appointments:    " + appointmentsCsv);
            System.out.println("Output XMI:      " + outputXmi);
            System.out.println("Planning start:  " + planningStartDate);
            System.out.println("Working days:    " + numberOfWorkingDays);
            System.out.println(
                    "Appointment limit: "
                            + (maximumAppointments > 0
                            ? maximumAppointments
                            : "all rows")
            );

            CsvToModelLoader loader = new CsvToModelLoader();
            AudiologyBooking booking = loader.load(
                    roomsCsv,
                    staffCsv,
                    appointmentsCsv,
                    planningStartDate,
                    numberOfWorkingDays,
                    maximumAppointments
            );

            CsvToModelLoader.save(booking, outputXmi);

            System.out.println();
            System.out.println("Created model summary:");
            System.out.println(
                    "Appointment requests: "
                            + booking.getWaitingList().size()
            );
            System.out.println(
                    "Staff members:        "
                            + booking.getStaff().size()
            );
            System.out.println(
                    "Rooms:                "
                            + booking.getRooms().size()
            );
            System.out.println(
                    "Planning weeks:       "
                            + booking.getWeeks().size()
            );
            System.out.println(
                    "Planning days:        "
                            + booking.getDays().size()
            );
            System.out.println(
                    "Timeslots:            "
                            + booking.getTimeslots().size()
            );
            System.out.println(
                    "Initial assignments:  "
                            + booking.getAppointmentAssignments().size()
            );
            System.out.println("Import completed successfully.");

        } catch (DateTimeParseException exception) {
            System.err.println(
                    "Planning start date must use YYYY-MM-DD."
            );
            exception.printStackTrace();
            System.exit(1);

        } catch (Exception exception) {
            System.err.println("CSV-to-XMI import failed.");
            exception.printStackTrace();
            System.exit(1);
        }
    }

    private static Path absolutePath(String value) {
        return Path.of(value)
                .toAbsolutePath()
                .normalize();
    }

    private static int parseInteger(
            String value,
            String argumentName
    ) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    argumentName + " must be an integer, but found: "
                            + value,
                    exception
            );
        }
    }

    private static void printUsage() {
        System.err.println(
                "Usage: CreateAudiologyModelRunner "
                        + "<rooms.csv> <staff.csv> <appointments.csv> "
                        + "<output.xmi> <planningStart:YYYY-MM-DD> "
                        + "<numberOfWorkingDays> [maximumAppointments]"
        );
        System.err.println(
                "Use zero or omit maximumAppointments to import all rows."
        );
    }
}