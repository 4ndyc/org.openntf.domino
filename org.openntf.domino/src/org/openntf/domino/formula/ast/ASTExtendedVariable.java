/* Generated By:JJTree: Do not edit this line. ASTExtendedVariable.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.openntf.domino.formula.ast;

import java.util.Set;

import org.openntf.domino.formula.parse.*;
import org.openntf.domino.formula.FormulaContext;
import org.openntf.domino.formula.FormulaReturnException;
import org.openntf.domino.formula.ValueHolder;

public class ASTExtendedVariable extends SimpleNode {
	String varName;

	public ASTExtendedVariable(final AtFormulaParserImpl p, final int id) {
		super(p, id);
	}

	@Override
	public ValueHolder evaluate(final FormulaContext ctx) throws FormulaReturnException {
		if (children == null)
			return ValueHolder.valueDefault();
		return children[0].evaluate(ctx);

	}

	public void init(final String image) {
		varName = image.toLowerCase();
	}

	public String getNameLC() {
		return varName;
	}

	@Override
	protected void analyzeThis(final Set<String> readFields, final Set<String> modifiedFields, final Set<String> variables,
			final Set<String> functions) {
		// TODO Auto-generated method stub

	}

	public void toFormula(final StringBuilder sb) {
		// TODO Auto-generated method stub

	}

}
/* JavaCC - OriginalChecksum=7edeb541ef44a13276e317321e9a6744 (do not edit this line) */
