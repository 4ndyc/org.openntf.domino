/* Generated By:JJTree: Do not edit this line. ASTAtIsError.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.openntf.domino.formula.ast;

import java.util.Set;

import org.openntf.domino.formula.parse.*;
import org.openntf.domino.formula.FormulaContext;
import org.openntf.domino.formula.FormulaReturnException;
import org.openntf.domino.formula.ValueHolder;
import org.openntf.domino.formula.ValueHolder.DataType;

public class ASTAtIsError extends SimpleNode {

	public ASTAtIsError(final AtFormulaParserImpl p, final int id) {
		super(p, id);
	}

	@Override
	public ValueHolder evaluate(final FormulaContext ctx) throws FormulaReturnException {

		ValueHolder ret = children[0].evaluate(ctx);
		if (ret.dataType == DataType.ERROR)
			return ctx.TRUE;
		return ctx.FALSE;

	}

	public void toFormula(final StringBuilder sb) {
		sb.append("@IsError");
		appendParams(sb);

	}

	@Override
	protected void analyzeThis(final Set<String> readFields, final Set<String> modifiedFields, final Set<String> variables,
			final Set<String> functions) {
		functions.add("@iserror");
	}
}
/* JavaCC - OriginalChecksum=b3d48e49618a861ba4c9d1737e4b2b5f (do not edit this line) */
