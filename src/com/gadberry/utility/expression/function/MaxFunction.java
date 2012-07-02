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

public class MaxFunction extends Function {

	/**
	 * Create a MaxFunction with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public MaxFunction(Expression expression) {
		super(expression);
	}

	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		if (args.size() < 2) {
			throw new InvalidArgumentsException(
					"MaxOperator requires a minimum of two doubles.  Wrong number of arguments provided.");
		}

		for (Argument arg : args) {
			if(arg.isNull()) {
				throw new InvalidArgumentsException(
						"MaxOperator cannot accept null arguments.  The argument provided is null.");
			} else if (!arg.isDouble()) {
				throw new InvalidArgumentsException(
						"MaxOperator only accepts doubles.  Wrong type of arguments provided.  Arg: " + arg.toString());
			}
		}
	}

	@Override
	public Argument resolve() {
		double max = 0;
		Iterator<Argument> iter = getArguments().iterator();
		max = iter.next().toDouble();
		while (iter.hasNext()) {
			Argument arg = iter.next();
			if (max < arg.toDouble()) {
				max = arg.toDouble();
			}
		}
		return new Argument(max, getResolver());
	}
}
