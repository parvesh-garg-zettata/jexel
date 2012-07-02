package com.gadberry.utility.expression.symbol;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class EqualSymbol extends TwoArgumentsSymbol {

	/**
	 * Create an EqualSymbol with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public EqualSymbol(Expression expression) {
		super(expression);
	}

	@Override
	public int getPriority() {
		return 5;
	}

	@Override
	public Argument resolve() {
		Argument lhs = getArgument(0);
		Argument rhs = getArgument(1);
		return new Argument(new Boolean(lhs.equals(rhs)), getResolver());
	}

}
