package com.gadberry.utility.expression.function;

import java.util.ArrayList;
import java.util.List;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Resolver;
import com.gadberry.utility.expression.function.Function;

import junit.framework.TestCase;

public class FunctionTests extends TestCase {

	private Function op = null;

	protected void setUp() throws Exception {
		super.setUp();
		op = new MockFunction();
	}

	protected void tearDown() throws Exception {
		op = null;
		super.tearDown();
	}

	/**
	 * This checks basic argument resolution
	 */
	public void testParseArgs() {
		List<String> tokens = new ArrayList<String>();
		tokens.add("functionName");
		tokens.add("(1, (1 + 2), today)");
		int position = 0;
		Resolver resolver = null;
		List<Argument> args = op.parseArgs(tokens, position, resolver);
		assertEquals(args.get(0), new Argument(1, null));
		assertEquals(args.get(1), new Argument("(1 + 2)", null));
		assertEquals(args.get(2), new Argument("today", null));
	}

	/**
	 * Verify the priority
	 */
	public void testGetPriority() {
		assertEquals(op.getPriority(), 20);
	}
}
