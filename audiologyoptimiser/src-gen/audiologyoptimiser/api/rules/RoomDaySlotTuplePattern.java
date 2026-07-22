package audiologyoptimiser.api.rules;

import audiologymodel.AudiologyBooking;
import audiologymodel.PlanningDay;
import audiologymodel.Room;
import audiologymodel.Timeslot;
import audiologyoptimiser.api.AudiologyoptimiserAPI;
import audiologyoptimiser.api.matches.RoomDaySlotTupleMatch;
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
 * The pattern [org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@66d56ee9 (name: booking), org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@39f44e2f (name: interval), org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@f95c00b (name: planningDay), org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@50e42919 (name: room)] which does the following:
 * If this pattern is not self-explaining, you really should add some comment in the specification.
 */
@SuppressWarnings("unused")
public class RoomDaySlotTuplePattern extends GraphTransformationPattern<RoomDaySlotTupleMatch, RoomDaySlotTuplePattern> {
	private static String patternName = "roomDaySlotTuple";

	/**
	 * Creates a new pattern roomDaySlotTuple().
	 * 
	 * @param api
	 *            the API the pattern belongs to
	 * @param interpreter
	 *            the interpreter
	 */
	
	public RoomDaySlotTuplePattern(final AudiologyoptimiserAPI api, final GraphTransformationInterpreter interpreter) {
		super(api, interpreter, patternName);
	}

	@Override
	public RoomDaySlotTupleMatch convertMatch(final IMatch match) {
		return new RoomDaySlotTupleMatch(this, match);
	}

	@Override
	protected List<String> getParameterNames() {
		List<String> names = new ArrayList<String>();
		names.add("booking");
		names.add("interval");
		names.add("planningDay");
		names.add("room");
		return names;
	}

	/**
	 * Binds the node booking to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public RoomDaySlotTuplePattern bindBooking(final AudiologyBooking object) {
		parameters.put("booking", Objects.requireNonNull(object, "booking must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node booking to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public RoomDaySlotTuplePattern unbindBooking() {
		parameters.remove("booking");
		return this;
	}

	/**
	 * Binds the node interval to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public RoomDaySlotTuplePattern bindInterval(final Timeslot object) {
		parameters.put("interval", Objects.requireNonNull(object, "interval must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node interval to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public RoomDaySlotTuplePattern unbindInterval() {
		parameters.remove("interval");
		return this;
	}

	/**
	 * Binds the node planningDay to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public RoomDaySlotTuplePattern bindPlanningDay(final PlanningDay object) {
		parameters.put("planningDay", Objects.requireNonNull(object, "planningDay must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node planningDay to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public RoomDaySlotTuplePattern unbindPlanningDay() {
		parameters.remove("planningDay");
		return this;
	}

	/**
	 * Binds the node room to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public RoomDaySlotTuplePattern bindRoom(final Room object) {
		parameters.put("room", Objects.requireNonNull(object, "room must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node room to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public RoomDaySlotTuplePattern unbindRoom() {
		parameters.remove("room");
		return this;
	}
	
	@Override
	public String toString() {
		String s = "pattern " + patternName + " {" + java.lang.System.lineSeparator();
		s += "	booking --> " + parameters.get("booking") + java.lang.System.lineSeparator();
		s += "	interval --> " + parameters.get("interval") + java.lang.System.lineSeparator();
		s += "	planningDay --> " + parameters.get("planningDay") + java.lang.System.lineSeparator();
		s += "	room --> " + parameters.get("room") + java.lang.System.lineSeparator();
		s += "}";
		return s;
	}
}
