package audiologyoptimiser.api.matches;

import audiologymodel.AudiologyBooking;
import audiologymodel.PlanningWeek;
import audiologymodel.StaffMember;
import audiologyoptimiser.api.rules.StaffWeekTuplePattern;
import org.emoflon.ibex.common.operational.IMatch;
import org.emoflon.ibex.gt.api.GraphTransformationMatch;

/**
 * A match for the pattern <code>staffWeekTuple()</code>.
 */
public class StaffWeekTupleMatch extends GraphTransformationMatch<StaffWeekTupleMatch, StaffWeekTuplePattern> {
	private AudiologyBooking varBooking;
	private PlanningWeek varPlanningWeek;
	private StaffMember varStaffMember;

	/**
	 * Creates a new match for the pattern <code>staffWeekTuple()</code>.
	 * 
	 * @param pattern
	 *            the pattern
	 * @param match
	 *            the untyped match
	 */
	public StaffWeekTupleMatch(final StaffWeekTuplePattern pattern, final IMatch match) {
		super(pattern, match);
		varBooking = (AudiologyBooking) match.get("booking");
		varPlanningWeek = (PlanningWeek) match.get("planningWeek");
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
	 * Returns the planningWeek.
	 *
	 * @return the planningWeek
	 */
	public PlanningWeek getPlanningWeek() {
		return varPlanningWeek;
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
		s += "	planningWeek --> " + varPlanningWeek + java.lang.System.lineSeparator();
		s += "	staffMember --> " + varStaffMember + java.lang.System.lineSeparator();
		s += "} for " + getPattern();
		return s;
	}
}
