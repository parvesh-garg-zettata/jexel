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
public class MultiplicationSymbolTests {

    private MultiplicationSymbol op = null;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
	op = new MultiplicationSymbol(null);
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
     * This checks non-double arguments. Should throw an exception for a
     * non-double argument.
     * 
     * Argument 1: 1
     * 
     * Argument 2: abc
     */
    @Test
    public void testCheckArgs4() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(1), null));
	args.add(new Argument("abc", null));
	try {
	    op.setArguments(args);
	    fail();
	} catch (InvalidArgumentsException e) {
	}
    }

    /**
     * This checks non-double arguments. Should throw an exception for a
     * non-double argument.
     * 
     * Same as the previous test but the arguments are in reverse order.
     * 
     * Argument 1: abc
     * 
     * Argument 2: 1
     */
    @Test
    public void testCheckArgs5() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abc", null));
	args.add(new Argument(new Double(1), null));
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
	assertEquals(10, op.getPriority());
    }

    /**
     * This checks basic multiplication
     * 
     * Test: 8 * 4
     */
    @Test
    public void testResolve1() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Integer(8), null));
	args.add(new Argument(new Integer(4), null));
	try {
	    op.setArguments(args);
	    assertEquals(32d, op.resolve().toDouble(), FuzzyEquals.TOLERANCE);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks floating point multiplication with one floating point
     * 
     * Test: 6 * 2.5
     */
    @Test
    public void testResolve3() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(6), null));
	args.add(new Argument(new Float(2.5), null));
	try {
	    op.setArguments(args);
	    assertEquals(15d, op.resolve().toDouble(), FuzzyEquals.TOLERANCE);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks floating point division with one floating point
     * 
     * Test: 2.5 * 6
     */
    @Test
    public void testResolve4() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(2.5), null));
	args.add(new Argument(new Float(6), null));
	try {
	    op.setArguments(args);
	    assertEquals(15d, op.resolve().toDouble(), FuzzyEquals.TOLERANCE);
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
     * Test: 1100 * 0.25
     */
    @Test
    public void testResolve5() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(1100), null));
	args.add(new Argument(new Float(0.25), null));
	try {
	    op.setArguments(args);
	    assertEquals(275d, op.resolve().toDouble(), FuzzyEquals.TOLERANCE);
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
     * Test: 0.15 * -0.11
     */
    @Test
    public void testResolve6() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(0.15), null));
	args.add(new Argument(new Float(-0.11), null));
	try {
	    op.setArguments(args);
	    assertEquals(-0.0165d, op.resolve().toDouble(),
		    FuzzyEquals.TOLERANCE);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }
}
