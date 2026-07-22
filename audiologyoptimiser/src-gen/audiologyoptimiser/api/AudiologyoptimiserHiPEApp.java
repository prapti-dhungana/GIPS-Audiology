package audiologyoptimiser.api;

import org.emoflon.ibex.gt.hipe.runtime.HiPEGTEngine;

/**
 * An application using the AudiologyoptimiserAPI with HiPE.
 */
public class AudiologyoptimiserHiPEApp extends AudiologyoptimiserApp {

	/**
	 * Creates the application with HiPE.
	 */
	public AudiologyoptimiserHiPEApp() {
		super(new HiPEGTEngine());
	}

	/**
	 * Creates the application with HiPE.
	 * 
	 * @param workspacePath
	 *            the workspace path
	 */
	public AudiologyoptimiserHiPEApp(final String workspacePath) {
		super(new HiPEGTEngine(), workspacePath);
	}
}
