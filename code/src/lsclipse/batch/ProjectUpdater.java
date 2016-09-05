package lsclipse.batch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lsclipse.LsclipseException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

public abstract class ProjectUpdater {
	
	private IProject project;

	public ProjectUpdater(IProject project) {
		super();
		this.project = project;
	}
	
	
	public IProject updateToRevision(String revision) throws LsclipseException {
		String projectDir = project.getLocation().toFile().getAbsolutePath();
		
		try {
			Process p = Runtime.getRuntime().exec(updateCommand(projectDir, revision));
			
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while((line = in.readLine()) != null) {
			    System.out.println(line);
			}
			
			p.waitFor();
			
			// rename project 
//			IProjectDescription description = project.getDescription();
//			String oldName = description.getName();
//			String newName = oldName.substring(0, oldName.indexOf("_")+1);
//			newName += revision;
//			description.setName(newName);
//			project.move(description, false, null);
			
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
			return ResourcesPlugin.getWorkspace().getRoot().getProject(project.getName());
		} catch (IOException e) {
			e.printStackTrace();
			throw new LsclipseException("Error while executing update!", e);
		} catch (CoreException e) {
			e.printStackTrace();
			throw new LsclipseException("Error while executing update!", e);
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new LsclipseException("Error while executing update!", e);
		}
		
	}
	
	
	protected abstract String updateCommand(String projectDir, String revision);
	
}
