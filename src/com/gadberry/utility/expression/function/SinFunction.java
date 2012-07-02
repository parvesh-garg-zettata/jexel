package com.gadberry.utility.expression.function;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class SinFunction extends OneDoubleFunction {

	/**
	 * Create a SinFunction with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public SinFunction(Expression expression) {
		super(expression);
	}

	@Override
	public Argument resolve() {
		return new Argument(Math.sin(getArgument(0).toDouble()), getResolver());
	}
}
