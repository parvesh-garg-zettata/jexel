package com.gadberry.utility.expression.function;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class NegFunction extends OneDoubleFunction {

	/**
	 * Create a NegFunction with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public NegFunction(Expression expression) {
		super(expression);
	}

	@Override
	public Argument resolve() {
		return new Argument(-1 * getArgument(0).toDouble(), getResolver());
	}
}
