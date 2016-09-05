package lsclipse.rules.export;

import java.util.ArrayList;
import java.util.List;

import lsclipse.LSDiffRunner;
import lsclipse.views.Node;

public class IntroduceLocalExtensionExporter extends RefactoringCsvExporter {

	IntroduceLocalExtensionExporter() {}
	
	@Override
	protected String fileName() {
		return "INTRODUCE_LOCAL_EXTENSION.csv";
	}

	@Override
	protected List<String> columnNames() {
		List<String> columns = new ArrayList<String>();
		columns.add("class in old");
		columns.add("class in new");
		columns.add("extension class");
		return columns;
	}

	@Override
	protected List<String> parameters(Node refactoring) {
		List<String> paramsWithPosition = new ArrayList<String>();
		String[] parameters = refactoring.params.substring(2, refactoring.params.length() - 2).split("\",\"");
		
		paramsWithPosition.add(parameters[1] + "@" + LSDiffRunner.beforePositions.getPosition(parameters[1]).toString());
		paramsWithPosition.add(parameters[1] + "@" + LSDiffRunner.afterPositions.getPosition(parameters[1]).toString());
		paramsWithPosition.add(parameters[0]);
		
		return paramsWithPosition;
	}

}
