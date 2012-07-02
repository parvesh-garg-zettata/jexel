package com.gadberry.utility.expression.symbol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gadberry.utility.FuzzyEquals;
import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.ArgumentCastException;
import com.gadberry.utility.expression.InvalidArgumentsException;

/**
 * @author Aaron Gadberry
 * 
 */
public class AdditionSymbolTests {

    private AdditionSymbol op;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
	op = new AdditionSymbol(null);
    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
	op = null;
    }

    /**
     * This check standard arguments. Should not throw an exception.
     * 
     * Argument 1: 1
     * 
     * Argument 2: 1
     */
    @Test
    public void testCheckArgs1() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(1), null));
	args.add(new Argument(new Float(1), null));
	try {
	    op.setArguments(args);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This check one argument. Should throw an exception for no second
     * argument.
     * 
     * Argument 1: 1
     */
    @Test
    public void testCheckArgs2() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(1), null));
	try {
	    op.setArguments(args);
	    fail();
	} catch (InvalidArgumentsException e) {
	}
    }

    /**
     * This checks three arguments. Should throw an exception for a third
     * argument.
     * 
     * Argument 1: 1
     * 
     * Argument 2: 1
     * 
     * Argument 3: 1
     */
    @Test
    public void testCheckArgs3() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(1), null));
	args.add(new Argument(new Float(1), null));
	args.add(new Argument(new Integer(1), null));
	try {
	    op.setArguments(args);
	    fail();
	} catch (InvalidArgumentsException e) {
	}
    }

    /**
     * Verify the priority
     */
    @Test
    public void testGetPriority() {
	assertEquals(6, op.getPriority());
    }

    /**
     * This checks basic double addition
     * 
     * Test: 1 + 2
     */
    @Test
    public void testResolveDouble1() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Integer(1), null));
	args.add(new Argument(new Integer(2), null));
	try {
	    op.setArguments(args);
	    assertEquals(3d, op.resolve().toDouble(), FuzzyEquals.TOLERANCE);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks floating point addition
     * 
     * Test: 1.11 + 2.22
     */
    @Test
    public void testResolveDouble2() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(1.11), null));
	args.add(new Argument(new Float(2.22), null));
	try {
	    op.setArguments(args);
	    assertEquals(3.33d, op.resolve().toDouble(), FuzzyEquals.TOLERANCE);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks floating point addition with one floating point
     * 
     * Test: 1001 + 2.22
     */
    @Test
    public void testResolveDouble3() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(1001), null));
	args.add(new Argument(new Float(2.22), null));
	try {
	    op.setArguments(args);
	    assertEquals(1003.22d, op.resolve().toDouble(),
		    FuzzyEquals.TOLERANCE);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks a large number and a number < 1
     * 
     * Test: 1111 + 0.11
     */
    @Test
    public void testResolveDouble4() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(1111), null));
	args.add(new Argument(new Float(0.11), null));
	try {
	    op.setArguments(args);
	    assertEquals(1111.11, op.resolve().toDouble(),
		    FuzzyEquals.TOLERANCE);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks a positive small number and a negetive small number
     * 
     * Test: 0.15 + -0.11
     */
    @Test
    public void testResolveDouble5() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(0.15), null));
	args.add(new Argument(new Float(-0.11), null));
	try {
	    op.setArguments(args);
	    assertEquals(0.04, op.resolve().toDouble(), FuzzyEquals.TOLERANCE);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks basic string addition
     * 
     * Test: abc + def
     */
    @Test
    public void testResolveString1() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abc", null));
	args.add(new Argument("def", null));
	try {
	    op.setArguments(args);
	    assertEquals("abcdef", op.resolve().toString());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks basic string addition
     * 
     * Test: abc + 1.0
     */
    @Test
    public void testResolveString2() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abc", null));
	args.add(new Argument(new Double(1), null));
	try {
	    op.setArguments(args);
	    assertEquals("abc1.0", op.resolve().toString());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	}
    }
}
