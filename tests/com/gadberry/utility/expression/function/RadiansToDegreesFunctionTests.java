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

public class RadiansToDegreesFunctionTests {

	private RadiansToDegreesFunction op = null;

	@Before
	public void setUp() throws Exception {
		op = new RadiansToDegreesFunction();
	}

	@After
	public void tearDown() throws Exception {
		op = null;
	}

	/**
	 * This check one argument. Should not throw an exception.
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
	 * This check standard arguments. Should throw an exception.
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
	 * This checks three arguments. Should throw an exception.
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
	 * This checks basic radians to degrees
	 * 
	 * Test: deg( 0 )
	 */
	@Test
	public void testResolve1() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Integer(1), null));
		try {
			op.setArguments(args);
			assertEquals(op.resolve().toDouble(), Math.toDegrees(1), FuzzyEquals.TOLERANCE);
		} catch (InvalidArgumentsException e) {
			e.printStackTrace();
			fail();
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * This checks a negetive deg
	 * 
	 * Test: deg( -180 )
	 */
	@Test
	public void testResolve2() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Double(-1), null));
		try {
			op.setArguments(args);
			assertEquals(op.resolve().toDouble(), Math.toDegrees(-1), FuzzyEquals.TOLERANCE);
		} catch (InvalidArgumentsException e) {
			e.printStackTrace();
			fail();
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}
	}
}