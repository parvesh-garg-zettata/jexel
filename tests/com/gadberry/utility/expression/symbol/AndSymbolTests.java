package com.gadberry.utility.expression.symbol;

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
public class AndSymbolTests {

	private AndSymbol op = null;

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		op = new AndSymbol(null);
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
	 * Argument 1: boolean
	 * 
	 * Argument 2: boolean
	 */
	@Test
	public void testCheckArgs1() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Boolean(true), null));
		args.add(new Argument(new Boolean(false), null));
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
	 * Argument 1: boolean
	 */
	@Test
	public void testCheckArgs2() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Boolean(false), null));
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
	 * Argument 1: boolean
	 * 
	 * Argument 2: boolean
	 * 
	 * Argument 3: boolean
	 */
	@Test
	public void testCheckArgs3() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Boolean(false), null));
		args.add(new Argument(new Boolean(false), null));
		args.add(new Argument(new Boolean(false), null));
		try {
			op.setArguments(args);
			fail();
		} catch (InvalidArgumentsException e) {
		}
	}

	/**
	 * This checks non-boolean arguments. Should throw an exception for a
	 * non-double argument.
	 * 
	 * Argument 1: boolean
	 * 
	 * Argument 2: abc
	 */
	@Test
	public void testCheckArgs4() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Boolean(false), null));
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
	 * Argument 1: boolean
	 * 
	 * Argument 2: 1
	 */
	@Test
	public void testCheckArgs5() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Boolean(false), null));
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
		assertEquals(op.getPriority(), 4);
	}

	/**
	 * This checks one iteration of basic AND
	 * 
	 * Test: true && true
	 */
	@Test
	public void testResolve1() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Boolean(true), null));
		args.add(new Argument(new Boolean(true), null));
		try {
			op.setArguments(args);
			assertEquals(op.resolve().toBoolean(), true);
		} catch (InvalidArgumentsException e) {
			e.printStackTrace();
			fail();
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * This checks one iteration of basic AND
	 * 
	 * Test: true && false
	 */
	@Test
	public void testResolve2() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Boolean(true), null));
		args.add(new Argument(new Boolean(false), null));
		try {
			op.setArguments(args);
			assertEquals(op.resolve().toBoolean(), false);
		} catch (InvalidArgumentsException e) {
			e.printStackTrace();
			fail();
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * This checks one iteration of basic AND
	 * 
	 * Test: false && true
	 */
	@Test
	public void testResolve3() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Boolean(false), null));
		args.add(new Argument(new Boolean(true), null));
		try {
			op.setArguments(args);
			assertEquals(op.resolve().toBoolean(), false);
		} catch (InvalidArgumentsException e) {
			e.printStackTrace();
			fail();
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * This checks one iteration of basic AND
	 * 
	 * Test: true && true
	 */
	@Test
	public void testResolve4() {
		List<Argument> args = new ArrayList<Argument>();
		args.add(new Argument(new Boolean(false), null));
		args.add(new Argument(new Boolean(false), null));
		try {
			op.setArguments(args);
			assertEquals(op.resolve().toBoolean(), false);
		} catch (InvalidArgumentsException e) {
			e.printStackTrace();
			fail();
		} catch (ArgumentCastException e) {
			e.printStackTrace();
			fail();
		}
	}
}
