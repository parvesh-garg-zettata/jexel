package com.gadberry.utility.expression.function;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class AtanFunction extends OneDoubleFunction {

    /**
     * Create an AtanFunction with a given parent expression.
     * 
     * @param expression
     *            parent
     */
    public AtanFunction(Expression expression) {
	super(expression);
    }

    @Override
    public Argument resolve() {
	return new Argument(Math.atan((getArgument(0).toDouble())),
		getResolver());
    }
}
