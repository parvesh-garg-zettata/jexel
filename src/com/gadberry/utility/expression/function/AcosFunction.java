package com.gadberry.utility.expression.function;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class AcosFunction extends OneDoubleFunction {

	/**
	 * Create an AcosFunction with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public AcosFunction(Expression expression) {
		super(expression);
	}

	@Override
	public Argument resolve() {
		return new Argument(Math.acos((getArgument(0).toDouble())), getResolver());
	}
}
