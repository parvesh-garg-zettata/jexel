package com.gadberry.utility.expression.function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gadberry.utility.CalendarUtils;
import com.gadberry.utility.FuzzyEquals;
import com.gadberry.utility.CalendarUtils.Unit;
import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.ArgumentCastException;
import com.gadberry.utility.expression.InvalidArgumentsException;

/**
 * @author Aaron Gadberry
 * 
 */
public class DateDifferenceFunctionTests {

    private DateDifferenceFunction op = null;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
	op = new DateDifferenceFunction(null);
    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
	op = null;
    }

    /**
     * This checks standard calendar arguments. Should not throw an exception.
     * 
     * Argument 1: Calendar
     * 
     * Argument 2: Calendar
     * 
     * Argument 3: Unit.YEAR
     */
    @Test
    public void testCheckArgs1() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(Calendar.getInstance(), null));
	args.add(new Argument(Calendar.getInstance(), null));
	args.add(new Argument(Unit.YEAR, null));
	try {
	    op.setArguments(args);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks standard date arguments. Should not throw an exception.
     * 
     * Argument 1: Date
     * 
     * Argument 2: Date
     * 
     * Argument 3: Unit.YEAR
     */
    @Test
    public void testCheckArgs2() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(new Date(), null));
	args.add(new Argument(new Date(), null));
	args.add(new Argument(Unit.YEAR, null));
	try {
	    op.setArguments(args);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks a mix of a calendar and date arguments. Should not throw an
     * exception.
     * 
     * Argument 1: Date
     * 
     * Argument 2: Date
     * 
     * Argument 3: Unit.YEAR
     */
    @Test
    public void testCheckArgs3() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(Calendar.getInstance(), null));
	args.add(new Argument(new Date(), null));
	args.add(new Argument(Unit.YEAR, null));
	try {
	    op.setArguments(args);
	} catch (InvalidArgumentsException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
     * This checks an invalid unit argument. Should throw an exception.
     * 
     * Argument 1: Calendar
     * 
     * Argument 2: Calendar
     * 
     * Argument 3: "DAYS"
     */
    @Test
    public void testCheckArgs4() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(Calendar.getInstance(), null));
	args.add(new Argument(Calendar.getInstance(), null));
	args.add(new Argument("DAYS", null));
	try {
	    op.setArguments(args);
	    fail();
	} catch (InvalidArgumentsException e) {
	}
    }

    /**
     * This checks an invalid string argument. Should throw an exception.
     * 
     * Argument 1: String
     * 
     * Argument 2: Date
     * 
     * Argument 3: Unit.YEAR
     */
    @Test
    public void testCheckArgs5() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abcd", null));
	args.add(new Argument(Calendar.getInstance(), null));
	args.add(new Argument(Unit.YEAR, null));
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
    public void testCheckArgs6() {
	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument("abcd", null));
	try {
	    op.setArguments(args);
	    fail();
	} catch (InvalidArgumentsException e) {
	}
    }

    /**
     * This checks basic date difference
     * 
     * Test: dateDifference( c1, c2, month )
     */
    @Test
    public void testResolve1() {
	Calendar c1 = Calendar.getInstance();
	c1.set(Calendar.YEAR, 2000);
	c1.set(Calendar.MONTH, 0);
	c1.set(Calendar.DAY_OF_MONTH, 1);
	c1.set(Calendar.HOUR_OF_DAY, 0);
	c1.set(Calendar.MINUTE, 0);
	c1.set(Calendar.SECOND, 0);
	c1.set(Calendar.MILLISECOND, 0);

	Calendar c2 = Calendar.getInstance();
	c2.set(Calendar.YEAR, 2001);
	c2.set(Calendar.MONTH, 0);
	c2.set(Calendar.DAY_OF_MONTH, 31);
	c2.set(Calendar.HOUR_OF_DAY, 0);
	c2.set(Calendar.MINUTE, 0);
	c2.set(Calendar.SECOND, 0);
	c2.set(Calendar.MILLISECOND, 0);

	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(c1, null));
	args.add(new Argument(c2, null));
	args.add(new Argument(Unit.MONTH, null));
	try {
	    op.setArguments(args);
	    assertEquals(CalendarUtils.difference(c1, c2, Unit.MONTH), op
		    .resolve().toDouble(),

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
     * This checks large date difference
     * 
     * Test: dateDifference( c1, c2, millisecond )
     */
    @Test
    public void testResolve2() {
	Calendar c1 = Calendar.getInstance();
	c1.set(Calendar.YEAR, 2000);
	c1.set(Calendar.MONTH, 0);
	c1.set(Calendar.DAY_OF_MONTH, 1);
	c1.set(Calendar.HOUR_OF_DAY, 0);
	c1.set(Calendar.MINUTE, 0);
	c1.set(Calendar.SECOND, 0);
	c1.set(Calendar.MILLISECOND, 0);

	Calendar c2 = Calendar.getInstance();
	c2.set(Calendar.YEAR, 2001);
	c2.set(Calendar.MONTH, 0);
	c2.set(Calendar.DAY_OF_MONTH, 1);
	c2.set(Calendar.HOUR_OF_DAY, 0);
	c2.set(Calendar.MINUTE, 0);
	c2.set(Calendar.SECOND, 0);
	c2.set(Calendar.MILLISECOND, 0);

	List<Argument> args = new ArrayList<Argument>();
	args.add(new Argument(c1, null));
	args.add(new Argument(c2, null));
	args.add(new Argument(Unit.MILLISECOND, null));
	try {
	    op.setArguments(args);
	    assertEquals(CalendarUtils.difference(c1, c2, Unit.MILLISECOND), op
		    .resolve().toDouble(),

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
