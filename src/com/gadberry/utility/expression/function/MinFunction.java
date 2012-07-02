package com.gadberry.utility.expression.function;

import java.util.Iterator;
import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.Function;
import com.gadberry.utility.expression.InvalidArgumentsException;

/**
 * @author Aaron Gadberry
 */

public class MinFunction extends Function {

    /**
     * Create a MinFunction with a given parent expression.
     * 
     * @param expression
     *            parent
     */
    public MinFunction(Expression expression) {
	super(expression);
    }

    @Override
    protected void checkArgs(List<Argument> args)
	    throws InvalidArgumentsException {
	if (args.size() < 2) {
	    throw new InvalidArgumentsException(
		    "MinOperator requires a minimum of two doubles.  Wrong number of arguments provided.");
	}

	for (Argument arg : args) {
	    if (arg.isNull()) {
		throw new InvalidArgumentsException(
			"MinOperator cannot accept null arguments.  The argument provided is null.");
	    } else if (!arg.isDouble()) {
		throw new InvalidArgumentsException(
			"MinOperator only accepts doubles.  Wrong type of arguments provided.  Arg: "
				+ arg.toString());
	    }
	}
    }

    @Override
    public Argument resolve() {
	double min = 0;
	Iterator<Argument> iter = getArguments().iterator();
	min = iter.next().toDouble();
	while (iter.hasNext()) {
	    Argument arg = iter.next();
	    if (min > arg.toDouble()) {
		min = arg.toDouble();
	    }
	}
	return new Argument(min, getResolver());
    }

}
