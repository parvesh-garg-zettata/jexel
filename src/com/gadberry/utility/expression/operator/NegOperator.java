package com.gadberry.utility.expression.operator;

import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.InvalidArgumentsException;
import com.gadberry.utility.expression.Resolver;

public class NegOperator extends Operator {

	protected void checkArgs(List<Argument> args)
			throws InvalidArgumentsException {
		if (args.size() != 1) {
			throw new InvalidArgumentsException(
					"NegOperator requires a single doubles.  Wrong number of arguments provided.");
		}

		for (Argument arg : args) {
			if (!arg.isDouble()) {
				throw new InvalidArgumentsException(
						"NegOperator only accepts doubles.  Wrong type of arguments provided.  Arg: "
								+ arg.toString());
			}
		}
	}

	public Argument resolve(Resolver resolver) {
		return new Argument(-1 * getArgument(0).toDouble(), resolver);
	}

	public int getPriority() {
		return 20;
	}

	public String getType() {
		return Operator.FUNCTION;
	}
}