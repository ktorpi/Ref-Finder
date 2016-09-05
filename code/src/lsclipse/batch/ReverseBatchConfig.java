package lsclipse.batch;

import java.util.Collections;
import java.util.List;

public class ReverseBatchConfig extends BatchConfig {

	protected ReverseBatchConfig(List<String> revisons, List<String> revisonComments) {
		super(revisons, revisonComments);
		Collections.reverse(revisons);
		Collections.reverse(revisonComments);
	}
	
}
