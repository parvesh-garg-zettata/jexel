package com.gadberry.utility.expression.function;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Function;

/**
 * @author Aaron Gadberry
 * 
 */
public class FunctionTests {

    private Function op = null;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
	op = new MockFunction(null);
    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
	op = null;
    }

    /**
     * Verify the priority
     */
    @Test
    public void testGetPriority() {
	assertEquals(20, op.getPriority());
    }

    /**
     * This checks basic argument resolution
     */
    @Test
    public void testParseArgs() {
	List<String> tokens = new ArrayList<String>();
	tokens.add("functionName");
	tokens.add("(1, (1 + 2), today)");
	int position = 0;
	List<Argument> args = op.parseArgs(tokens, position);
	assertEquals(args.get(0), new Argument(new Integer(1), null));
	assertEquals(args.get(1), new Argument("(1 + 2)", null));
	assertEquals(args.get(2), new Argument("today", null));
    }
}
