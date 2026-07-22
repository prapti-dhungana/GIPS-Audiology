package audiologyoptimiser.api.matches;

import audiologymodel.AudiologyBooking;
import audiologymodel.PlanningDay;
import audiologymodel.StaffMember;
import audiologyoptimiser.api.rules.StaffDayTuplePattern;
import org.emoflon.ibex.common.operational.IMatch;
import org.emoflon.ibex.gt.api.GraphTransformationMatch;

/**
 * A match for the pattern <code>staffDayTuple()</code>.
 */
public class StaffDayTupleMatch extends GraphTransformationMatch<StaffDayTupleMatch, StaffDayTuplePattern> {
	private AudiologyBooking varBooking;
	private PlanningDay varPlanningDay;
	private StaffMember varStaffMember;

	/**
	 * Creates a new match for the pattern <code>staffDayTuple()</code>.
	 * 
	 * @param pattern
	 *            the pattern
	 * @param match
	 *            the untyped match
	 */
	public StaffDayTupleMatch(final StaffDayTuplePattern pattern, final IMatch match) {
		super(pattern, match);
		varBooking = (AudiologyBooking) match.get("booking");
		varPlanningDay = (PlanningDay) match.get("planningDay");
		varStaffMember = (StaffMember) match.get("staffMember");
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
	 * Returns the staffMember.
	 *
	 * @return the staffMember
	 */
	public StaffMember getStaffMember() {
		return varStaffMember;
	}

	@Override
	public String toString() {
		String s = "match {" + java.lang.System.lineSeparator();
		s += "	booking --> " + varBooking + java.lang.System.lineSeparator();
		s += "	planningDay --> " + varPlanningDay + java.lang.System.lineSeparator();
		s += "	staffMember --> " + varStaffMember + java.lang.System.lineSeparator();
		s += "} for " + getPattern();
		return s;
	}
}
