package com.gadberry.utility.expression.symbol;

import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.InvalidArgumentsException;

public abstract class TwoBooleansSymbol extends TwoArgumentsSymbol {

	public TwoBooleansSymbol(Expression expression) {
		super(expression);
	}

	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		super.checkArgs(args);
		String canonicalName = this.getClass().getCanonicalName();
		if (!args.get(0).isBoolean() || !args.get(1).isBoolean()) {
			throw new InvalidArgumentsException(
					canonicalName + " requires two booleans.  Wrong type of arguments provided.");
		}
	}
}
