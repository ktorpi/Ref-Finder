package lsclipse.position;

import java.util.StringTokenizer;

public class NullPosition extends Position {

	public NullPosition() {
		super(-1, -1, "");
	}
	
	public String toString() {
		return "Position information is not available.";
	}

}
