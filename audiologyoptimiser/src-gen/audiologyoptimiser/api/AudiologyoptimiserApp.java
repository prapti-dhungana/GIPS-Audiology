package audiologyoptimiser.api;

import audiologymodel.AudiologymodelPackage;
import org.eclipse.emf.common.util.URI;
import org.emoflon.ibex.common.operational.IContextPatternInterpreter;
import org.emoflon.ibex.gt.api.GraphTransformationApp;

/**
 * An application using the AudiologyoptimiserAPI.
 */
public class AudiologyoptimiserApp extends GraphTransformationApp<AudiologyoptimiserAPI> {

	/**
	 * Creates the application with the given engine.
	 * 
	 * @param engine
	 *            the pattern matching engine
	 */
	public AudiologyoptimiserApp(final IContextPatternInterpreter engine) {
		super(engine);
	}

	/**
	 * Creates the application with the given engine.
	 * 
	 * @param engine
	 *            the pattern matching engine
	 * @param workspacePath
	 *            the workspace path
	 */
	public AudiologyoptimiserApp(final IContextPatternInterpreter engine, final String workspacePath) {
		super(engine, workspacePath);
	}

	@Override
	public void registerMetaModels() {
		registerMetaModel(AudiologymodelPackage.eINSTANCE);
	}

	@Override
	public AudiologyoptimiserAPI initAPI() {
		if (defaultResource.isPresent()) {
			return new AudiologyoptimiserAPI(engine, resourceSet, defaultResource.get(), workspacePath);
		}
		return new AudiologyoptimiserAPI(engine, resourceSet, workspacePath);
	}
	
	/**
	 * Initializes the API with a given (dynamic) IBeX pattern path (URI).
	 *
	 * @param patternPath
	 *            the (dynamic) IBeX pattern path (URI) to load the XMI file from.
	 */
	@Override
	public AudiologyoptimiserAPI initAPI(final URI patternPath) {
		return new AudiologyoptimiserAPI(engine, resourceSet, patternPath);
	}
}
