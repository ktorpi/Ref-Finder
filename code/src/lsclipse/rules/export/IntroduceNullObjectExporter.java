package lsclipse.rules.export;

import java.util.ArrayList;
import java.util.List;

import lsclipse.LSDiffRunner;
import lsclipse.views.Node;

public class IntroduceNullObjectExporter extends RefactoringCsvExporter {

	IntroduceNullObjectExporter() {}
	
	@Override
	protected String fileName() {
		return "INTRODUCE_NULL_OBJECT.csv";
	}

	@Override
	protected List<String> columnNames() {
		List<String> columns = new ArrayList<String>();
		columns.add("parent class (in new verison)");
		columns.add("null object class");
		columns.add("method");
		columns.add("deleted conditional");
		return columns;
	}

	@Override
	protected List<String> parameters(Node refactoring) {
		List<String> paramsWithPosition = new ArrayList<String>();
		String[] parameters = refactoring.params.substring(2, refactoring.params.length() - 2).split("\",\"");
		
		
		paramsWithPosition.add(parameters[0] + "@" + LSDiffRunner.afterPositions.getPosition(parameters[0]).toString());
		paramsWithPosition.add(parameters[1] + "@" + LSDiffRunner.afterPositions.getPosition(parameters[1]).toString());

		for (String statement : refactoring.getDependents()) {
			if (statement.startsWith("deleted_conditional")) {
				String[] deletedCondParams = statement.substring("deleted_conditional".length()+2, statement.length()-2).replace("\"", "").split(",");
				
				paramsWithPosition.add(deletedCondParams[3] + "@" +  LSDiffRunner.afterPositions.getPosition(deletedCondParams[3]).toString());
				paramsWithPosition.add(deletedCondParams[0]);
				
				break;
			}
		}
		
		return paramsWithPosition;
	}

}
