package com.gadberry.utility.expression.function;

import java.util.Iterator;
import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.InvalidArgumentsException;
import com.gadberry.utility.expression.Resolver;

public class MaxFunction extends Function {

	protected void checkArgs(List<Argument> args)
			throws InvalidArgumentsException {
		if (args.size() < 2) {
			throw new InvalidArgumentsException(
					"MaxOperator requires a minimum of two doubles.  Wrong number of arguments provided.");
		}

		for (Argument arg : args) {
			if (!arg.isDouble()) {
				throw new InvalidArgumentsException(
						"MaxOperator only accepts doubles.  Wrong type of arguments provided.  Arg: "
								+ arg.toString());
			}
		}
	}

	public Argument resolve(Resolver resolver) {
		double max = 0;
		Iterator<Argument> iter = getArguments().iterator();
		max = iter.next().toDouble();
		while (iter.hasNext()) {
			Argument arg = iter.next();
			if (max < arg.toDouble()) {
				max = arg.toDouble();
			}
		}
		return new Argument(new Double(max), resolver);
	}
}