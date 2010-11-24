package com.gadberry.utility.expression.function;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class AbsFunction extends OneDoubleFunction {

	/**
	 * Create an AbsFunction with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public AbsFunction(Expression expression) {
		super(expression);
	}

	public Argument resolve() {
		return new Argument(Math.abs(getArgument(0).toDouble()), getResolver());
	}
}
