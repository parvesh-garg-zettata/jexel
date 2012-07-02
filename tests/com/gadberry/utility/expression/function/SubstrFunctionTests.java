package com.gadberry.utility.expression.function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.ArgumentCastException;
import com.gadberry.utility.expression.InvalidArgumentsException;

/**
 * @author Aaron Gadberry
 * 
 */
public class SubstrFunctionTests {

    private SubstrFunction op = null;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
	op = new SubstrFunction(null);
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
     * Argument 1: abcd
     * 
     * Argument 2: 1
     */
    @Test
    public void testCheckArgs1() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abcd", null));
	args.add(new Argument(new Integer(1), null));
	try {
	    op.setArguments(args);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This check a non-integer second argument. Should throw an exception.
     * 
     * Argument 1: abcd
     * 
     * Argument 2: a
     */
    @Test
    public void testCheckArgs2() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abcd", null));
	args.add(new Argument("a", null));
	try {
	    op.setArguments(args);
	    fail();
	} catch (InvalidArgumentsException e) {
	}
    }

    /**
     * This check a negative second argument. Should throw an exception.
     * 
     * Argument 1: abcd
     * 
     * Argument 2: -1
     */
    @Test
    public void testCheckArgs3() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abcd", null));
	args.add(new Argument(new Integer(-1), null));
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
     * Argument 1: abcd
     * 
     * Argument 2: 1
     * 
     * Argument 3: 1
     */
    @Test
    public void testCheckArgs4() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abcd", null));
	args.add(new Argument(new Integer(1), null));
	args.add(new Argument(new Integer(1), null));
	try {
	    op.setArguments(args);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks two string arguments. Should throw an exception for a
     * non-integer second argument.
     * 
     * Argument 1: abcd
     * 
     * Argument 2: abcd
     * 
     * Argument 3: 1
     */
    @Test
    public void testCheckArgs5() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abcd", null));
	args.add(new Argument("abcd", null));
	args.add(new Argument(new Integer(1), null));
	try {
	    op.setArguments(args);
	    fail();
	} catch (InvalidArgumentsException e) {
	}
    }

    /**
     * Should throw an exception for a non-integer third argument.
     * 
     * Argument 1: abcd
     * 
     * Argument 2: 1
     * 
     * Argument 3: abcd
     */
    @Test
    public void testCheckArgs6() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abcd", null));
	args.add(new Argument(new Integer(1), null));
	args.add(new Argument("abcd", null));
	try {
	    op.setArguments(args);
	    fail();
	} catch (InvalidArgumentsException e) {
	}
    }

    /**
     * Should throw an exception for a negetive integer third argument.
     * 
     * Argument 1: abcd
     * 
     * Argument 2: 1
     * 
     * Argument 3: -1
     */
    @Test
    public void testCheckArgs7() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abcd", null));
	args.add(new Argument(new Integer(1), null));
	args.add(new Argument(new Integer(-1), null));
	try {
	    op.setArguments(args);
	    fail();
	} catch (InvalidArgumentsException e) {
	}
    }

    /**
     * Should throw an exception for a second argument larger than a third
     * argument.
     * 
     * Argument 1: abcd
     * 
     * Argument 2: 2
     * 
     * Argument 3: 1
     */
    @Test
    public void testCheckArgs8() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abcd", null));
	args.add(new Argument(new Integer(2), null));
	args.add(new Argument(new Integer(1), null));
	try {
	    op.setArguments(args);
	    fail();
	} catch (InvalidArgumentsException e) {
	}
    }

    /**
     * This check one argument. Should throw an exception for no second
     * argument.
     * 
     * Argument 1: abcd
     */
    @Test
    public void testCheckArgs9() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abcd", null));
	try {
	    op.setArguments(args);
	    fail();
	} catch (InvalidArgumentsException e) {
	}
    }

    /**
     * This checks basic substr
     * 
     * Test: substr( abcd, 2 )
     */
    @Test
    public void testResolve1() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abcd", null));
	args.add(new Argument(new Integer(2), null));
	try {
	    op.setArguments(args);
	    assertEquals("cd", op.resolve().toString());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks substr with argument of 0
     * 
     * Test: substr( abcd, 0 )
     */
    @Test
    public void testResolve2() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abcd", null));
	args.add(new Argument(new Integer(0), null));
	try {
	    op.setArguments(args);
	    assertEquals("abcd", op.resolve().toString());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks substr with two arguments of 0
     * 
     * Test: substr( abcd, 0, 0 )
     */
    @Test
    public void testResolve3() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abcd", null));
	args.add(new Argument(new Integer(0), null));
	args.add(new Argument(new Integer(0), null));
	try {
	    op.setArguments(args);
	    assertEquals("", op.resolve().toString());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }
}
