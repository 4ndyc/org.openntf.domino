/* Generated By:JJTree: Do not edit this line. ASTValueList.java Version 4.3 */
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
 */
package org.openntf.formula.ast;

import org.openntf.formula.FormulaContext;
import org.openntf.formula.FormulaReturnException;
import org.openntf.formula.ValueHolder;
import org.openntf.formula.ValueHolder.DataType;
import org.openntf.formula.parse.AtFormulaParserImpl;

public class ASTValueList extends SimpleNode {

	public ASTValueList(final AtFormulaParserImpl p, final int id) {
		super(p, id);
	}

	@Override
	public ValueHolder evaluate(final FormulaContext ctx) throws FormulaReturnException {

		ValueHolder[] tmpHolders = new ValueHolder[children.length];
		int valueSize = 0;
		int holders = 0;

		for (int i = 0; i < children.length; ++i) {
			// Cumulate all return values
			ValueHolder vh = children[i].evaluate(ctx);
			if (vh != null) {
				if (vh.dataType == DataType.ERROR)
					return vh;
				valueSize += vh.size;
				tmpHolders[holders++] = vh;
			}
		}

		if (holders == 0)
			return null;

		ValueHolder vhRet = tmpHolders[0].newInstance(valueSize);
		for (int i = 0; i < holders; i++) {
			vhRet.addAll(tmpHolders[i]);
		}
		return vhRet;
	}

}
/* JavaCC - OriginalChecksum=25778e343d16cbffbc665da744c998c5 (do not edit this line) */
