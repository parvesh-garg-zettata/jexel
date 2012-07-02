package com.gadberry.utility.expression.symbol;

import java.util.Date;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;

/**
 * @author Aaron Gadberry
 */

public class LessThanSymbol extends TwoArgumentsSymbol {

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
	public int getPriority() {
		return 5;
	}

	@Override
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
