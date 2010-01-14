package com.gadberry.utility.expression.symbol;

import java.util.ArrayList;
import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.InvalidArgumentsException;
import com.gadberry.utility.expression.Symbol;

/**
 * @author Aaron Gadberry
 */

public class LessThanOrEqualSymbol extends Symbol {

	/**
	 * Create a LessThanOrEqualSymbol with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public LessThanOrEqualSymbol(Expression expression) {
		super(expression);
	}

	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		if (args.size() != 2) {
			throw new InvalidArgumentsException(
					"LessThanOrEqualOperator requires two arguments.  Wrong number of arguments provided.");
		}
	}

	public int getPriority() {
		return 5;
	}

	public Argument resolve() {
		Argument lhs = getArgument(0);
		Argument rhs = getArgument(1);
		List<Argument> args = new ArrayList<Argument>();
		args.add(lhs);
		args.add(rhs);

		LessThanSymbol lts = new LessThanSymbol(getExpression());
		try {
			lts.setArguments(args);
		} catch (InvalidArgumentsException e) {
		}
		boolean lessThan = lts.resolve().toBoolean();

		EqualSymbol es = new EqualSymbol(getExpression());
		try {
			es.setArguments(args);
		} catch (InvalidArgumentsException e) {
		}
		boolean equal = es.resolve().toBoolean();
		return new Argument(new Boolean(lessThan || equal), getResolver());
	}

}
