package com.gadberry.utility.expression.function;

import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.Function;
import com.gadberry.utility.expression.InvalidArgumentsException;

/**
 * @author Aaron Gadberry
 */

public class NotFunction extends Function {

	/**
	 * Create a NotFunction with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public NotFunction(Expression expression) {
		super(expression);
	}

	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		if (args.size() != 1) {
			throw new InvalidArgumentsException(
					"NotOperator requires one boolean.  Wrong number of arguments provided.");
		}

		if(args.get(0).isNull()) {
			throw new InvalidArgumentsException(
					"NotOperator cannot accept null arguments.  The argument provided is null.");
		} else if (!args.get(0).isBoolean()) {
			throw new InvalidArgumentsException("NotOperator requires one boolean.  Wrong type of arguments provided.");
		}
	}

	@Override
	public Argument resolve() {
		boolean arg = getArgument(0).toBoolean();
		return new Argument(new Boolean(!arg), getResolver());
	}
}
