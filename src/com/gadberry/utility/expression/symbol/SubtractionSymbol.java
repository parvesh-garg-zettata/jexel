package com.gadberry.utility.expression.symbol;

import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.InvalidArgumentsException;
import com.gadberry.utility.expression.Symbol;

/**
 * @author Aaron Gadberry
 */

public class SubtractionSymbol extends Symbol {

	/**
	 * Create a SubtractionSymbol with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public SubtractionSymbol(Expression expression) {
		super(expression);
	}

	@Override
	protected void checkArgs(List<Argument> args) throws InvalidArgumentsException {
		if (args.size() != 2) {
			throw new InvalidArgumentsException(
					"SubtractionOperator requires two doubles.  Wrong number of arguments provided.");
		}

		if (!args.get(0).isDouble() || !args.get(1).isDouble()) {
			throw new InvalidArgumentsException(
					"SubtractionOperator requires two doubles.  Wrong type of arguments provided.");
		}
	}

	public int getPriority() {
		return 7;
	}

	public Argument resolve() {
		double lhs = getArgument(0).toDouble();
		double rhs = getArgument(1).toDouble();
		return new Argument(new Double(lhs - rhs), getResolver());
	}

}
