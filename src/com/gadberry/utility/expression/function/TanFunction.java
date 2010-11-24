package com.gadberry.utility.expression.function;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class TanFunction extends OneDoubleFunction {

	/**
	 * Create a TanFunction with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public TanFunction(Expression expression) {
		super(expression);
	}

	public Argument resolve() {
		return new Argument(Math.tan(getArgument(0).toDouble()), getResolver());
	}
}
