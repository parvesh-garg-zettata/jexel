package com.gadberry.utility.expression;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aaron Gadberry
 */

public class MockOperator extends OperatorImpl {

    MockOperator(Expression expression) {
	super(expression);
    }

    @Override
    protected void checkArgs(List<Argument> args)
	    throws InvalidArgumentsException {
    }

    @Override
    public int getPriority() {
	return 0;
    }

    @Override
    public List<Argument> parseArgs(List<String> tokens, int position) {
	return new ArrayList<Argument>();
    }

    @Override
    public Argument resolve() {
	return null;
    }

}
