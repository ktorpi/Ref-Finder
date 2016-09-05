package lsclipse.position;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import changetypes.ASTVisitorAtomicChange;

public class PositionFactory {
	private Map<String, Position> positions;

	public PositionFactory() {
		positions = new HashMap<String, Position>();
	}
	
	public void createPosition(MethodDeclaration node) {
		IMethodBinding mtb = node.resolveBinding();
		String qualifiedName = ASTVisitorAtomicChange.getQualifiedName(mtb);
		
		CompilationUnit root = (CompilationUnit)node.getRoot();
		int line = root.getLineNumber(node.getStartPosition());
		int column = root.getColumnNumber(node.getStartPosition());
		String path = root.getJavaElement().getPath().makeAbsolute().toString();
		
		positions.put(qualifiedName, new Position(line, column, path));
	}

	
	public void createPosition(TypeDeclaration node) {
		ITypeBinding itb = node.resolveBinding();
		String qualifiedName = ASTVisitorAtomicChange.getQualifiedName(itb);
		
		CompilationUnit root = (CompilationUnit)node.getRoot();
		int line = root.getLineNumber(node.getStartPosition());
		int column = root.getColumnNumber(node.getStartPosition());
		String path = root.getJavaElement().getPath().makeAbsolute().toString();
		
		positions.put(qualifiedName, new Position(line, column, path));
	}
	
	public void createPosition(VariableDeclarationFragment node) {
		IVariableBinding ivb = node.resolveBinding();
		String qualifiedName = ASTVisitorAtomicChange.getQualifiedName(ivb);
		
		CompilationUnit root = (CompilationUnit)node.getRoot();
		int line = root.getLineNumber(node.getStartPosition());
		int column = root.getColumnNumber(node.getStartPosition());
		String path = root.getJavaElement().getPath().makeAbsolute().toString();
		
		positions.put(qualifiedName, new Position(line, column, path));
	}
	
	
	public void dump(PrintStream out) {
		for (String key : positions.keySet()) {
			out.println(key + "@" + positions.get(key));
		}
	}
	
	public Position getPosition(String key) {
		return positions.containsKey(key) ? positions.get(key) : new NullPosition();
	}
	
	public void clear() {
		positions.clear();
	}
	
}
