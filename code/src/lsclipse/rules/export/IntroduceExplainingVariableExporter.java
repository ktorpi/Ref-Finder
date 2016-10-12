package lsclipse.rules.export;

import java.util.ArrayList;
import java.util.List;

import lsclipse.LSDiffRunner;
import lsclipse.views.Node;

public class IntroduceExplainingVariableExporter extends RefactoringCsvExporter {

	IntroduceExplainingVariableExporter() {
		
	}
	
	@Override
	protected String fileName() {
		return "INTRODUCE_EXPLAINING_VARIABLE.csv";
	}

	@Override
	protected List<String> columnNames() {
		List<String> columns = new ArrayList<String>();
		columns.add("old method");
		columns.add("new method");
		columns.add("introduced variable");
		columns.add("replaced expression");
		return columns;
	}

	@Override
	protected List<String> parameters(Node refactoring) {
		List<String> paramsWithPosition = new ArrayList<String>();
		String[] parameters = refactoring.params.substring(2, refactoring.params.length() - 2).split("\",\"");
		
		paramsWithPosition.add(parameters[2] + "@" + LSDiffRunner.beforePositions.getPosition(parameters[2]).toString());
		paramsWithPosition.add(parameters[2] + "@" + LSDiffRunner.afterPositions.getPosition(parameters[2]).toString());
		paramsWithPosition.add(parameters[0]);
		paramsWithPosition.add(parameters[1]);
		
		return paramsWithPosition;
	}

}