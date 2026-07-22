package audiologyoptimiser.api.matches;

import audiologymodel.AppointmentRequest;
import audiologymodel.AudiologyBooking;
import audiologyoptimiser.api.rules.RequestTuplePattern;
import org.emoflon.ibex.common.operational.IMatch;
import org.emoflon.ibex.gt.api.GraphTransformationMatch;

/**
 * A match for the pattern <code>requestTuple()</code>.
 */
public class RequestTupleMatch extends GraphTransformationMatch<RequestTupleMatch, RequestTuplePattern> {
	private AudiologyBooking varBooking;
	private AppointmentRequest varRequest;

	/**
	 * Creates a new match for the pattern <code>requestTuple()</code>.
	 * 
	 * @param pattern
	 *            the pattern
	 * @param match
	 *            the untyped match
	 */
	public RequestTupleMatch(final RequestTuplePattern pattern, final IMatch match) {
		super(pattern, match);
		varBooking = (AudiologyBooking) match.get("booking");
		varRequest = (AppointmentRequest) match.get("request");
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
	 * Returns the request.
	 *
	 * @return the request
	 */
	public AppointmentRequest getRequest() {
		return varRequest;
	}

	@Override
	public String toString() {
		String s = "match {" + java.lang.System.lineSeparator();
		s += "	booking --> " + varBooking + java.lang.System.lineSeparator();
		s += "	request --> " + varRequest + java.lang.System.lineSeparator();
		s += "} for " + getPattern();
		return s;
	}
}
