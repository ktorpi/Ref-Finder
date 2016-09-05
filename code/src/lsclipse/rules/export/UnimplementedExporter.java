package lsclipse.rules.export;

import java.util.ArrayList;
import java.util.List;

import lsclipse.views.Node;

public class UnimplementedExporter extends RefactoringCsvExporter {

	@Override
	protected String fileName() {
		return "unimplemented.csv";
	}

	@Override
	protected List<String> columnNames() {
		List<String> columns = new ArrayList<String>();
		columns.add("unimplemented csv output");
		return columns;
	}

	@Override
	protected List<String> parameters(Node refactoring) {
		List<String> params = new ArrayList<String>();
		params.add(refactoring.getName());
		return params;
	}

}
