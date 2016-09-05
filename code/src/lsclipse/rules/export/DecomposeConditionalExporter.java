package lsclipse.rules.export;

import java.util.ArrayList;
import java.util.List;

import lsclipse.views.Node;


// TODO: ki kellene találni, hogy mik az egyes paraméterei ennek a refactoringnak
public class DecomposeConditionalExporter extends RefactoringCsvExporter {

	DecomposeConditionalExporter() {}
	
	@Override
	protected String fileName() {
		return "DECOMPOSE_CONDITIONAL.csv";
	}

	@Override
	protected List<String> columnNames() {
		List<String> columns = new ArrayList<String>();
		columns.add("TODO: unknown attributes");
		return columns;
	}

	@Override
	protected List<String> parameters(Node refactoring) {
		List<String> paramsWithPosition = new ArrayList<String>();
		String[] parameters = refactoring.params.substring(2, refactoring.params.length() - 2).split("\",\"");
		
//		paramsWithPosition.add(parameters[0] + "@" + LSDiffRunner.beforePositions.getPosition(parameters[0]).toString());
//		paramsWithPosition.add(parameters[0] + "@" + LSDiffRunner.afterPositions.getPosition(parameters[0]).toString());
//		paramsWithPosition.add(parameters[1]);
		

		for (String param : parameters) {
			paramsWithPosition.add(param);
		}
		
		return paramsWithPosition;
	}

}
