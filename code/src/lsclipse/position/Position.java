package lsclipse.position;

public class Position {

	private int line;
	private int column;
	private String file;
	
	
	public Position(int line, int column, String file) {
		super();
		this.line = line;
		this.column = column;
		this.file = file;
	}


	public int getLine() {
		return line;
	}


	public int getColumn() {
		return column;
	}


	public String getFile() {
		return file;
	}
	
	
	@Override
	public String toString() {
		return file + ":" + line + ":" + column;
	}
}
