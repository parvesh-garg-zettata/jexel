package com.gadberry.utility.expression.function;

import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.Function;
import com.gadberry.utility.expression.InvalidArgumentsException;

/**
 * @author Aaron Gadberry
 * 
 */
public class MockFunction extends Function {

    /**
     * @param expression
     */
    public MockFunction(Expression expression) {
	super(expression);
    }

    @Override
    protected void checkArgs(List<Argument> args)
	    throws InvalidArgumentsException {
	// Take no action
    }

    @Override
    public Argument resolve() {
	return new Argument(new Integer(1), getResolver());
    }
}
