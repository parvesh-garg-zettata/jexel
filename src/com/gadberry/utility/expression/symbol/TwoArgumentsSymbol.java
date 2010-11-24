package com.gadberry.utility.expression.symbol;

import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.InvalidArgumentsException;
import com.gadberry.utility.expression.Symbol;

public abstract class TwoArgumentsSymbol extends Symbol {

	public TwoArgumentsSymbol(Expression expression) {
		super(expression);
	}

	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		String canonicalName = this.getClass().getCanonicalName();
		if (args.size() != 2) {
			throw new InvalidArgumentsException(
					canonicalName + " requires two arguments.  Wrong number of arguments provided.");
		}
	}
}
