package com.gadberry.utility.expression.function;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class RadiansToDegreesFunction extends OneDoubleFunction {

	/**
	 * Create a RadiansToDegreesFunction with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public RadiansToDegreesFunction(Expression expression) {
		super(expression);
	}

	public Argument resolve() {
		return new Argument(Math.toDegrees(getArgument(0).toDouble()), getResolver());
	}
}
