package lsclipse.batch;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import lsclipse.LsclipseException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;

public class QuamocoRunner {

	// TODO: hardcoded path
	private static final String QUAMOCO_DIR = "d:\\kutatás\\RefFinder\\quamoco"; 
	
	
	private IProject project;
	private String exportDir;
	private Logger SPEC_LOGGER;
	
	
	public QuamocoRunner(IProject project, String exportDir) {
		super();
		this.project = project;
		this.exportDir = exportDir;
		SPEC_LOGGER = Logger.getLogger("SPEC_LOGGER_" + exportDir);
	}

	public void run() throws IOException, LsclipseException {

		// building project
		SPEC_LOGGER.info("Building project for Quamoco...");
		try {
			project.build(IncrementalProjectBuilder.FULL_BUILD, null);
		} catch (CoreException ex) {
			ex.printStackTrace();
			throw new LsclipseException("Error while executing Quamoco project build!", ex);
		}
		
		// running quamoco
		SPEC_LOGGER.info("Running Quamoco after project build...");
		final String PROJECT_NAME = project.getName();
		final String SRC_DIR = project.getLocation().toFile().getAbsolutePath();
		final String BIN_DIR = project.getLocation().toFile().getAbsolutePath() + File.separatorChar + "bin";
		final String RES_DIR = exportDir + File.separatorChar + "quamoco_result";
		
		try {
			File pathToExecutable = new File(QUAMOCO_DIR + File.separatorChar + "run.bat");
			ProcessBuilder builder = new ProcessBuilder(pathToExecutable.getAbsolutePath(), SRC_DIR, BIN_DIR, RES_DIR, PROJECT_NAME);
			builder.directory(new File(QUAMOCO_DIR));
			builder.redirectErrorStream(true);
			Process process =  builder.start();
	
			Scanner s = new Scanner(process.getInputStream());
			StringBuilder text = new StringBuilder();
			while (s.hasNextLine()) {
			  text.append(s.nextLine());
			  text.append("\n");
			}
			s.close();
			
			int result = process.waitFor();
			if (result != 0) {
				throw new LsclipseException("Error while executing Quamoco!");
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
			throw new LsclipseException("Error while executing Quamoco!", ex);
		}
	}
	
}
