package com.gadberry.utility.expression.symbol;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class SubtractionSymbol extends TwoDoublesSymbol {

    /**
     * Create a SubtractionSymbol with a given parent expression.
     * 
     * @param expression
     *            parent
     */
    public SubtractionSymbol(Expression expression) {
	super(expression);
    }

    @Override
    public int getPriority() {
	return 7;
    }

    @Override
    public Argument resolve() {
	double lhs = getArgument(0).toDouble();
	double rhs = getArgument(1).toDouble();
	return new Argument(lhs - rhs, getResolver());
    }

}
