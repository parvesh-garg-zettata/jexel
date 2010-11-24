package com.gadberry.utility.expression.function;

import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.Function;
import com.gadberry.utility.expression.InvalidArgumentsException;

public abstract class OneDoubleFunction extends Function {

	public OneDoubleFunction(Expression expression) {
		super(expression);
	}
	
	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		String canonicalName = this.getClass().getCanonicalName();
		if (args.size() != 1) {
			throw new InvalidArgumentsException(
					canonicalName + " requires a single double.  Wrong number of arguments provided.");
		}

		for (Argument arg : args) {
			if(arg.isNull()) {
				throw new InvalidArgumentsException(
						canonicalName + " cannot accept null arguments.  The argument provided is null.");
			} else if (!arg.isDouble()) {
				throw new InvalidArgumentsException(
						canonicalName + " only accepts doubles.  Wrong type of argument provided.  Arg: " + arg.toString());
			}
		}
	}

}
