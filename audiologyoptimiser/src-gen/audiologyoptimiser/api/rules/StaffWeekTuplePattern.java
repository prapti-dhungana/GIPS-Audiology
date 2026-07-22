package audiologyoptimiser.api.rules;

import audiologymodel.AudiologyBooking;
import audiologymodel.PlanningWeek;
import audiologymodel.StaffMember;
import audiologyoptimiser.api.AudiologyoptimiserAPI;
import audiologyoptimiser.api.matches.StaffWeekTupleMatch;
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
 * The pattern [org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@a657c4 (name: booking), org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@21f31b07 (name: planningWeek), org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@617b10a6 (name: staffMember)] which does the following:
 * If this pattern is not self-explaining, you really should add some comment in the specification.
 */
@SuppressWarnings("unused")
public class StaffWeekTuplePattern extends GraphTransformationPattern<StaffWeekTupleMatch, StaffWeekTuplePattern> {
	private static String patternName = "staffWeekTuple";

	/**
	 * Creates a new pattern staffWeekTuple().
	 * 
	 * @param api
	 *            the API the pattern belongs to
	 * @param interpreter
	 *            the interpreter
	 */
	
	public StaffWeekTuplePattern(final AudiologyoptimiserAPI api, final GraphTransformationInterpreter interpreter) {
		super(api, interpreter, patternName);
	}

	@Override
	public StaffWeekTupleMatch convertMatch(final IMatch match) {
		return new StaffWeekTupleMatch(this, match);
	}

	@Override
	protected List<String> getParameterNames() {
		List<String> names = new ArrayList<String>();
		names.add("booking");
		names.add("planningWeek");
		names.add("staffMember");
		return names;
	}

	/**
	 * Binds the node booking to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffWeekTuplePattern bindBooking(final AudiologyBooking object) {
		parameters.put("booking", Objects.requireNonNull(object, "booking must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node booking to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffWeekTuplePattern unbindBooking() {
		parameters.remove("booking");
		return this;
	}

	/**
	 * Binds the node planningWeek to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffWeekTuplePattern bindPlanningWeek(final PlanningWeek object) {
		parameters.put("planningWeek", Objects.requireNonNull(object, "planningWeek must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node planningWeek to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffWeekTuplePattern unbindPlanningWeek() {
		parameters.remove("planningWeek");
		return this;
	}

	/**
	 * Binds the node staffMember to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffWeekTuplePattern bindStaffMember(final StaffMember object) {
		parameters.put("staffMember", Objects.requireNonNull(object, "staffMember must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node staffMember to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffWeekTuplePattern unbindStaffMember() {
		parameters.remove("staffMember");
		return this;
	}
	
	@Override
	public String toString() {
		String s = "pattern " + patternName + " {" + java.lang.System.lineSeparator();
		s += "	booking --> " + parameters.get("booking") + java.lang.System.lineSeparator();
		s += "	planningWeek --> " + parameters.get("planningWeek") + java.lang.System.lineSeparator();
		s += "	staffMember --> " + parameters.get("staffMember") + java.lang.System.lineSeparator();
		s += "}";
		return s;
	}
}
