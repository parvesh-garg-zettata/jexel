package com.gadberry.utility.expression.function;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class CeilFunction extends OneDoubleFunction {

    /**
     * Create a CeilFunction with a given parent expression.
     * 
     * @param expression
     *            parent
     */
    public CeilFunction(Expression expression) {
	super(expression);
    }

    @Override
    public Argument resolve() {
	double n = getArgument(0).toDouble();
	return new Argument(Math.ceil(n), getResolver());
    }
}
