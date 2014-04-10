/* Generated By:JJTree: Do not edit this line. ASTAtReturn.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
/*
 * © Copyright FOCONIS AG, 2014
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 * 
 */
package org.openntf.domino.formula.ast;

import java.util.Set;

import org.openntf.domino.formula.FormulaContext;
import org.openntf.domino.formula.FormulaReturnException;
import org.openntf.domino.formula.ValueHolder;
import org.openntf.domino.formula.parse.AtFormulaParserImpl;

/**
 * Implements the {@literal @}Return function. This is implemented by throwing a FormulaReturnException that is catched by the caller
 * 
 * @author Roland Praml, Foconis AG
 * 
 */
public class ASTAtReturn extends SimpleNode {

	public ASTAtReturn(final AtFormulaParserImpl p, final int id) {
		super(p, id);
	}

	/**
	 * This throws a FormulaReturnException. Should be catched somewhere outside
	 */
	@Override
	public ValueHolder evaluate(final FormulaContext ctx) throws FormulaReturnException {
		throw new FormulaReturnException(children[0].evaluate(ctx));
	}

	/*
	 * (non-Javadoc)
	 * @see org.openntf.domino.formula.ast.SimpleNode#analyzeThis(java.util.Set, java.util.Set, java.util.Set, java.util.Set)
	 */
	@Override
	protected void analyzeThis(final Set<String> readFields, final Set<String> modifiedFields, final Set<String> variables,
			final Set<String> functions) {
		functions.add("@return");
	}
}
/* JavaCC - OriginalChecksum=5168aab1704c82b602ede3bcf029d247 (do not edit this line) */
