package lsclipse.batch;

import org.eclipse.core.resources.IProject;

public class SvnProjectUpdater extends ProjectUpdater {

	public SvnProjectUpdater(IProject project) {
		super(project);
	}

	@Override
	protected String updateCommand(String projectDir, String revision) {
		return "svn update -r" + revision + " " + projectDir;
	}

}
