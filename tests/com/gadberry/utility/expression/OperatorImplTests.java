package com.gadberry.utility.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Aaron Gadberry
 * 
 */
public class OperatorImplTests {

    /**
	 * 
	 */
    public static double TOLERANCE = .0001;

    private Operator op = null;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
	op = new MockOperator(null);
    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
	op = null;
    }

    /**
     * Testing getArgument(int) and argument resolution
     * 
     */
    @Test
    public void testGetArgument() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("1 + 1", null));
	args.add(new Argument(new Integer(2), null));
	try {
	    op.setArguments(args);
	    assertEquals(new Argument(new Double(2), null), op.getArgument(0));
	    assertEquals(new Argument(new Double(2), null), op.getArgument(1));
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * Testing getArguments()
     * 
     */
    @Test
    public void testGetArguments() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("4", null));
	args.add(new Argument(new Integer(2), null));
	try {
	    op.setArguments(args);
	    assertEquals(args, op.getArguments());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * Testing set / get arguments
     * 
     */
    @Test
    public void testSetArguments() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Integer(1), null));
	args.add(new Argument(new Integer(2), null));
	try {
	    op.setArguments(args);
	    assertEquals(args, op.getArguments());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	}
    }
}
