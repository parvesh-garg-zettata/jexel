package com.gadberry.utility.expression;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aaron Gadberry
 */

public abstract class Function extends OperatorImpl {

	/**
	 * Create a function with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public Function(Expression expression) {
		super(expression);
	}

	private static List<String> tokenize(String expression, char splitChar) {
		expression = Expression.trim(expression);
		int parentheticalDepth = 0;
		boolean insideLiteral = false;
		List<String> tokens = new ArrayList<String>();
		StringBuffer currentToken = new StringBuffer();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '(') {
				parentheticalDepth++;
			} else if (c == ')') {
				parentheticalDepth--;
			} else if (c == Expression.LITERAL_CHARACTER) {
				insideLiteral = !insideLiteral;
			} else if (parentheticalDepth == 0 && c == splitChar && !insideLiteral) {
				tokens.add(currentToken.toString());
				currentToken = new StringBuffer();

				// No need to add the splitchar so we'll fast forward
				continue;
			}
			currentToken.append(c);
		}
		tokens.add(currentToken.toString());
		return tokens;
	}

	public int getPriority() {
		return 20;
	}

	public List<Argument> parseArgs(List<String> tokens, int position) {
		List<Argument> args = new ArrayList<Argument>();
		String argumentString = Expression.trim(tokens.get(1));
		List<String> stringArgs = tokenize(argumentString, ',');
		for (String stringArg : stringArgs) {
			args.add(new Argument(stringArg.trim(), getResolver()));
		}
		return args;
	}
}
