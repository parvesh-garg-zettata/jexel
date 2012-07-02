package com.gadberry.utility.expression.function;

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
public class FloorFunctionTests {

    private FloorFunction op = null;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
	op = new FloorFunction(null);
    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
	op = null;
    }

    /**
     * This check one standard argument. Should not throw an exception.
     * 
     * Argument 1: 1
     */
    @Test
    public void testCheckArgs1() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(1), null));
	try {
	    op.setArguments(args);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks two standard arguments. Should throw an exception.
     * 
     * Argument 1: 1
     * 
     * Argument 2: 1
     */
    @Test
    public void testCheckArgs2() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(1), null));
	args.add(new Argument(new Float(1), null));
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
     * Argument 2: abc
     */
    @Test
    public void testCheckArgs4() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abc", null));
	try {
	    op.setArguments(args);
	    fail();
	} catch (InvalidArgumentsException e) {
	}
    }

    /**
     * This checks basic functionality
     * 
     * Test: floor( 1.1 )
     */
    @Test
    public void testResolve1() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(1.1), null));
	try {
	    op.setArguments(args);
	    assertEquals(1d, op.resolve().toDouble(), FuzzyEquals.TOLERANCE);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks whole number operation
     * 
     * Test: floor( 3.0 )
     */
    @Test
    public void testResolve2() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(3.0), null));
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
     * This checks a very small number
     * 
     * Test: floor( 0.001 )
     */
    @Test
    public void testResolve3() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(0.001), null));
	try {
	    op.setArguments(args);
	    assertEquals(0d, op.resolve().toDouble(), FuzzyEquals.TOLERANCE);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks a number close to it's ceil
     * 
     * Test: floor( 1.999 )
     */
    @Test
    public void testResolve4() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(1.999), null));
	try {
	    op.setArguments(args);
	    assertEquals(1d, op.resolve().toDouble(), FuzzyEquals.TOLERANCE);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks a small negetive small number
     * 
     * Test: floor( -0.11 )
     */
    @Test
    public void testResolve5() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Float(-0.11), null));
	try {
	    op.setArguments(args);
	    assertEquals(-1d, op.resolve().toDouble(), FuzzyEquals.TOLERANCE);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }
}
