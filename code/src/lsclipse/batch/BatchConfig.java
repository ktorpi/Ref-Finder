package lsclipse.batch;

import java.util.List;


public class BatchConfig {

	protected List<String> revisons;
	protected List<String> revisonComments;
	
	protected BatchConfig(List<String> revisons, List<String> revisonComments) {
		this.revisons = revisons;
		this.revisonComments = revisonComments;
		
		// handle if there is no comment
		for (int i = 0; i < revisonComments.size(); ++i) {
			if (revisonComments.get(i).isEmpty()) {
				revisonComments.set(i, revisons.get(i));
			}
		}
		
	}
	
	public String getRevision(int index) {
		return revisons.get(index);
	}
	
	public String getRevisionComment(int index) {
		return revisonComments.get(index);
	}
	
	public int size() {
		return revisons.size();
	}
}
