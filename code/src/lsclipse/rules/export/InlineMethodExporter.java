package lsclipse.rules.export;

import java.util.ArrayList;
import java.util.List;

import lsclipse.LSDiffRunner;
import lsclipse.views.Node;

public class InlineMethodExporter extends RefactoringCsvExporter {

	InlineMethodExporter() {}
	
	@Override
	protected String fileName() {
		return "INLINE_METHOD.csv";
	}

	@Override
	protected List<String> columnNames() {
		List<String> columns = new ArrayList<String>();
		columns.add("caller method in old");
		columns.add("caller method in new");
		columns.add("inlined method");
		columns.add("body");
		return columns;
	}

	@Override
	protected List<String> parameters(Node refactoring) {
		List<String> paramsWithPosition = new ArrayList<String>();
		String[] parameters = refactoring.params.substring(2, refactoring.params.length() - 2).split("\",\"");
		
		paramsWithPosition.add(parameters[0] + "@" + LSDiffRunner.beforePositions.getPosition(parameters[0]).toString());
		paramsWithPosition.add(parameters[0] + "@" + LSDiffRunner.afterPositions.getPosition(parameters[0]).toString());
		paramsWithPosition.add(parameters[1] + "@" + LSDiffRunner.beforePositions.getPosition(parameters[1]).toString());
		paramsWithPosition.add(parameters[2]);
		
		return paramsWithPosition;
	}

}
