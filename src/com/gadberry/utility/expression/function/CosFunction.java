package com.gadberry.utility.expression.function;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class CosFunction extends OneDoubleFunction {

	/**
	 * Create a CosFunction with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public CosFunction(Expression expression) {
		super(expression);
	}

	@Override
	public Argument resolve() {
		return new Argument(Math.cos(getArgument(0).toDouble()), getResolver());
	}
}
