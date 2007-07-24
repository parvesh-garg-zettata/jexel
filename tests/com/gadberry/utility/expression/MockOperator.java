package com.gadberry.utility.expression;

import java.util.ArrayList;
import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.InvalidArgumentsException;
import com.gadberry.utility.expression.Resolver;

public class MockOperator extends OperatorImpl {

	protected void checkArgs(List<Argument> args)
			throws InvalidArgumentsException {
	}

	public int getPriority() {
		return 0;
	}

	public Argument resolve(Resolver resolver) {
		return null;
	}

	@Override
	public List<Argument> parseArgs(List<String> tokens, int position, Resolver resolver) {
		return new ArrayList<Argument>();
	}

}