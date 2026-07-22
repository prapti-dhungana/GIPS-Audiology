package audiologyoptimiser.api.rules;

import audiologymodel.AppointmentRequest;
import audiologymodel.AudiologyBooking;
import audiologyoptimiser.api.AudiologyoptimiserAPI;
import audiologyoptimiser.api.matches.RequestTupleMatch;
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
 * The pattern [org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@3f5a579f (name: booking), org.emoflon.ibex.patternmodel.IBeXPatternModel.impl.IBeXNodeImpl@3e98c319 (name: request)] which does the following:
 * Context patterns used by the global constraints.
 */
@SuppressWarnings("unused")
public class RequestTuplePattern extends GraphTransformationPattern<RequestTupleMatch, RequestTuplePattern> {
	private static String patternName = "requestTuple";

	/**
	 * Creates a new pattern requestTuple().
	 * 
	 * @param api
	 *            the API the pattern belongs to
	 * @param interpreter
	 *            the interpreter
	 */
	
	public RequestTuplePattern(final AudiologyoptimiserAPI api, final GraphTransformationInterpreter interpreter) {
		super(api, interpreter, patternName);
	}

	@Override
	public RequestTupleMatch convertMatch(final IMatch match) {
		return new RequestTupleMatch(this, match);
	}

	@Override
	protected List<String> getParameterNames() {
		List<String> names = new ArrayList<String>();
		names.add("booking");
		names.add("request");
		return names;
	}

	/**
	 * Binds the node booking to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public RequestTuplePattern bindBooking(final AudiologyBooking object) {
		parameters.put("booking", Objects.requireNonNull(object, "booking must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node booking to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public RequestTuplePattern unbindBooking() {
		parameters.remove("booking");
		return this;
	}

	/**
	 * Binds the node request to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public RequestTuplePattern bindRequest(final AppointmentRequest object) {
		parameters.put("request", Objects.requireNonNull(object, "request must not be null!"));
		return this;
	}
	
	/**
	 * Unbinds the node request to the given object.
	 *
	 * @param object
	 *            the object to set
	 */
	public RequestTuplePattern unbindRequest() {
		parameters.remove("request");
		return this;
	}
	
	@Override
	public String toString() {
		String s = "pattern " + patternName + " {" + java.lang.System.lineSeparator();
		s += "	booking --> " + parameters.get("booking") + java.lang.System.lineSeparator();
		s += "	request --> " + parameters.get("request") + java.lang.System.lineSeparator();
		s += "}";
		return s;
	}
}
