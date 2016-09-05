package lsclipse.rules.export;

import java.util.ArrayList;
import java.util.List;

import lsclipse.LSDiffRunner;
import lsclipse.views.Node;

public class ReplaceExceptionWithTestExporter extends RefactoringCsvExporter {

	ReplaceExceptionWithTestExporter() {}
	
	@Override
	protected String fileName() {
		return "REPLACE_EXCEPTION_WITH_TEST.csv";
	}

	@Override
	protected List<String> columnNames() {
		List<String> columns = new ArrayList<String>();
		columns.add("old method");
		columns.add("new method");
		columns.add("deleted condition");
		columns.add("exception");
		return columns;
	}

	@Override
	protected List<String> parameters(Node refactoring) {
		List<String> paramsWithPosition = new ArrayList<String>();
		String[] parameters = refactoring.params.substring(2, refactoring.params.length() - 2).split("\",\"");
		
		paramsWithPosition.add(parameters[2] + "@" + LSDiffRunner.beforePositions.getPosition(parameters[2]).toString());
		paramsWithPosition.add(parameters[2] + "@" + LSDiffRunner.afterPositions.getPosition(parameters[2]).toString());
		paramsWithPosition.add(parameters[1]);
		paramsWithPosition.add(parameters[0] + "@" + LSDiffRunner.beforePositions.getPosition(parameters[0]).toString());
		
		return paramsWithPosition;
	}

}
