package lsclipse.batch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lsclipse.LsclipseException;

public class ConfigFileReader {

	private String configFile;
	
	public ConfigFileReader(String configFile) {
		this.configFile = configFile;
	}
	
	
	public BatchConfig getBatchConfig(boolean reverse) throws LsclipseException {
		try {
			List<String> revisions = new ArrayList<String>();
			List<String> revisionComments = new ArrayList<String>(); // string after the first comma

			BufferedReader reader = new BufferedReader(new FileReader(configFile));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("#")) continue;
				if (line.isEmpty()) continue;
				
				int firstCommaIndex = line.indexOf(';');

				String revision = line.substring(0, firstCommaIndex);
				String revComment = line.substring(firstCommaIndex+1, line.length());

				revisions.add(revision);
				revisionComments.add(revComment);
			}
			reader.close();

			return reverse ? new ReverseBatchConfig(revisions, revisionComments) : new BatchConfig(revisions, revisionComments);

		} catch (IOException ex) {
			ex.printStackTrace();
			throw new LsclipseException("Problem with revision config file", ex);
		}
	}
	
	
}
