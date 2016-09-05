package lsclipse.rules.export;

import java.util.ArrayList;
import java.util.List;

import lsclipse.views.Node;

public class ReplaceConstructorWithFactoryMethodExporter extends RefactoringCsvExporter {

	ReplaceConstructorWithFactoryMethodExporter() {}
	
	@Override
	protected String fileName() {
		return "REPLACE_CONSTRUCTOR_WITH_FACTORY_METHOD.csv";
	}

	@Override
	protected List<String> columnNames() {
		List<String> columns = new ArrayList<String>();
		columns.add("old method");
		columns.add("new method");
		return columns;
	}

	@Override
	protected List<String> parameters(Node refactoring) {
		// TODO Auto-generated method stub
		return null;
	}

}
