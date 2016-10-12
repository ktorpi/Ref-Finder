package lsclipse.rules.export;

import java.util.ArrayList;
import java.util.List;

import lsclipse.LSDiffRunner;
import lsclipse.views.Node;

public class AddParameterExporter extends RefactoringCsvExporter {

	public AddParameterExporter() {
	}
	
	@Override
	protected String fileName() {
		return "ADD_PARAMETER.csv";
	}

	@Override
	protected List<String> columnNames() {
		List<String> columns = new ArrayList<String>();
		columns.add("old method");
		columns.add("new method");
		columns.add("added parameter");
		return columns;
	}

	@Override
	protected List<String> parameters(Node refactoring) {
		List<String> paramsWithPosition = new ArrayList<String>();
		String[] parameters = refactoring.params.substring(2, refactoring.params.length() - 2).split("\",\"");
		
		paramsWithPosition.add(parameters[0] + "@" + LSDiffRunner.beforePositions.getPosition(parameters[0]).toString());
		paramsWithPosition.add(parameters[0] + "@" + LSDiffRunner.afterPositions.getPosition(parameters[0]).toString());
		paramsWithPosition.add(parameters[1]);
		
		List<String> niceParamsWithPosition = new ArrayList<String>();
		for (String param : paramsWithPosition) {
			niceParamsWithPosition.add(param.replace('#', '.').replace("%", ""));
		}
		return niceParamsWithPosition;
	}

}