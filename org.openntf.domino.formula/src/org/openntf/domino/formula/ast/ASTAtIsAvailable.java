/* Generated By:JJTree: Do not edit this line. ASTAtIsAvailable.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.openntf.domino.formula.ast;

import java.util.Set;

import org.openntf.domino.formula.FormulaContext;
import org.openntf.domino.formula.FormulaReturnException;
import org.openntf.domino.formula.ValueHolder;
import org.openntf.domino.formula.ValueHolder.DataType;
import org.openntf.domino.formula.parse.AtFormulaParserImpl;

public class ASTAtIsAvailable extends SimpleNode {

	public ASTAtIsAvailable(final AtFormulaParserImpl p, final int id) {
		super(p, id);
	}

	protected boolean checkAvailable(final FormulaContext ctx) throws FormulaReturnException {
		if (children[0] instanceof ASTGetVariable) {
			ASTGetVariable child = (ASTGetVariable) children[0];
			return ctx.isAvailableVarLC(child.variableNameLC);
		}
		return children[0].evaluate(ctx).dataType != DataType.UNAVAILABLE;
	}

	@Override
	public ValueHolder evaluate(final FormulaContext ctx) throws FormulaReturnException {
		return checkAvailable(ctx) ? ctx.TRUE : ctx.FALSE;
	}

	@Override
	protected void analyzeThis(final Set<String> readFields, final Set<String> modifiedFields, final Set<String> variables,
			final Set<String> functions) {
		functions.add("@isavailable");
	}

}
/* JavaCC - OriginalChecksum=3aebf134d03c78aabb5641b63e1b4619 (do not edit this line) */
