package com.gadberry.utility.expression.symbol;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class AndSymbol extends TwoBooleansSymbol {

	/**
	 * Create an AndSymbol with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public AndSymbol(Expression expression) {
		super(expression);
	}

	public int getPriority() {
		return 4;
	}

	public Argument resolve() {
		boolean lhs = getArgument(0).toBoolean();
		boolean rhs = getArgument(1).toBoolean();
		return new Argument(new Boolean(lhs && rhs), getResolver());
	}

}
