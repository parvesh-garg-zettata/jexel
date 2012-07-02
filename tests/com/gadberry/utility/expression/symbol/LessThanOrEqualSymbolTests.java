package com.gadberry.utility.expression.symbol;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class LessThanOrEqualSymbolTests {

    private LessThanOrEqualSymbol op = null;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
	op = new LessThanOrEqualSymbol(null);
    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
	op = null;
    }

    /**
     * This check standard double arguments. Should not throw an exception.
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
     * This check standard date arguments. Should not throw an exception.
     * 
     * Argument 1: now
     * 
     * Argument 2: now
     */
    @Test
    public void testCheckArgs2() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Date(), null));
	args.add(new Argument(new Date(), null));
	try {
	    op.setArguments(args);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This check standard string arguments. Should not throw an exception.
     * 
     * Argument 1: "aaaa"
     * 
     * Argument 2: "bbbb"
     */
    @Test
    public void testCheckArgs3() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("aaaa", null));
	args.add(new Argument("bbbb", null));
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
    public void testCheckArgs4() {
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
    public void testCheckArgs5() {
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
	assertEquals(5, op.getPriority());
    }

    /**
     * This checks false date comparison
     * 
     * Test: 1/1/2007 <= 1/1/2006
     */
    @Test
    public void testResolveDate1() {
	List<Argument> args = new ArrayList<Argument>();

	Calendar c1 = Calendar.getInstance();
	c1.set(Calendar.YEAR, 2007);
	c1.set(Calendar.MONTH, 0);
	c1.set(Calendar.DAY_OF_MONTH, 1);
	c1.set(Calendar.HOUR_OF_DAY, 0);
	c1.set(Calendar.MINUTE, 0);
	c1.set(Calendar.SECOND, 0);
	c1.set(Calendar.MILLISECOND, 0);

	Calendar c2 = Calendar.getInstance();
	c2.set(Calendar.YEAR, 2006);
	c2.set(Calendar.MONTH, 0);
	c2.set(Calendar.DAY_OF_MONTH, 1);
	c2.set(Calendar.HOUR_OF_DAY, 0);
	c2.set(Calendar.MINUTE, 0);
	c2.set(Calendar.SECOND, 0);
	c2.set(Calendar.MILLISECOND, 0);

	args.add(new Argument(c1, null));
	args.add(new Argument(c2, null));
	try {
	    op.setArguments(args);
	    assertFalse(op.resolve().toBoolean());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks true date comparison
     * 
     * Test: 1/1/2006 <= 1/1/2007
     */
    @Test
    public void testResolveDate2() {
	List<Argument> args = new ArrayList<Argument>();

	Calendar c1 = Calendar.getInstance();
	c1.set(Calendar.YEAR, 2006);
	c1.set(Calendar.MONTH, 0);
	c1.set(Calendar.DAY_OF_MONTH, 1);
	c1.set(Calendar.HOUR_OF_DAY, 0);
	c1.set(Calendar.MINUTE, 0);
	c1.set(Calendar.SECOND, 0);
	c1.set(Calendar.MILLISECOND, 0);

	Calendar c2 = Calendar.getInstance();
	c2.set(Calendar.YEAR, 2007);
	c2.set(Calendar.MONTH, 0);
	c2.set(Calendar.DAY_OF_MONTH, 1);
	c2.set(Calendar.HOUR_OF_DAY, 0);
	c2.set(Calendar.MINUTE, 0);
	c2.set(Calendar.SECOND, 0);
	c2.set(Calendar.MILLISECOND, 0);

	args.add(new Argument(c1, null));
	args.add(new Argument(c2, null));
	try {
	    op.setArguments(args);
	    assertTrue(op.resolve().toBoolean());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks true date comparison
     * 
     * Test: 1/1/2006 <= 1/1/2006
     */
    @Test
    public void testResolveDate3() {
	List<Argument> args = new ArrayList<Argument>();

	Calendar c1 = Calendar.getInstance();
	c1.set(Calendar.YEAR, 2006);
	c1.set(Calendar.MONTH, 0);
	c1.set(Calendar.DAY_OF_MONTH, 1);
	c1.set(Calendar.HOUR_OF_DAY, 0);
	c1.set(Calendar.MINUTE, 0);
	c1.set(Calendar.SECOND, 0);
	c1.set(Calendar.MILLISECOND, 0);

	Calendar c2 = Calendar.getInstance();
	c2.set(Calendar.YEAR, 2006);
	c2.set(Calendar.MONTH, 0);
	c2.set(Calendar.DAY_OF_MONTH, 1);
	c2.set(Calendar.HOUR_OF_DAY, 0);
	c2.set(Calendar.MINUTE, 0);
	c2.set(Calendar.SECOND, 0);
	c2.set(Calendar.MILLISECOND, 0);

	args.add(new Argument(c1, null));
	args.add(new Argument(c2, null));
	try {
	    op.setArguments(args);
	    assertTrue(op.resolve().toBoolean());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks false double comparison
     * 
     * Test: 1 <= 0
     */
    @Test
    public void testResolveDouble1() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Integer(1), null));
	args.add(new Argument(new Integer(0), null));
	try {
	    op.setArguments(args);
	    assertFalse(op.resolve().toBoolean());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks true double comparison
     * 
     * Test: 0 <= 1
     */
    @Test
    public void testResolveDouble2() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Float(0), null));
	args.add(new Argument(new Double(1), null));
	try {
	    op.setArguments(args);
	    assertTrue(op.resolve().toBoolean());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks true double comparison
     * 
     * Test: 1 <= 1
     */
    @Test
    public void testResolveDouble3() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Double(1), null));
	args.add(new Argument(new Float(1), null));
	try {
	    op.setArguments(args);
	    assertTrue(op.resolve().toBoolean());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks false string comparison
     * 
     * Test: "b" <= "a"
     */
    @Test
    public void testResolveString1() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("b", null));
	args.add(new Argument("a", null));
	try {
	    op.setArguments(args);
	    assertFalse(op.resolve().toBoolean());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks true string comparison
     * 
     * Test: "a" <= "b"
     */
    @Test
    public void testResolveString2() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("a", null));
	args.add(new Argument("b", null));
	try {
	    op.setArguments(args);
	    assertTrue(op.resolve().toBoolean());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks true string comparison
     * 
     * Test: "a" <= "a"
     */
    @Test
    public void testResolveString3() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("a", null));
	args.add(new Argument("a", null));
	try {
	    op.setArguments(args);
	    assertTrue(op.resolve().toBoolean());
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }
}
