package com.gadberry.utility.expression.function;

import java.util.Date;
import java.util.List;

import com.gadberry.utility.CalendarUtils;
import com.gadberry.utility.CalendarUtils.Unit;
import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.Function;
import com.gadberry.utility.expression.InvalidArgumentsException;

/**
 * @author Aaron Gadberry
 */

public class DateDifferenceFunction extends Function {

	/**
	 * Create a DateDifferenceFunction with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public DateDifferenceFunction(Expression expression) {
		super(expression);
	}

	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		for (Argument arg : args) {
			if(arg.isNull()) {
				throw new InvalidArgumentsException(
						"DateDifferenceOperator cannot accept null arguments.  At least one argument provided was null.");
			}
		}
		
		if (!args.get(0).isDate() || !args.get(1).isDate()) {
			throw new InvalidArgumentsException(
					"DateDifferenceOperator requires two dates as the first two arguments.  Wrong type of arguments provided.");
		}

		try {
			Unit.valueOf(args.get(2).toString());
		} catch (IllegalArgumentException iae) {
			throw new InvalidArgumentsException(
					"DateDifferenceOperator requires a CalendarUtils.Unit as the third argument.  Wrong type of argument provided.");
		}
	}

	@Override
	public Argument resolve() {
		Date d1 = getArgument(0).toDate();
		Date d2 = getArgument(1).toDate();
		Unit unit = Unit.valueOf(getArgument(2).toString());

		return new Argument(new Long(CalendarUtils.difference(d1, d2, unit)), getResolver());
	}

}
