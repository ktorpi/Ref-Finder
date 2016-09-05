package lsclipse.rules.export;

import java.util.ArrayList;
import java.util.List;

import lsclipse.LSDiffRunner;
import lsclipse.views.Node;

public class RenameMethodExporter extends RefactoringCsvExporter {

	RenameMethodExporter() {
	
	}
	
	@Override
	protected String fileName() {
		return "RENAME_METHOD.csv";
	}

	@Override
	protected List<String> columnNames() {
		List<String> columns = new ArrayList<String>();
		columns.add("old method");
		columns.add("new method");
		columns.add("class");
		return columns;
	}

	@Override
	protected List<String> parameters(Node refactoring) {		
		String[] parameters = refactoring.params.substring(2, refactoring.params.length() - 2).split("\",\"");
		
		parameters[0] = parameters[0] + "@" + LSDiffRunner.beforePositions.getPosition(parameters[0]).toString();
		parameters[1] = parameters[1] + "@" + LSDiffRunner.afterPositions.getPosition(parameters[1]).toString();
		parameters[2] = parameters[2] + "@" + LSDiffRunner.afterPositions.getPosition(parameters[2]).toString();
		
		List<String> paramsWithPosition = new ArrayList<String>();
		for (String param : parameters) {
			paramsWithPosition.add(param.replace('#', '.').replace("%", ""));
		}
		
		return paramsWithPosition;
	}
	
}
