package audiologyoptimiser.api.rules;

import audiologymodel.AudiologyBooking;
import audiologymodel.PlanningDay;
import audiologymodel.Room;
import audiologymodel.StaffMember;
import audiologyoptimiser.api.AudiologyoptimiserAPI;
import audiologyoptimiser.api.matches.StaffRoomDayTupleMatch;
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
 * The pattern [org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@5d8b49d (name: booking), org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@755b627c (name: planningDay), org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@71503aa0 (name: room), org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@69f63b21 (name: staffMember)] which does the following:
 * If this pattern is not self-explaining, you really should add some comment in the specification.
 */
@SuppressWarnings("unused")
public class StaffRoomDayTuplePattern extends GraphTransformationPattern<StaffRoomDayTupleMatch, StaffRoomDayTuplePattern> {
	private static String patternName = "staffRoomDayTuple";

	/**
	 * Creates a new pattern staffRoomDayTuple().
	 * 
	 * @param api
	 *            the API the pattern belongs to
	 * @param interpreter
	 *            the interpreter
	 */
	
	public StaffRoomDayTuplePattern(final AudiologyoptimiserAPI api, final GraphTransformationInterpreter interpreter) {
		super(api, interpreter, patternName);
	}

	@Override
	public StaffRoomDayTupleMatch convertMatch(final IMatch match) {
		return new StaffRoomDayTupleMatch(this, match);
	}

	@Override
	protected List<String> getParameterNames() {
		List<String> names = new ArrayList<String>();
		names.add("booking");
		names.add("planningDay");
		names.add("room");
		names.add("staffMember");
		return names;
	}

	/**
	 * Binds the node booking to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffRoomDayTuplePattern bindBooking(final AudiologyBooking object) {
		parameters.put("booking", Objects.requireNonNull(object, "booking must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node booking to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffRoomDayTuplePattern unbindBooking() {
		parameters.remove("booking");
		return this;
	}

	/**
	 * Binds the node planningDay to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffRoomDayTuplePattern bindPlanningDay(final PlanningDay object) {
		parameters.put("planningDay", Objects.requireNonNull(object, "planningDay must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node planningDay to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffRoomDayTuplePattern unbindPlanningDay() {
		parameters.remove("planningDay");
		return this;
	}

	/**
	 * Binds the node room to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffRoomDayTuplePattern bindRoom(final Room object) {
		parameters.put("room", Objects.requireNonNull(object, "room must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node room to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffRoomDayTuplePattern unbindRoom() {
		parameters.remove("room");
		return this;
	}

	/**
	 * Binds the node staffMember to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffRoomDayTuplePattern bindStaffMember(final StaffMember object) {
		parameters.put("staffMember", Objects.requireNonNull(object, "staffMember must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node staffMember to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public StaffRoomDayTuplePattern unbindStaffMember() {
		parameters.remove("staffMember");
		return this;
	}
	
	@Override
	public String toString() {
		String s = "pattern " + patternName + " {" + java.lang.System.lineSeparator();
		s += "	booking --> " + parameters.get("booking") + java.lang.System.lineSeparator();
		s += "	planningDay --> " + parameters.get("planningDay") + java.lang.System.lineSeparator();
		s += "	room --> " + parameters.get("room") + java.lang.System.lineSeparator();
		s += "	staffMember --> " + parameters.get("staffMember") + java.lang.System.lineSeparator();
		s += "}";
		return s;
	}
}
