package com.gadberry.utility.expression.symbol;

import java.util.ArrayList;
import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.InvalidArgumentsException;

/**
 * @author Aaron Gadberry
 */

public class LessThanOrEqualSymbol extends TwoArgumentsSymbol {

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
	public int getPriority() {
		return 5;
	}

	@Override
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
