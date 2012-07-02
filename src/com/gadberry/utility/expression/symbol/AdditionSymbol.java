package com.gadberry.utility.expression.symbol;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class AdditionSymbol extends TwoArgumentsSymbol {

    /**
     * Create an AdditionSymbol with a given parent expression.
     * 
     * @param expression
     *            parent
     */
    public AdditionSymbol(Expression expression) {
	super(expression);
    }

    @Override
    public int getPriority() {
	return 6;
    }

    @Override
    public Argument resolve() {
	// if (getArgument(0).isInteger() && getArgument(1).isInteger()) {
	// long lhs = getArgument(0).toInteger();
	// long rhs = getArgument(1).toInteger();
	// return new Argument(new Long(lhs + rhs), getResolver());
	// }
	if (getArgument(0).isDouble() && getArgument(1).isDouble()) {
	    double lhs = getArgument(0).toDouble();
	    double rhs = getArgument(1).toDouble();
	    return new Argument(lhs + rhs, getResolver());
	}

	String lhs = getArgument(0).toString();
	String rhs = getArgument(1).toString();
	return new Argument(lhs + rhs, getResolver());
    }

}
