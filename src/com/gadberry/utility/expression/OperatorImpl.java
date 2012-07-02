package com.gadberry.utility.expression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Aaron Gadberry
 */

public abstract class OperatorImpl implements Operator {

	OperatorImpl(Expression expression) {
		parentExpression = expression;
	}

	private List<Argument> arguments = null;

	protected Expression parentExpression = null;

	protected abstract void checkArgs(List<Argument> args) throws InvalidArgumentsException;

	@Override
	public Argument getArgument(int i) {
		return arguments.get(i);
	}

	@Override
	public List<Argument> getArguments() {
		return arguments;
	}

	private List<Argument> resolveArguments(List<Argument> args) {
		List<Argument> resolvedArgs = new ArrayList<Argument>(args.size());
		Iterator<Argument> iter = args.iterator();
		while (iter.hasNext()) {
			Argument arg = iter.next();
			if (!arg.isResolved() && !arg.isNull()) {
				try {
					Expression expression = new Expression(arg.toString());
					expression.setOperatorSet(getOperatorSet());
					expression.setResolver(getResolver());

					arg = expression.evaluate();
				} catch (InvalidExpressionException e) {
				}
			}
			resolvedArgs.add(arg);
		}
		return resolvedArgs;
	}

	private OperatorSet getOperatorSet() {
		if (parentExpression != null) {
			return parentExpression.getOperatorSet();
		}
		return Expression.getDefaultOperatorSet();
	}

	@Override
	public void setArguments(List<Argument> args) throws InvalidArgumentsException {
		List<Argument> resolvedArgs = resolveArguments(args);
		checkArgs(resolvedArgs);
		arguments = resolvedArgs;
	}

	protected Resolver getResolver() {
		if (parentExpression != null) {
			return parentExpression.getResolver();
		}
		return null;
	}

	protected Expression getExpression() {
		return parentExpression;
	}
}
