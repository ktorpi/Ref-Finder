package lsclipse.rules.export;

import java.util.ArrayList;
import java.util.List;

import lsclipse.LSDiffRunner;
import lsclipse.views.Node;

public class ExtractMethodExporter extends RefactoringCsvExporter {

	ExtractMethodExporter() {
	}
	
	@Override
	protected String fileName() {
		return "EXTRACT_METHOD.csv";
	}

	@Override
	protected List<String> columnNames() {
		List<String> columns = new ArrayList<String>();
		columns.add("method from");
		columns.add("method to");
		columns.add("extracted code");
		return columns;
	}

	@Override
	protected List<String> parameters(Node refactoring) {
		List<String> paramsWithPosition = new ArrayList<String>();
		String[] parameters = refactoring.params.substring(2, refactoring.params.length() - 2).split("\",\"");
		
		paramsWithPosition.add(parameters[0] + "@" + LSDiffRunner.beforePositions.getPosition(parameters[0]).toString());
		paramsWithPosition.add(parameters[1] + "@" + LSDiffRunner.afterPositions.getPosition(parameters[1]).toString());
		paramsWithPosition.add(parameters[2]);
		
		return paramsWithPosition;
	}
	

}
