/* Generated By:JJTree: Do not edit this line. ASTUserDefinedInclude.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.openntf.domino.formula.ast;

import org.openntf.domino.formula.FormulaContext;
import org.openntf.domino.formula.FormulaReturnException;
import org.openntf.domino.formula.ValueHolder;
import org.openntf.domino.formula.parse.AtFormulaParserImpl;

public class ASTUserDefinedInclude extends SimpleNode {

	public ASTUserDefinedInclude(final AtFormulaParserImpl p, final int id) {
		super(p, id);
	}

	@Override
	public ValueHolder evaluate(final FormulaContext ctx) throws FormulaReturnException {
		// TODO RPR: This is not yet implemented!
		Node inc = null;// ctx.getInclude
		return inc.evaluate(ctx);
	}

}
/* JavaCC - OriginalChecksum=df1231d5cd4699152b313be5d9bef577 (do not edit this line) */
