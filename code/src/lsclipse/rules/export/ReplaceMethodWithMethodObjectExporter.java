package lsclipse.rules.export;

import java.util.ArrayList;
import java.util.List;

import lsclipse.LSDiffRunner;
import lsclipse.views.Node;

public class ReplaceMethodWithMethodObjectExporter extends RefactoringCsvExporter {

	ReplaceMethodWithMethodObjectExporter() {
		
	}
	
	@Override
	protected String fileName() {
		return "REPLACE_METHOD_WITH_METHOD_OBJECT.csv";
	}

	@Override
	protected List<String> columnNames() {
		List<String> columns = new ArrayList<String>();
		columns.add("old method");
		columns.add("new method");
		columns.add("method object class");
		return columns;
	}

	@Override
	protected List<String> parameters(Node refactoring) {
		List<String> paramsWithPosition = new ArrayList<String>();
		String[] parameters = refactoring.params.substring(2, refactoring.params.length() - 2).split("\",\"");
		
		paramsWithPosition.add(parameters[0] + "@" + LSDiffRunner.beforePositions.getPosition(parameters[0]).toString());
		paramsWithPosition.add(parameters[0] + "@" + LSDiffRunner.afterPositions.getPosition(parameters[0]).toString());
		paramsWithPosition.add(parameters[1]+ "@" + LSDiffRunner.afterPositions.getPosition(parameters[1]).toString());
		
		return paramsWithPosition;
	}

}
