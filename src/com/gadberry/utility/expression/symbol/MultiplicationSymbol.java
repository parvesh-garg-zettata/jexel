package com.gadberry.utility.expression.symbol;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class MultiplicationSymbol extends TwoDoublesSymbol {

	/**
	 * Create a MultiplicationSymbol with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public MultiplicationSymbol(Expression expression) {
		super(expression);
	}

	public int getPriority() {
		return 10;
	}

	public Argument resolve() {
		double lhs = getArgument(0).toDouble();
		double rhs = getArgument(1).toDouble();
		return new Argument(new Double(lhs * rhs), getResolver());
	}

}
