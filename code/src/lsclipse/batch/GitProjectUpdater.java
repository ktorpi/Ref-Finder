package lsclipse.batch;

import java.io.File;

import org.eclipse.core.resources.IProject;

public class GitProjectUpdater extends ProjectUpdater {

	public GitProjectUpdater(IProject project) {
		super(project);
	}

	@Override
	protected String updateCommand(String projectDir, String revision) {
		return "git"
				+ " --git-dir=" + projectDir + File.separatorChar + ".git"
				+ " --work-tree=" + projectDir
				+ " reset --hard " + revision;
	}

}
