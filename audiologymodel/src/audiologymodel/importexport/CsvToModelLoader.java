package audiologymodel.importexport;

import audiologymodel.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.util.*;

/** Converts the three mock CSV files into one AudiologyBooking model. */
public final class CsvToModelLoader {
    public static final int SLOT_LENGTH_MINUTES = 15;
    public static final int SLOTS_PER_DAY = 32;

    private static final DateTimeFormatter CSV_DATE_FORMAT =
            DateTimeFormatter.ofPattern("M/d/uuuu", Locale.UK)
                    .withResolverStyle(ResolverStyle.STRICT);

    private final AudiologymodelFactory factory = AudiologymodelFactory.eINSTANCE;

    public AudiologyBooking load(Path roomsCsv, Path staffCsv,
            Path appointmentsCsv, LocalDate planningStartDate,
            int numberOfWorkingDays, int maximumAppointments) throws IOException {

        Objects.requireNonNull(roomsCsv, "roomsCsv");
        Objects.requireNonNull(staffCsv, "staffCsv");
        Objects.requireNonNull(appointmentsCsv, "appointmentsCsv");
        Objects.requireNonNull(planningStartDate, "planningStartDate");

        if (numberOfWorkingDays <= 0)
            throw new IllegalArgumentException(
                    "numberOfWorkingDays must be greater than zero.");

        requireRegularFile(roomsCsv, "Rooms CSV");
        requireRegularFile(staffCsv, "Staff CSV");
        requireRegularFile(appointmentsCsv, "Appointments CSV");

        AudiologyBooking booking = factory.createAudiologyBooking();
        createPlanningCalendar(booking, planningStartDate, numberOfWorkingDays);
        createTimeslots(booking);
        loadRooms(booking, roomsCsv);
        loadStaff(booking, staffCsv);
        loadAppointments(booking, appointmentsCsv, planningStartDate,
                maximumAppointments);
        validateProblemInstance(booking);
        return booking;
    }

    private void createPlanningCalendar(AudiologyBooking booking,
            LocalDate planningStartDate, int numberOfWorkingDays) {

        Map<Integer, PlanningWeek> weeksByIndex = new LinkedHashMap<>();
        LocalDate firstWeekMonday = planningStartDate.with(
                TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        int addedWorkingDays = 0;

        for (LocalDate date = planningStartDate;
                addedWorkingDays < numberOfWorkingDays;
                date = date.plusDays(1)) {

            if (isWeekend(date.getDayOfWeek())) continue;

            int dayIndex = dayIndex(planningStartDate, date);
            LocalDate dateWeekMonday = date.with(
                    TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            int weekIndex = Math.toIntExact(
                    ChronoUnit.WEEKS.between(firstWeekMonday, dateWeekMonday));

            PlanningWeek week = weeksByIndex.computeIfAbsent(weekIndex, key -> {
                PlanningWeek created = factory.createPlanningWeek();
                created.setWeekIndex(key);
                booking.getWeeks().add(created);
                return created;
            });

            PlanningDay day = factory.createPlanningDay();
            day.setDayIndex(dayIndex);
            day.setDayOfWeek(toDays(date.getDayOfWeek()));
            day.setWeek(week);
            booking.getDays().add(day);
            addedWorkingDays++;
        }
    }

    private void createTimeslots(AudiologyBooking booking) {
        for (int startIndex = 0; startIndex < SLOTS_PER_DAY; startIndex++) {
            Timeslot slot = factory.createTimeslot();
            slot.setStartIndex(startIndex);
            booking.getTimeslots().add(slot);
        }
    }

    private void loadRooms(AudiologyBooking booking, Path roomsCsv)
            throws IOException {

        for (Map<String, String> row : readCsv(roomsCsv, 0)) {
            Room room = factory.createRoom();
            room.setNumber(requiredInt(row, "Room Number"));
            room.setRoomType(toRoomType(required(row, "Room Type")));
            room.setAvailableFromSlot(0);
            room.setAvailableToSlot(SLOTS_PER_DAY);

            EnumSet<Days> openWeekdays = parseDays(required(row, "Open Days"));
            for (PlanningDay day : booking.getDays())
                if (openWeekdays.contains(day.getDayOfWeek()))
                    room.getOpenDays().add(day);

            if (room.getOpenDays().isEmpty())
                throw new IllegalArgumentException(
                        "Room " + room.getNumber()
                                + " has no open day in the planning horizon.");

            booking.getRooms().add(room);
        }
    }

    private void loadStaff(AudiologyBooking booking, Path staffCsv)
            throws IOException {

        for (Map<String, String> row : readCsv(staffCsv, 0)) {
            StaffMember staff = factory.createStaffMember();
            staff.setNumber(requiredInt(row, "Staff Number"));
            staff.setBand(requiredInt(row, "Band"));
            staff.setWeeklyHours(requiredInt(row, "Weekly Hours"));
            staff.setArtsFlag(parseBoolean01(required(row, "Arts Flag")));
            staff.setAvailableFromSlot(0);
            staff.setAvailableToSlot(SLOTS_PER_DAY);

            EnumSet<Days> workingWeekdays =
                    parseDays(required(row, "Working Days"));
            for (PlanningDay day : booking.getDays())
                if (workingWeekdays.contains(day.getDayOfWeek()))
                    staff.getWorkingDays().add(day);

            if (staff.getWorkingDays().isEmpty())
                throw new IllegalArgumentException(
                        "Staff member " + staff.getNumber()
                                + " has no working day in the planning horizon.");

            booking.getStaff().add(staff);
        }
    }

    private void loadAppointments(AudiologyBooking booking,
            Path appointmentsCsv, LocalDate planningStartDate,
            int maximumAppointments) throws IOException {

        List<Map<String, String>> rows =
                readCsv(appointmentsCsv, maximumAppointments);

        for (Map<String, String> row : rows) {
            AppointmentRequest request = factory.createAppointmentRequest();
            request.setNumber(requiredInt(row, "Appointment Number"));
            request.setRoomRequirement(
                    toRoomType(required(row, "Room Requirement")));
            request.setStaffBandRequirement(
                    requiredInt(row, "Staff Band Requirement"));
            int appointmentType = requiredInt(row, "Appointment Type");
            request.setAppointmentType(appointmentType);
            request.setPriorityWeight(toPriorityWeight(appointmentType));
            request.setArtsFlag(parseBoolean01(required(row, "Arts Flag")));

            int durationMinutes = requiredInt(row, "Appointment Duration");
            if (durationMinutes <= 0
                    || durationMinutes % SLOT_LENGTH_MINUTES != 0)
                throw new IllegalArgumentException(
                        "Appointment " + request.getNumber()
                                + " has duration " + durationMinutes
                                + "; durations must be positive multiples of "
                                + SLOT_LENGTH_MINUTES + " minutes.");

            request.setDurationSlots(durationMinutes / SLOT_LENGTH_MINUTES);

            LocalDate bookFrom = LocalDate.parse(
                    required(row, "Date to book from"), CSV_DATE_FORMAT);
            LocalDate ideal = LocalDate.parse(
                    required(row, "Date ideally booked by"), CSV_DATE_FORMAT);

            request.setBookFromDayIndex(
                    dayIndex(planningStartDate, bookFrom));
            request.setIdealDayIndex(dayIndex(planningStartDate, ideal));
            booking.getWaitingList().add(request);
        }

        System.out.println("Loaded " + rows.size() + " appointment rows.");
    }

    private static void validateProblemInstance(AudiologyBooking booking) {
        if (booking.getWaitingList().isEmpty())
            throw new IllegalArgumentException(
                    "The model contains no appointment requests.");
        if (booking.getStaff().isEmpty())
            throw new IllegalArgumentException(
                    "The model contains no staff members.");
        if (booking.getRooms().isEmpty())
            throw new IllegalArgumentException(
                    "The model contains no rooms.");
        if (booking.getDays().isEmpty() || booking.getWeeks().isEmpty()
                || booking.getTimeslots().size() != SLOTS_PER_DAY)
            throw new IllegalArgumentException(
                    "The planning calendar is incomplete.");
    }

    public static void save(AudiologyBooking booking, Path outputXmi)
            throws IOException {
        AudiologyModelIO.save(booking, outputXmi);
    }

    private static List<Map<String, String>> readCsv(
            Path path, int maximumRows) throws IOException {

        List<Map<String, String>> rows = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(
                path, StandardCharsets.UTF_8)) {

            String headerLine = reader.readLine();
            if (headerLine == null) return rows;

            List<String> headers = splitCsvLine(headerLine);
            headers.set(0, removeUtf8Bom(headers.get(0)).trim());

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;

                List<String> values = splitCsvLine(line);
                Map<String, String> row = new LinkedHashMap<>();
                for (int column = 0; column < headers.size(); column++) {
                    String value =
                            column < values.size() ? values.get(column) : "";
                    row.put(headers.get(column).trim(), value.trim());
                }

                rows.add(row);
                if (maximumRows > 0 && rows.size() >= maximumRows) break;
            }
        }

        return rows;
    }

    private static List<String> splitCsvLine(String line) {
        List<String> values = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (int index = 0; index < line.length(); index++) {
            char character = line.charAt(index);

            if (character == '"') {
                if (inQuotes && index + 1 < line.length()
                        && line.charAt(index + 1) == '"') {
                    current.append('"');
                    index++;
                } else inQuotes = !inQuotes;
            } else if (character == ',' && !inQuotes) {
                values.add(current.toString());
                current.setLength(0);
            } else current.append(character);
        }

        if (inQuotes)
            throw new IllegalArgumentException(
                    "Unclosed quoted CSV field: " + line);

        values.add(current.toString());
        return values;
    }

    private static EnumSet<Days> parseDays(String text) {
        if (text == null || text.isBlank())
            throw new IllegalArgumentException(
                    "Working/open days must not be empty.");

        String cleaned = text.trim().toUpperCase(Locale.ROOT)
                .replaceAll("\\s*-\\s*", "-");

        if (cleaned.equals("MON-FRI")
                || cleaned.equals("MONDAY-FRIDAY"))
            return EnumSet.allOf(Days.class);

        if (cleaned.equals("MON-THU")
                || cleaned.equals("MONDAY-THURSDAY"))
            return EnumSet.of(Days.MONDAY, Days.TUESDAY,
                    Days.WEDNESDAY, Days.THURSDAY);

        EnumSet<Days> result = EnumSet.noneOf(Days.class);
        for (String token : cleaned.split("\\s*,\\s*")) {
            switch (token) {
                case "MON", "MONDAY" -> result.add(Days.MONDAY);
                case "TUE", "TUES", "TUESDAY" ->
                        result.add(Days.TUESDAY);
                case "WED", "WEDNESDAY" ->
                        result.add(Days.WEDNESDAY);
                case "THU", "THUR", "THURS", "THURSDAY" ->
                        result.add(Days.THURSDAY);
                case "FRI", "FRIDAY" -> result.add(Days.FRIDAY);
                default -> throw new IllegalArgumentException(
                        "Unknown weekday '" + token
                                + "' in CSV value '" + text + "'.");
            }
        }
        return result;
    }

    private static int requiredInt(Map<String, String> row, String header) {
        String value = required(row, header);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    "Column '" + header
                            + "' must contain an integer, but found '"
                            + value + "'.",
                    exception);
        }
    }

    private static String required(Map<String, String> row, String header) {
        String value = row.get(header);
        if (value == null || value.isBlank())
            throw new IllegalArgumentException(
                    "Missing required CSV value for column '"
                            + header + "'.");
        return value.trim();
    }

    private static boolean parseBoolean01(String value) {
        return switch (value.trim().toLowerCase(Locale.ROOT)) {
            case "1", "true", "yes" -> true;
            case "0", "false", "no" -> false;
            default -> throw new IllegalArgumentException(
                    "Expected 0/1 or true/false, but found: " + value);
        };
    }

    private static int toPriorityWeight(int appointmentType) {
        return switch (appointmentType) {
            case 0 -> 4;
            case 1 -> 3;
            case 2 -> 2;
            case 3 -> 1;
            default -> throw new IllegalArgumentException(
                    "Unknown appointment type: " + appointmentType);
        };
    }

    private static RoomType toRoomType(String value) {
        return switch (value.trim().toUpperCase(Locale.ROOT)) {
            case "BOOTH" -> RoomType.BOOTH;
            case "ROOM" -> RoomType.ROOM;
            default -> throw new IllegalArgumentException(
                    "Unknown room type: " + value);
        };
    }

    private static Days toDays(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY -> Days.MONDAY;
            case TUESDAY -> Days.TUESDAY;
            case WEDNESDAY -> Days.WEDNESDAY;
            case THURSDAY -> Days.THURSDAY;
            case FRIDAY -> Days.FRIDAY;
            default -> throw new IllegalArgumentException(
                    "Weekend is not a working day: " + dayOfWeek);
        };
    }

    private static boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.SATURDAY
                || dayOfWeek == DayOfWeek.SUNDAY;
    }

    private static int dayIndex(
            LocalDate planningStartDate, LocalDate date) {
        return Math.toIntExact(
                ChronoUnit.DAYS.between(planningStartDate, date));
    }

    private static void requireRegularFile(Path path, String label) {
        if (!Files.isRegularFile(path))
            throw new IllegalArgumentException(
                    label + " does not exist: "
                            + path.toAbsolutePath().normalize());
    }

    private static String removeUtf8Bom(String text) {
        return text.startsWith("\uFEFF") ? text.substring(1) : text;
    }
}