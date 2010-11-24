package com.gadberry.utility.expression.symbol;

import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.InvalidArgumentsException;

public abstract class TwoDoublesSymbol extends TwoArgumentsSymbol {

	public TwoDoublesSymbol(Expression expression) {
		super(expression);
	}

	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		super.checkArgs(args);
		String canonicalName = this.getClass().getCanonicalName();
		if (!args.get(0).isDouble() || !args.get(1).isDouble()) {
			throw new InvalidArgumentsException(
					canonicalName + " requires two doubles.  Wrong type of arguments provided.");
		}
	}
}
