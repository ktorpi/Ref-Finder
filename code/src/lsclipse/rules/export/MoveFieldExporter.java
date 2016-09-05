package lsclipse.rules.export;

import java.util.ArrayList;
import java.util.List;

import lsclipse.LSDiffRunner;
import lsclipse.views.Node;

public class MoveFieldExporter extends RefactoringCsvExporter {

	MoveFieldExporter() {}
	
	@Override
	protected String fileName() {
		return "MOVE_FIELD.csv";
	}

	@Override
	protected List<String> columnNames() {
		List<String> columns = new ArrayList<String>();
		columns.add("field in old");
		columns.add("field in new");
		return columns;
	}

	@Override
	protected List<String> parameters(Node refactoring) {
		List<String> paramsWithPosition = new ArrayList<String>();
		String[] parameters = refactoring.params.substring(2, refactoring.params.length() - 2).split("\",\"");
		
		String fieldInOld = parameters[1] + "#" + parameters[0];
		String fieldInNew = parameters[2] + "#" + parameters[0];
		
		paramsWithPosition.add(fieldInOld + "@" + LSDiffRunner.beforePositions.getPosition(fieldInOld).toString());
		paramsWithPosition.add(fieldInNew + "@" + LSDiffRunner.afterPositions.getPosition(fieldInNew).toString());
		
		return paramsWithPosition;
	}

}
