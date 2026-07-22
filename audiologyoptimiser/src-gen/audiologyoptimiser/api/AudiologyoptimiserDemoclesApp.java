package audiologyoptimiser.api;

import org.emoflon.ibex.gt.democles.runtime.DemoclesGTEngine;

/**
 * An application using the AudiologyoptimiserAPI with Democles.
 */
public class AudiologyoptimiserDemoclesApp extends AudiologyoptimiserApp {

	/**
	 * Creates the application with Democles.
	 */
	public AudiologyoptimiserDemoclesApp() {
		super(new DemoclesGTEngine());
	}

	/**
	 * Creates the application with Democles.
	 * 
	 * @param workspacePath
	 *            the workspace path
	 */
	public AudiologyoptimiserDemoclesApp(final String workspacePath) {
		super(new DemoclesGTEngine(), workspacePath);
	}
}
