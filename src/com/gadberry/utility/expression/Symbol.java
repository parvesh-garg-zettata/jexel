package com.gadberry.utility.expression;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aaron Gadberry
 */

public abstract class Symbol extends OperatorImpl {

	/**
	 * Create a symbol with a given parent expression.
	 * 
	 * @param expression
	 *            parent
	 */
	public Symbol(Expression expression) {
		super(expression);
	}

	@Override
	public List<Argument> parseArgs(List<String> tokens, int position) {
		List<Argument> args = new ArrayList<Argument>();
		if (position > 0) {
			// There is a left hand argument
			StringBuffer lhs = new StringBuffer();
			for (int j = 0; j < position; j++) {
				lhs.append(tokens.get(j));
			}
			args.add(new Argument(lhs.toString().trim(), getResolver()));
			// System.out.println("LHS:" + lhs.toString());
		}
		if (position < tokens.size()) {
			// There is a right hand argument
			StringBuffer rhs = new StringBuffer();
			for (int j = position + 1; j < tokens.size(); j++) {
				rhs.append(tokens.get(j));
			}
			args.add(new Argument(rhs.toString().trim(), getResolver()));
			// System.out.println("RHS:" + rhs.toString());
		}
		return args;
	}
}
