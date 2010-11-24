package com.gadberry.utility.expression.symbol;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class OrSymbol extends TwoBooleansSymbol {

	/**
	 * Create an OrSymbol with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public OrSymbol(Expression expression) {
		super(expression);
	}

	public int getPriority() {
		return 3;
	}

	public Argument resolve() {
		boolean lhs = getArgument(0).toBoolean();
		boolean rhs = getArgument(1).toBoolean();
		return new Argument(new Boolean(lhs || rhs), getResolver());
	}

}
