package com.gadberry.utility.expression.symbol;

import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.InvalidArgumentsException;
import com.gadberry.utility.expression.Symbol;

/**
 * @author Aaron Gadberry
 */

public class AdditionSymbol extends Symbol {

	/**
	 * Create an AdditionSymbol with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public AdditionSymbol(Expression expression) {
		super(expression);
	}

	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		if (args.size() != 2) {
			throw new InvalidArgumentsException(
					"AdditionOperator requires two arguments.  Wrong number of arguments provided.");
		}

	}

	public int getPriority() {
		return 6;
	}

	public Argument resolve() {
		if (getArgument(0).isDouble() && getArgument(1).isDouble()) {
			double lhs = getArgument(0).toDouble();
			double rhs = getArgument(1).toDouble();
			return new Argument(new Double(lhs + rhs), getResolver());
		} else {
			String lhs = getArgument(0).toString();
			String rhs = getArgument(1).toString();
			return new Argument(lhs + rhs, getResolver());
		}
	}

}
