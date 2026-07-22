package audiologyoptimiser.api;

import audiologyoptimiser.api.rules.AssignAppointmentRule;
import audiologyoptimiser.api.rules.RequestTuplePattern;
import audiologyoptimiser.api.rules.RoomDaySlotTuplePattern;
import audiologyoptimiser.api.rules.StaffDaySlotTuplePattern;
import audiologyoptimiser.api.rules.StaffDayTuplePattern;
import audiologyoptimiser.api.rules.StaffRoomDayTuplePattern;
import audiologyoptimiser.api.rules.StaffWeekTuplePattern;
import java.util.function.Supplier;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emoflon.ibex.common.operational.IContextPatternInterpreter;
import org.emoflon.ibex.gt.api.GraphTransformationAPI;
import org.emoflon.ibex.gt.api.GraphTransformationPattern;
import org.emoflon.ibex.gt.api.GraphTransformationRule;

/**
 * The AudiologyoptimiserAPI with 1 rules and 7 patterns.
 */
public class AudiologyoptimiserAPI extends GraphTransformationAPI {
	
	public static String patternPath = "audiologyoptimiser/src-gen/audiologyoptimiser/api/ibex-patterns.xmi";

	/**
	 * Creates a new AudiologyoptimiserAPI.
	 *
	 * @param engine
	 *            the engine to use for queries and transformations
	 * @param model
	 *            the resource set containing the model file
	 * @param workspacePath
	 *            the path to the workspace which is concatenated with the project
	 *            relative path to the patterns
	 */
	public AudiologyoptimiserAPI(final IContextPatternInterpreter engine, final ResourceSet model, final String workspacePath) {
		super(engine, model);
		URI uri = URI.createFileURI(workspacePath + patternPath);
		interpreter.loadPatternSet(uri);
		patternMap = initiatePatternMap();
		gillespieMap = initiateGillespieMap();
	}
	
	/**
	 * Creates a new AudiologyoptimiserAPI.
	 *
	 * @param engine
	 *			  the engine to use for queries and transformations.
	 * @param model
	 *            the resource set containing the model file.
	 * @param patternPath
	 *            the path to the IBeX pattern XMI file to load.
	 */
	public AudiologyoptimiserAPI(final IContextPatternInterpreter engine, final ResourceSet model, final URI patternPath) {
		super(engine, model);
		interpreter.loadPatternSet(patternPath);
		patternMap = initiatePatternMap();
		gillespieMap = initiateGillespieMap();
	}

	/**
	 * Creates a new AudiologyoptimiserAPI.
	 *
	 * @param engine
	 *            the engine to use for queries and transformations
	 * @param model
	 *            the resource set containing the model file
	 * @param defaultResource
	 *            the default resource
	 * @param workspacePath
	 *            the path to the workspace which is concatenated with the project
	 *            relative path to the patterns
	 */
	public AudiologyoptimiserAPI(final IContextPatternInterpreter engine, final ResourceSet model, final Resource defaultResource,
			final String workspacePath) {
		super(engine, model, defaultResource);
		URI uri = URI.createFileURI(workspacePath + patternPath);
		interpreter.loadPatternSet(uri);
		patternMap = initiatePatternMap();
		gillespieMap = initiateGillespieMap();
	}
	
	@Override
	protected Map<String, Supplier<? extends GraphTransformationPattern<?,?>>> initiatePatternMap(){
		Map<String, Supplier<? extends GraphTransformationPattern<?,?>>> map = new HashMap<>();
		map.put("assignAppointment", () -> assignAppointment());
		map.put("requestTuple", () -> requestTuple());
		map.put("roomDaySlotTuple", () -> roomDaySlotTuple());
		map.put("staffDaySlotTuple", () -> staffDaySlotTuple());
		map.put("staffDayTuple", () -> staffDayTuple());
		map.put("staffRoomDayTuple", () -> staffRoomDayTuple());
		map.put("staffWeekTuple", () -> staffWeekTuple());
		return map;
	}
	
	@Override
	protected Map<GraphTransformationRule<?,?>, double[]> initiateGillespieMap(){
		Map<GraphTransformationRule<?,?>, double[]> map = 
			new HashMap<>();
		return map;
	}
					
	/**
	* Creates a new instance of the rule <code>assignAppointment()</code> which does the following:
	* One match represents one locally feasible appointment assignment.
	*
	* @return the new instance of the rule»
	*/
	public synchronized AssignAppointmentRule assignAppointment() {
		try{
			AssignAppointmentRule rule = (AssignAppointmentRule) interpreter.getRegisteredGraphTransformationPattern("assignAppointment");
			return rule;
		} catch(Exception e) {
			return new AssignAppointmentRule(this, interpreter);
		}
	}
	/**
	* Creates a new instance of the pattern <code>requestTuple()</code> which does the following:
	* Context patterns used by the global constraints.
	*
	* @return the new instance of the pattern»
	*/
	public synchronized RequestTuplePattern requestTuple() {
		try{
			RequestTuplePattern pattern = (RequestTuplePattern) interpreter.getRegisteredGraphTransformationPattern("requestTuple");
			return pattern;
		} catch(Exception e) {
			return new RequestTuplePattern(this, interpreter);
		}
	}
	/**
	* Creates a new instance of the pattern <code>roomDaySlotTuple()</code> which does the following:
	* If this pattern is not self-explaining, you really should add some comment in the specification.
	*
	* @return the new instance of the pattern»
	*/
	public synchronized RoomDaySlotTuplePattern roomDaySlotTuple() {
		try{
			RoomDaySlotTuplePattern pattern = (RoomDaySlotTuplePattern) interpreter.getRegisteredGraphTransformationPattern("roomDaySlotTuple");
			return pattern;
		} catch(Exception e) {
			return new RoomDaySlotTuplePattern(this, interpreter);
		}
	}
	/**
	* Creates a new instance of the pattern <code>staffDaySlotTuple()</code> which does the following:
	* If this pattern is not self-explaining, you really should add some comment in the specification.
	*
	* @return the new instance of the pattern»
	*/
	public synchronized StaffDaySlotTuplePattern staffDaySlotTuple() {
		try{
			StaffDaySlotTuplePattern pattern = (StaffDaySlotTuplePattern) interpreter.getRegisteredGraphTransformationPattern("staffDaySlotTuple");
			return pattern;
		} catch(Exception e) {
			return new StaffDaySlotTuplePattern(this, interpreter);
		}
	}
	/**
	* Creates a new instance of the pattern <code>staffDayTuple()</code> which does the following:
	* If this pattern is not self-explaining, you really should add some comment in the specification.
	*
	* @return the new instance of the pattern»
	*/
	public synchronized StaffDayTuplePattern staffDayTuple() {
		try{
			StaffDayTuplePattern pattern = (StaffDayTuplePattern) interpreter.getRegisteredGraphTransformationPattern("staffDayTuple");
			return pattern;
		} catch(Exception e) {
			return new StaffDayTuplePattern(this, interpreter);
		}
	}
	/**
	* Creates a new instance of the pattern <code>staffRoomDayTuple()</code> which does the following:
	* If this pattern is not self-explaining, you really should add some comment in the specification.
	*
	* @return the new instance of the pattern»
	*/
	public synchronized StaffRoomDayTuplePattern staffRoomDayTuple() {
		try{
			StaffRoomDayTuplePattern pattern = (StaffRoomDayTuplePattern) interpreter.getRegisteredGraphTransformationPattern("staffRoomDayTuple");
			return pattern;
		} catch(Exception e) {
			return new StaffRoomDayTuplePattern(this, interpreter);
		}
	}
	/**
	* Creates a new instance of the pattern <code>staffWeekTuple()</code> which does the following:
	* If this pattern is not self-explaining, you really should add some comment in the specification.
	*
	* @return the new instance of the pattern»
	*/
	public synchronized StaffWeekTuplePattern staffWeekTuple() {
		try{
			StaffWeekTuplePattern pattern = (StaffWeekTuplePattern) interpreter.getRegisteredGraphTransformationPattern("staffWeekTuple");
			return pattern;
		} catch(Exception e) {
			return new StaffWeekTuplePattern(this, interpreter);
		}
	}
}
