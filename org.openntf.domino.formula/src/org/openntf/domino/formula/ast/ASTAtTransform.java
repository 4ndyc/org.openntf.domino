/* Generated By:JJTree: Do not edit this line. ASTAtTransform.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.openntf.domino.formula.ast;

import java.util.Set;

import org.openntf.domino.formula.EvaluateException;
import org.openntf.domino.formula.FormulaContext;
import org.openntf.domino.formula.FormulaReturnException;
import org.openntf.domino.formula.ValueHolder;
import org.openntf.domino.formula.ValueHolder.DataType;
import org.openntf.domino.formula.parse.AtFormulaParserImpl;

public class ASTAtTransform extends SimpleNode {

	public ASTAtTransform(final AtFormulaParserImpl p, final int id) {
		super(p, id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public ValueHolder evaluate(final FormulaContext ctx) throws FormulaReturnException {
		try {
			ValueHolder list = children[0].evaluate(ctx);
			if (list.dataType == DataType.ERROR)
				return list;

			ValueHolder temp = children[1].evaluate(ctx);
			if (temp.dataType == DataType.ERROR)
				return temp;

			String varName = temp.getString(0).toLowerCase();
			ValueHolder[] tmpHolders = new ValueHolder[list.size];
			int valueSize = 0;
			int holders = 0;

			for (int i = 0; i < list.size; i++) {
				ValueHolder iter = list.newInstance(1);
				switch (list.dataType) {

				case INTEGER:
					iter.add(list.getInt(i));
					break;
				case DOUBLE:
					iter.add(list.getDouble(i));
					break;
				case BOOLEAN:
					iter.add(list.getBoolean(i));
					break;
				default:
					iter.add(list.getObject(i));
				}

				ValueHolder old = ctx.setVarLC(varName, iter);
				try {
					// Cumulate all return values
					ValueHolder vh = children[2].evaluate(ctx);
					if (vh != ValueHolder.valueNothing()) {
						valueSize += vh.size;
						tmpHolders[holders++] = vh;
						if (vh.dataType == DataType.ERROR)
							return vh;
					}
				} finally {
					ctx.setVarLC(varName, old);
				}
			}
			if (holders == 0)
				return null;

			ValueHolder vhRet = tmpHolders[0].newInstance(valueSize);
			for (int i = 0; i < holders; i++) {
				vhRet.addAll(tmpHolders[i]);
			}
			return vhRet;
		} catch (RuntimeException cause) {
			return ValueHolder.valueOf(new EvaluateException(codeLine, codeColumn, cause));
		}
	}

	@Override
	protected void analyzeThis(final Set<String> readFields, final Set<String> modifiedFields, final Set<String> variables,
			final Set<String> functions) {
		functions.add("@transform");
	}
}
/* JavaCC - OriginalChecksum=31c61346c6eb18629c143c94ecab660b (do not edit this line) */
