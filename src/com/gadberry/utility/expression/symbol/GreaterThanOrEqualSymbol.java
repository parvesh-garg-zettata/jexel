package com.gadberry.utility.expression.symbol;

import java.util.ArrayList;
import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.InvalidArgumentsException;

/**
 * @author Aaron Gadberry
 */

public class GreaterThanOrEqualSymbol extends TwoArgumentsSymbol {

	/**
	 * Create a GreaterThanOrEqualSymbol with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public GreaterThanOrEqualSymbol(Expression expression) {
		super(expression);
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

		GreaterThanSymbol gts = new GreaterThanSymbol(getExpression());
		try {
			gts.setArguments(args);
		} catch (InvalidArgumentsException e) {
		}
		boolean greaterThan = gts.resolve().toBoolean();

		EqualSymbol es = new EqualSymbol(getExpression());
		try {
			es.setArguments(args);
		} catch (InvalidArgumentsException e) {
		}
		boolean equal = es.resolve().toBoolean();
		return new Argument(new Boolean(greaterThan || equal), getResolver());
	}

}
