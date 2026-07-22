package audiologyoptimiser.api.rules;

import audiologymodel.AudiologyBooking;
import audiologymodel.PlanningDay;
import audiologymodel.StaffMember;
import audiologymodel.Timeslot;
import audiologyoptimiser.api.AudiologyoptimiserAPI;
import audiologyoptimiser.api.matches.StaffDaySlotTupleMatch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import org.emoflon.ibex.common.operational.IMatch;
import org.emoflon.ibex.gt.api.GraphTransformationPattern;
import org.emoflon.ibex.gt.engine.GraphTransformationInterpreter;

/**
 * The pattern [org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@eb2e30b (name: booking), org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@54ff0d80 (name: interval), org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@3834f818 (name: planningDay), org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@118ead0d (name: staffMember)] which does the following:
 * If this pattern is not self-explaining, you really should add some comment in the specification.
 */
@SuppressWarnings("unused")
public class StaffDaySlotTuplePattern extends GraphTransformationPattern<StaffDaySlotTupleMatch, StaffDaySlotTuplePattern> {
	private static String patternName = "staffDaySlotTuple";

	/**
	 * Creates a new pattern staffDaySlotTuple().
	 * 
	 * @param api
	 *            the API the pattern belongs to
	 * @param interpreter
	 *            the interpreter
	 */
	
	public StaffDaySlotTuplePattern(final AudiologyoptimiserAPI api, final GraphTransformationInterpreter interpreter) {
		super(api, interpreter, patternName);
	}

	@Override
	public StaffDaySlotTupleMatch convertMatch(final IMatch match) {
		return new StaffDaySlotTupleMatch(this, match);
	}

	@Override
	protected List<String> getParameterNames() {
		List<String> names = new ArrayList<String>();
		names.add("booking");
		names.add("interval");
		names.add("planningDay");
		names.add("staffMember");
		return names;
	}

	/**
	 * Binds the node booking to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffDaySlotTuplePattern bindBooking(final AudiologyBooking object) {
		parameters.put("booking", Objects.requireNonNull(object, "booking must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node booking to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffDaySlotTuplePattern unbindBooking() {
		parameters.remove("booking");
		return this;
	}

	/**
	 * Binds the node interval to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffDaySlotTuplePattern bindInterval(final Timeslot object) {
		parameters.put("interval", Objects.requireNonNull(object, "interval must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node interval to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffDaySlotTuplePattern unbindInterval() {
		parameters.remove("interval");
		return this;
	}

	/**
	 * Binds the node planningDay to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffDaySlotTuplePattern bindPlanningDay(final PlanningDay object) {
		parameters.put("planningDay", Objects.requireNonNull(object, "planningDay must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node planningDay to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffDaySlotTuplePattern unbindPlanningDay() {
		parameters.remove("planningDay");
		return this;
	}

	/**
	 * Binds the node staffMember to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffDaySlotTuplePattern bindStaffMember(final StaffMember object) {
		parameters.put("staffMember", Objects.requireNonNull(object, "staffMember must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node staffMember to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffDaySlotTuplePattern unbindStaffMember() {
		parameters.remove("staffMember");
		return this;
	}
	
	@Override
	public String toString() {
		String s = "pattern " + patternName + " {" + java.lang.System.lineSeparator();
		s += "	booking --> " + parameters.get("booking") + java.lang.System.lineSeparator();
		s += "	interval --> " + parameters.get("interval") + java.lang.System.lineSeparator();
		s += "	planningDay --> " + parameters.get("planningDay") + java.lang.System.lineSeparator();
		s += "	staffMember --> " + parameters.get("staffMember") + java.lang.System.lineSeparator();
		s += "}";
		return s;
	}
}
