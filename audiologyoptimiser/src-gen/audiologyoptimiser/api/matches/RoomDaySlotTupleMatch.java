package audiologyoptimiser.api.matches;

import audiologymodel.AudiologyBooking;
import audiologymodel.PlanningDay;
import audiologymodel.Room;
import audiologymodel.Timeslot;
import audiologyoptimiser.api.rules.RoomDaySlotTuplePattern;
import org.emoflon.ibex.common.operational.IMatch;
import org.emoflon.ibex.gt.api.GraphTransformationMatch;

/**
 * A match for the pattern <code>roomDaySlotTuple()</code>.
 */
public class RoomDaySlotTupleMatch extends GraphTransformationMatch<RoomDaySlotTupleMatch, RoomDaySlotTuplePattern> {
	private AudiologyBooking varBooking;
	private Timeslot varInterval;
	private PlanningDay varPlanningDay;
	private Room varRoom;

	/**
	 * Creates a new match for the pattern <code>roomDaySlotTuple()</code>.
	 * 
	 * @param pattern
	 *            the pattern
	 * @param match
	 *            the untyped match
	 */
	public RoomDaySlotTupleMatch(final RoomDaySlotTuplePattern pattern, final IMatch match) {
		super(pattern, match);
		varBooking = (AudiologyBooking) match.get("booking");
		varInterval = (Timeslot) match.get("interval");
		varPlanningDay = (PlanningDay) match.get("planningDay");
		varRoom = (Room) match.get("room");
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
	 * Returns the interval.
	 *
	 * @return the interval
	 */
	public Timeslot getInterval() {
		return varInterval;
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
	 * Returns the room.
	 *
	 * @return the room
	 */
	public Room getRoom() {
		return varRoom;
	}

	@Override
	public String toString() {
		String s = "match {" + java.lang.System.lineSeparator();
		s += "	booking --> " + varBooking + java.lang.System.lineSeparator();
		s += "	interval --> " + varInterval + java.lang.System.lineSeparator();
		s += "	planningDay --> " + varPlanningDay + java.lang.System.lineSeparator();
		s += "	room --> " + varRoom + java.lang.System.lineSeparator();
		s += "} for " + getPattern();
		return s;
	}
}
