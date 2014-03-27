/* Generated By:JJTree: Do not edit this line. ASTExtendedFunction.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.openntf.domino.formula.ast;

import java.util.Set;

import org.openntf.domino.formula.parse.*;
import org.openntf.domino.formula.FormulaContext;
import org.openntf.domino.formula.FormulaReturnException;
import org.openntf.domino.formula.ParseException;
import org.openntf.domino.formula.ValueHolder;
import org.openntf.domino.formula.impl.ExtendedFunction;

/**
 * @author Roland Praml, Foconis AG
 * 
 */
public class ASTExtendedFunction extends SimpleNode {
	private boolean prototype;

	public ASTExtendedFunction(final AtFormulaParserImpl p, final int id) {
		super(p, id);
	}

	public void toFormula(final StringBuilder sb) {
		// does not generate any output
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.formula.ast.SimpleNode#jjtClose()
	 */
	//@Override
	public void xjjtClose() throws ParseException {
		int functionParameters = 0;
		int functionVariables = 0;
		if (children != null) {
			int i = 0;

			for (; i < children.length; i++) {
				if (!(children[i] instanceof ASTExtendedParameter))
					break;
				functionParameters++;
			}

			// no function definition present
			prototype = i == children.length;

		}

		ASTExtendedParameter[] parameter = new ASTExtendedParameter[functionParameters];
		ASTExtendedVariable[] variable = new ASTExtendedVariable[functionVariables];
		Node functionImpl = prototype ? null : children[children.length - 1];

		for (int i = 0; i < functionParameters; i++) {
			parameter[i] = (ASTExtendedParameter) children[i];
		}

		for (int i = 0; i < functionVariables; i++) {
			variable[i] = (ASTExtendedVariable) children[functionParameters + i];
		}

		//function.init(parameter, variable, functionImpl, parser);
		super.jjtClose();
	}

	@Override
	public ValueHolder evaluate(final FormulaContext ctx) throws FormulaReturnException {
		return ValueHolder.valueOf("");
	}

	@Override
	protected void analyzeThis(final Set<String> readFields, final Set<String> modifiedFields, final Set<String> variables,
			final Set<String> functions) {
		// TODO
	}

	/**
	 * A extended function needs not to inspect it's children. If the function is never invoked, nothing is needed
	 */
	@Override
	public void inspect(final Set<String> readFields, final Set<String> modifiedFields, final Set<String> variables,
			final Set<String> functions) {
	}

	public void init() {
		int functionVariables = 0;
		ASTExtendedFunctionDef def = (ASTExtendedFunctionDef) children[0];

		ExtendedFunction function = def.getFunction();

		for (int i = 1; i < children.length; i++) {
			if (children[i] instanceof ASTExtendedVariable) {
				functionVariables++;
			} else {
				function.setFunction(children[i]);
			}
		}

		ASTExtendedVariable[] var = new ASTExtendedVariable[functionVariables];
		for (int i = 0; i < functionVariables; i++) {
			var[i] = (ASTExtendedVariable) children[i + 1];
		}

		function.setVariables(var);

	}
}
/* JavaCC - OriginalChecksum=0bef6e155cd93f4bed8a7902e8dc69c4 (do not edit this line) */
