package audiologyoptimiser.api.rules;

import audiologymodel.AppointmentRequest;
import audiologymodel.AudiologyBooking;
import audiologymodel.PlanningDay;
import audiologymodel.PlanningWeek;
import audiologymodel.Room;
import audiologymodel.StaffMember;
import audiologymodel.Timeslot;
import audiologyoptimiser.api.AudiologyoptimiserAPI;
import audiologyoptimiser.api.matches.AssignAppointmentMatch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import org.emoflon.ibex.common.operational.IMatch;
import org.emoflon.ibex.gt.api.GraphTransformationRule;
import org.emoflon.ibex.gt.arithmetic.Probability;
import org.emoflon.ibex.gt.engine.GraphTransformationInterpreter;

/**
 * The rule <code>assignAppointment()</code> which does the following:
 * One match represents one locally feasible appointment assignment.
 */
@SuppressWarnings("unused")
public class AssignAppointmentRule extends GraphTransformationRule<AssignAppointmentMatch, AssignAppointmentRule> {
	private static String patternName = "assignAppointment";

	/**
	 * Creates a new rule assignAppointment().
	 * 
	 * @param api
	 *            the API the rule belongs to
	 * @param interpreter
	 *            the interpreter
	 */
	 
	/**
	 * The probability that the rule will be applied; if the rule has no probability,
	 * then the Optional will be empty
	 */

	public AssignAppointmentRule(final AudiologyoptimiserAPI api, final GraphTransformationInterpreter interpreter) {
		super(api, interpreter, patternName, Optional.empty());
	}

	@Override
	public AssignAppointmentMatch convertMatch(final IMatch match) {
		return new AssignAppointmentMatch(this, match);
	}

	@Override
	protected List<String> getParameterNames() {
		List<String> names = new ArrayList<String>();
		names.add("booking");
		names.add("planningDay");
		names.add("planningWeek");
		names.add("request");
		names.add("room");
		names.add("staffMember");
		names.add("startSlot");
		return names;
	}

	/**
	 * Binds the node booking to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public AssignAppointmentRule bindBooking(final AudiologyBooking object) {
		parameters.put("booking", Objects.requireNonNull(object, "booking must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node booking to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public AssignAppointmentRule unbindBooking() {
		parameters.remove("booking");
		return this;
	}

	/**
	 * Binds the node planningDay to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public AssignAppointmentRule bindPlanningDay(final PlanningDay object) {
		parameters.put("planningDay", Objects.requireNonNull(object, "planningDay must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node planningDay to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public AssignAppointmentRule unbindPlanningDay() {
		parameters.remove("planningDay");
		return this;
	}

	/**
	 * Binds the node planningWeek to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public AssignAppointmentRule bindPlanningWeek(final PlanningWeek object) {
		parameters.put("planningWeek", Objects.requireNonNull(object, "planningWeek must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node planningWeek to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public AssignAppointmentRule unbindPlanningWeek() {
		parameters.remove("planningWeek");
		return this;
	}

	/**
	 * Binds the node request to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public AssignAppointmentRule bindRequest(final AppointmentRequest object) {
		parameters.put("request", Objects.requireNonNull(object, "request must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node request to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public AssignAppointmentRule unbindRequest() {
		parameters.remove("request");
		return this;
	}

	/**
	 * Binds the node room to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public AssignAppointmentRule bindRoom(final Room object) {
		parameters.put("room", Objects.requireNonNull(object, "room must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node room to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public AssignAppointmentRule unbindRoom() {
		parameters.remove("room");
		return this;
	}

	/**
	 * Binds the node staffMember to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public AssignAppointmentRule bindStaffMember(final StaffMember object) {
		parameters.put("staffMember", Objects.requireNonNull(object, "staffMember must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node staffMember to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public AssignAppointmentRule unbindStaffMember() {
		parameters.remove("staffMember");
		return this;
	}

	/**
	 * Binds the node startSlot to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public AssignAppointmentRule bindStartSlot(final Timeslot object) {
		parameters.put("startSlot", Objects.requireNonNull(object, "startSlot must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node startSlot to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public AssignAppointmentRule unbindStartSlot() {
		parameters.remove("startSlot");
		return this;
	}
	@Override
	public boolean isMatchValid(IMatch match){
		return 
		((Timeslot) match.get("startSlot")).getStartIndex()+((AppointmentRequest) match.get("request")).getDurationSlots()<=((StaffMember) match.get("staffMember")).getAvailableToSlot()&&
		((Timeslot) match.get("startSlot")).getStartIndex()+((AppointmentRequest) match.get("request")).getDurationSlots()<=((Room) match.get("room")).getAvailableToSlot()&&
		((Timeslot) match.get("startSlot")).getStartIndex()+((AppointmentRequest) match.get("request")).getDurationSlots()<=32.0
		;
	}
	
	@Override
	public boolean containsArithmeticExpressions() {
		return true;
	}
	@Override
	public String toString() {
		String s = "rule " + patternName + " {" + java.lang.System.lineSeparator();
		s += "	booking --> " + parameters.get("booking") + java.lang.System.lineSeparator();
		s += "	planningDay --> " + parameters.get("planningDay") + java.lang.System.lineSeparator();
		s += "	planningWeek --> " + parameters.get("planningWeek") + java.lang.System.lineSeparator();
		s += "	request --> " + parameters.get("request") + java.lang.System.lineSeparator();
		s += "	room --> " + parameters.get("room") + java.lang.System.lineSeparator();
		s += "	staffMember --> " + parameters.get("staffMember") + java.lang.System.lineSeparator();
		s += "	startSlot --> " + parameters.get("startSlot") + java.lang.System.lineSeparator();
		s += "}";
		return s;
	}
}
