package com.gadberry.utility.expression.function;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class DegreesToRadiansFunction extends OneDoubleFunction {

	/**
	 * Create a DegreesToRadiansFunction with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public DegreesToRadiansFunction(Expression expression) {
		super(expression);
	}

	@Override
	public Argument resolve() {
		return new Argument(Math.toRadians(getArgument(0).toDouble()), getResolver());
	}
}
