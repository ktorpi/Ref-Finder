package lsclipse.rules.export;

import lsclipse.views.Node;

public abstract class RefactoringExporter {
	
	abstract void doExport();
	public abstract void addRefactoring(Node refactoring);
	
}
