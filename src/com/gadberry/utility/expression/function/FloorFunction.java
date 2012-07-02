package com.gadberry.utility.expression.function;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class FloorFunction extends OneDoubleFunction {

	/**
	 * Create a FloorFunction with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public FloorFunction(Expression expression) {
		super(expression);
	}

	@Override
	public Argument resolve() {
		double n = getArgument(0).toDouble();
		return new Argument(Math.floor(n), getResolver());
	}
}
