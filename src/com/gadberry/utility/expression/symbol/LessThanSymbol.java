package com.gadberry.utility.expression.symbol;

import java.util.Date;
import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.InvalidArgumentsException;
import com.gadberry.utility.expression.Symbol;

/**
 * @author Aaron Gadberry
 */

public class LessThanSymbol extends Symbol {

	/**
	 * Create a LessThanSymbol with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public LessThanSymbol(Expression expression) {
		super(expression);
	}

	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		if (args.size() != 2) {
			throw new InvalidArgumentsException(
					"LessThanOperator requires two arguments.  Wrong number of arguments provided.");
		}
	}

	public int getPriority() {
		return 5;
	}

	public Argument resolve() {
		if (getArgument(0).isDate() && getArgument(1).isDate()) {
			Date lhs = getArgument(0).toDate();
			Date rhs = getArgument(1).toDate();
			return new Argument(new Boolean(lhs.before(rhs)), getResolver());
		} else if (getArgument(0).isDouble() && getArgument(1).isDouble()) {
			double lhs = getArgument(0).toDouble();
			double rhs = getArgument(1).toDouble();
			return new Argument(new Boolean(lhs < rhs), getResolver());
		} else {
			String lhs = getArgument(0).toString();
			String rhs = getArgument(1).toString();
			return new Argument(new Boolean(lhs.compareTo(rhs) < 0), getResolver());
		}
	}

}
