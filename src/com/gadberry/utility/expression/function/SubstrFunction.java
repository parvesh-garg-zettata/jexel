package com.gadberry.utility.expression.function;

import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.Function;
import com.gadberry.utility.expression.InvalidArgumentsException;

/**
 * @author Aaron Gadberry
 */

public class SubstrFunction extends Function {

	/**
	 * Create a SubstrFunction with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public SubstrFunction(Expression expression) {
		super(expression);
	}

	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		for (Argument arg : args) {
			if(arg.isNull()) {
				throw new InvalidArgumentsException(
						"SubstrOperator cannot accept null arguments.  At least one argument provided is null.");
			}
		}
		if (args.size() == 2) {
			if (!args.get(1).isLong()) {
				throw new InvalidArgumentsException(
						"SubstrOperator requires one string and one or two integers.  Wrong type of arguments provided.");
			}
			if (args.get(1).toLong() < 0) {
				throw new InvalidArgumentsException("SubstrOperator requires positive integers.");
			}
		} else if (args.size() == 3) {
			if (!args.get(1).isLong() || !args.get(2).isLong()) {
				throw new InvalidArgumentsException(
						"SubstrOperator requires one string and one or two integers.  Wrong type of arguments provided.");
			}
			if (args.get(2).toLong() < 0) {
				throw new InvalidArgumentsException("SubstrOperator requires positive integers.");
			}
			if (args.get(1).toLong() > args.get(2).toLong()) {
				throw new InvalidArgumentsException(
						"SubstrOperator requires the first integer be smaller than the second integer.");
			}
		} else {
			throw new InvalidArgumentsException(
					"SubstrOperator requires one string and one or two integers.  Wrong type of arguments provided.");
		}

	}

	@Override
	public Argument resolve() {
		String s = getArgument(0).toString();
		int start = getArgument(1).toInteger();
		Argument result = null;
		if (getArguments().size() == 2) {
			result = new Argument(s.substring(start), getResolver());
		} else if (getArguments().size() == 3) {
			int end = getArgument(2).toInteger();
			result = new Argument(s.substring(start, end), getResolver());
		}
		return result;
	}
}
