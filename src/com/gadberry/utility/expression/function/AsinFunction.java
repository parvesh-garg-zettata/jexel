package com.gadberry.utility.expression.function;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class AsinFunction extends OneDoubleFunction {

    /**
     * Create an AsinFunction with a given parent expression.
     * 
     * @param expression
     *            parent
     */
    public AsinFunction(Expression expression) {
	super(expression);
    }

    @Override
    public Argument resolve() {
	return new Argument(Math.asin((getArgument(0).toDouble())),
		getResolver());
    }
}
