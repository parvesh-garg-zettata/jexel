package com.gadberry.utility.expression.operator;

import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.InvalidArgumentsException;
import com.gadberry.utility.expression.Resolver;

public class SubtractionOperator extends Operator {

	protected void checkArgs(List<Argument> args)
			throws InvalidArgumentsException {
		if (args.size() != 2) {
			throw new InvalidArgumentsException(
					"SubtractionOperator requires two doubles.  Wrong number of arguments provided.");
		}

		if (!args.get(0).isDouble() || !args.get(1).isDouble()) {
			throw new InvalidArgumentsException(
					"SubtractionOperator requires two doubles.  Wrong type of arguments provided.");
		}
	}

	public Argument resolve(Resolver resolver) {
		double lhs = getArgument(0).toDouble();
		double rhs = getArgument(1).toDouble();
		return new Argument(new Double(lhs - rhs), resolver);
	}

	public int getPriority() {
		return 1;
	}

	public String getType() {
		return Operator.STANDARD;
	}
}
