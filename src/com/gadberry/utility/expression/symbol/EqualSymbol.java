package com.gadberry.utility.expression.symbol;

import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.InvalidArgumentsException;
import com.gadberry.utility.expression.Symbol;

/**
 * @author Aaron Gadberry
 */

public class EqualSymbol extends Symbol {

	/**
	 * Create an EqualSymbol with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public EqualSymbol(Expression expression) {
		super(expression);
	}

	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		if (args.size() != 2) {
			throw new InvalidArgumentsException(
					"EqualOperator requires two arguments.  Wrong number of arguments provided.");
		}
	}

	public int getPriority() {
		return 5;
	}

	public Argument resolve() {
		Argument lhs = getArgument(0);
		Argument rhs = getArgument(1);
		return new Argument(new Boolean(lhs.equals(rhs)), getResolver());
	}

}
