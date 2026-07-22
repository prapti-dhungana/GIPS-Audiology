package audiologyoptimiser.api.matches;

import audiologymodel.AppointmentAssignment;
import audiologymodel.AppointmentRequest;
import audiologymodel.AudiologyBooking;
import audiologymodel.PlanningDay;
import audiologymodel.PlanningWeek;
import audiologymodel.Room;
import audiologymodel.StaffMember;
import audiologymodel.Timeslot;
import audiologyoptimiser.api.rules.AssignAppointmentRule;
import org.emoflon.ibex.common.operational.IMatch;
import org.emoflon.ibex.gt.api.GraphTransformationMatch;

/**
 * A match for the rule <code>assignAppointment()</code>.
 */
public class AssignAppointmentMatch extends GraphTransformationMatch<AssignAppointmentMatch, AssignAppointmentRule> {
	private AudiologyBooking varBooking;
	private PlanningDay varPlanningDay;
	private PlanningWeek varPlanningWeek;
	private AppointmentRequest varRequest;
	private Room varRoom;
	private StaffMember varStaffMember;
	private Timeslot varStartSlot;
	private AppointmentAssignment varAssignment;

	/**
	 * Creates a new match for the rule <code>assignAppointment()</code>.
	 * 
	 * @param pattern
	 *            the pattern
	 * @param match
	 *            the untyped match
	 */
	public AssignAppointmentMatch(final AssignAppointmentRule pattern, final IMatch match) {
		super(pattern, match);
		varBooking = (AudiologyBooking) match.get("booking");
		varPlanningDay = (PlanningDay) match.get("planningDay");
		varPlanningWeek = (PlanningWeek) match.get("planningWeek");
		varRequest = (AppointmentRequest) match.get("request");
		varRoom = (Room) match.get("room");
		varStaffMember = (StaffMember) match.get("staffMember");
		varStartSlot = (Timeslot) match.get("startSlot");
		varAssignment = (AppointmentAssignment) match.get("assignment");
	}

	/**
	 * Returns the booking.
	 *
	 * @return the booking
	 */
	public AudiologyBooking getBooking() {
		return varBooking;
	}

	/**
	 * Returns the planningDay.
	 *
	 * @return the planningDay
	 */
	public PlanningDay getPlanningDay() {
		return varPlanningDay;
	}

	/**
	 * Returns the planningWeek.
	 *
	 * @return the planningWeek
	 */
	public PlanningWeek getPlanningWeek() {
		return varPlanningWeek;
	}

	/**
	 * Returns the request.
	 *
	 * @return the request
	 */
	public AppointmentRequest getRequest() {
		return varRequest;
	}

	/**
	 * Returns the room.
	 *
	 * @return the room
	 */
	public Room getRoom() {
		return varRoom;
	}

	/**
	 * Returns the staffMember.
	 *
	 * @return the staffMember
	 */
	public StaffMember getStaffMember() {
		return varStaffMember;
	}

	/**
	 * Returns the startSlot.
	 *
	 * @return the startSlot
	 */
	public Timeslot getStartSlot() {
		return varStartSlot;
	}

	/**
	 * Returns the assignment.
	 *
	 * @return the assignment
	 */
	public AppointmentAssignment getAssignment() {
		return varAssignment;
	}

	@Override
	public String toString() {
		String s = "match {" + java.lang.System.lineSeparator();
		s += "	booking --> " + varBooking + java.lang.System.lineSeparator();
		s += "	planningDay --> " + varPlanningDay + java.lang.System.lineSeparator();
		s += "	planningWeek --> " + varPlanningWeek + java.lang.System.lineSeparator();
		s += "	request --> " + varRequest + java.lang.System.lineSeparator();
		s += "	room --> " + varRoom + java.lang.System.lineSeparator();
		s += "	staffMember --> " + varStaffMember + java.lang.System.lineSeparator();
		s += "	startSlot --> " + varStartSlot + java.lang.System.lineSeparator();
		s += "	assignment --> " + varAssignment + java.lang.System.lineSeparator();
		s += "} for " + getPattern();
		return s;
	}
}
