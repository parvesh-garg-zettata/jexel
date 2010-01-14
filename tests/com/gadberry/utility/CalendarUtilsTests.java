package com.gadberry.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.gadberry.utility.CalendarUtils.Unit;

/**
 * @author Aaron Gadberry
 *
 */
public class CalendarUtilsTests {

	/**
	 * 
	 */
	@Test
	public void testAdd() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 0);

		long increment = Integer.MAX_VALUE * 5l + 123456;

		c1.add(Calendar.MILLISECOND, Integer.MAX_VALUE);
		c1.add(Calendar.MILLISECOND, Integer.MAX_VALUE);
		c1.add(Calendar.MILLISECOND, Integer.MAX_VALUE);
		c1.add(Calendar.MILLISECOND, Integer.MAX_VALUE);
		c1.add(Calendar.MILLISECOND, Integer.MAX_VALUE);
		c1.add(Calendar.MILLISECOND, 123456);

		CalendarUtils.add(c2, Calendar.MILLISECOND, increment);

		assertEquals(c1, c2);
	}

	/**
	 * Test the constructor. This is just for coverage
	 */
	@Test
	public void testConstructor() {
		new CalendarUtils();
	}

	/**
	 * Test for exactly one unit difference between two calendars
	 */
	@Test
	public void testDifferenceDay1() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 2);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 0);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.DAY), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.DAY), 1);
	}

	/**
	 * Test for one millisecond short of exactly one unit difference between two
	 * calendars
	 */
	@Test
	public void testDifferenceDay2() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 23);
		c2.set(Calendar.MINUTE, 59);
		c2.set(Calendar.SECOND, 59);
		c2.set(Calendar.MILLISECOND, 999);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.DAY), 0);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.DAY), 0);

		c2.add(Calendar.MILLISECOND, 1);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.DAY), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.DAY), 1);
	}

	/**
	 * Test for exactly one unit difference between two calendars
	 */
	@Test
	public void testDifferenceHour1() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 1);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 0);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.HOUR), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.HOUR), 1);
	}

	/**
	 * Test for one millisecond short of exactly one unit difference between two
	 * calendars
	 */
	@Test
	public void testDifferenceHour2() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 59);
		c2.set(Calendar.SECOND, 59);
		c2.set(Calendar.MILLISECOND, 999);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.HOUR), 0);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.HOUR), 0);

		c2.add(Calendar.MILLISECOND, 1);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.HOUR), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.HOUR), 1);
	}

	/**
	 * Test for exactly one unit difference between two calendars
	 */
	@Test
	public void testDifferenceMillisecond1() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 1);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.MILLISECOND), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.MILLISECOND), 1);
	}

	/**
	 * Test for one millisecond short of exactly one unit difference between two
	 * calendars
	 */
	@Test
	public void testDifferenceMillisecond2() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 0);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.MILLISECOND), 0);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.MILLISECOND), 0);

		c2.add(Calendar.MILLISECOND, 1);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.MILLISECOND), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.MILLISECOND), 1);
	}

	/**
	 * Test for exactly one unit difference between two calendars
	 */
	@Test
	public void testDifferenceMinute1() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 1);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 0);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.MINUTE), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.MINUTE), 1);
	}

	/**
	 * Test for one millisecond short of exactly one unit difference between two
	 * calendars
	 */
	@Test
	public void testDifferenceMinute2() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 59);
		c2.set(Calendar.MILLISECOND, 999);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.MINUTE), 0);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.MINUTE), 0);

		c2.add(Calendar.MILLISECOND, 1);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.MINUTE), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.MINUTE), 1);
	}

	/**
	 * Test for exactly one unit difference between two calendars
	 */
	@Test
	public void testDifferenceMonth1() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 1);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 0);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.MONTH), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.MONTH), 1);
	}

	/**
	 * Test for one millisecond short of exactly one unit difference between two
	 * calendars
	 */
	@Test
	public void testDifferenceMonth2() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 31);
		c2.set(Calendar.HOUR_OF_DAY, 23);
		c2.set(Calendar.MINUTE, 59);
		c2.set(Calendar.SECOND, 59);
		c2.set(Calendar.MILLISECOND, 999);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.MONTH), 0);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.MONTH), 0);

		c2.add(Calendar.MILLISECOND, 1);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.MONTH), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.MONTH), 1);
	}

	/**
	 * Test for the month of February
	 */
	@Test
	public void testDifferenceMonth3() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 1);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 1);
		c2.set(Calendar.DAY_OF_MONTH, 29);
		c2.set(Calendar.HOUR_OF_DAY, 23);
		c2.set(Calendar.MINUTE, 59);
		c2.set(Calendar.SECOND, 59);
		c2.set(Calendar.MILLISECOND, 999);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.MONTH), 0);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.MONTH), 0);

		c2.add(Calendar.MILLISECOND, 1);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.MONTH), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.MONTH), 1);
	}

	/**
	 * Test for exactly one unit difference between two calendars
	 */
	@Test
	public void testDifferenceSecond1() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 1);
		c2.set(Calendar.MILLISECOND, 0);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.SECOND), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.SECOND), 1);
	}

	/**
	 * Test for one millisecond short of exactly one unit difference between two
	 * calendars
	 */
	@Test
	public void testDifferenceSecond2() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 999);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.SECOND), 0);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.SECOND), 0);

		c2.add(Calendar.MILLISECOND, 1);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.SECOND), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.SECOND), 1);
	}

	/**
	 * Test for exactly one unit difference between two calendars
	 */
	@Test
	public void testDifferenceYear1() {
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

		assertEquals(CalendarUtils.difference(c1, c2, Unit.YEAR), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.YEAR), 1);
	}

	/**
	 * Test for one millisecond short of exactly one unit difference between two
	 * calendars
	 */
	@Test
	public void testDifferenceYear2() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 11);
		c2.set(Calendar.DAY_OF_MONTH, 31);
		c2.set(Calendar.HOUR_OF_DAY, 23);
		c2.set(Calendar.MINUTE, 59);
		c2.set(Calendar.SECOND, 59);
		c2.set(Calendar.MILLISECOND, 999);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.YEAR), 0);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.YEAR), 0);

		c2.add(Calendar.MILLISECOND, 1);

		assertEquals(CalendarUtils.difference(c1, c2, Unit.YEAR), 1);
		assertEquals(CalendarUtils.difference(c1.getTime(), c2.getTime(), Unit.YEAR), 1);
	}

	/**
	 * Test for exactly 1.5 unit difference between two calendars
	 */
	@Test
	public void testExactDifferenceMinute1() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 1);
		c2.set(Calendar.SECOND, 30);
		c2.set(Calendar.MILLISECOND, 0);

		assertEquals(CalendarUtils.exactDifference(c1, c2, Unit.MINUTE), 1.5, FuzzyEquals.TOLERANCE);
	}

	/**
	 * Test for exactly 2.55 unit difference between two calendars
	 */
	@Test
	public void testExactDifferenceMinute2() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 2);
		c2.set(Calendar.SECOND, 33);
		c2.set(Calendar.MILLISECOND, 0);

		assertEquals(CalendarUtils.exactDifference(c1, c2, Unit.MINUTE), 2.55, FuzzyEquals.TOLERANCE);
	}

	/**
	 * Test for exactly 1.5 unit difference between two calendars
	 */
	@Test
	public void testExactDifferenceSecond1() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 1);
		c2.set(Calendar.MILLISECOND, 500);

		assertEquals(CalendarUtils.exactDifference(c1, c2, Unit.SECOND), 1.5, FuzzyEquals.TOLERANCE);
	}

	/**
	 * Test for exactly 2.501 unit difference between two calendars
	 */
	@Test
	public void testExactDifferenceSecond2() {
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2000);
		c1.set(Calendar.MONTH, 0);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 2000);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 2);
		c2.set(Calendar.MILLISECOND, 501);

		assertEquals(CalendarUtils.exactDifference(c1, c2, Unit.SECOND), 2.501, FuzzyEquals.TOLERANCE);
	}

	/**
	 * Test for exactly one of each unit difference between two calendars
	 */
	@Test
	public void testTieredDifferenceAll1() {
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
		c2.set(Calendar.MONTH, 1);
		c2.set(Calendar.DAY_OF_MONTH, 2);
		c2.set(Calendar.HOUR_OF_DAY, 1);
		c2.set(Calendar.MINUTE, 1);
		c2.set(Calendar.SECOND, 1);
		c2.set(Calendar.MILLISECOND, 1);

		Map<Unit, Long> differences = CalendarUtils.tieredDifference(c1, c2);

		assertTrue(differences.containsKey(Unit.YEAR));
		assertEquals(differences.get(Unit.YEAR), new Long(1));

		assertTrue(differences.containsKey(Unit.MONTH));
		assertEquals(differences.get(Unit.MONTH), new Long(1));

		assertTrue(differences.containsKey(Unit.DAY));
		assertEquals(differences.get(Unit.DAY), new Long(1));

		assertTrue(differences.containsKey(Unit.HOUR));
		assertEquals(differences.get(Unit.HOUR), new Long(1));

		assertTrue(differences.containsKey(Unit.MINUTE));
		assertEquals(differences.get(Unit.MINUTE), new Long(1));

		assertTrue(differences.containsKey(Unit.SECOND));
		assertEquals(differences.get(Unit.SECOND), new Long(1));

		assertTrue(differences.containsKey(Unit.MILLISECOND));
		assertEquals(differences.get(Unit.MILLISECOND), new Long(1));
	}

	/**
	 * Test for exactly one of each unit difference between two calendars
	 */
	@Test
	public void testTieredDifferenceSome1() {
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
		c2.set(Calendar.MONTH, 1);
		c2.set(Calendar.DAY_OF_MONTH, 2);
		c2.set(Calendar.HOUR_OF_DAY, 1);
		c2.set(Calendar.MINUTE, 1);
		c2.set(Calendar.SECOND, 1);
		c2.set(Calendar.MILLISECOND, 1);

		List<Unit> someUnits = new ArrayList<Unit>();
		someUnits.add(Unit.YEAR);
		someUnits.add(Unit.MONTH);
		someUnits.add(Unit.DAY);
		someUnits.add(Unit.MINUTE);
		someUnits.add(Unit.MILLISECOND);

		Map<Unit, Long> differences = CalendarUtils.tieredDifference(c1, c2, someUnits);

		assertTrue(differences.containsKey(Unit.YEAR));
		assertEquals(differences.get(Unit.YEAR), new Long(1));

		assertTrue(differences.containsKey(Unit.MONTH));
		assertEquals(differences.get(Unit.MONTH), new Long(1));

		assertTrue(differences.containsKey(Unit.DAY));
		assertEquals(differences.get(Unit.DAY), new Long(1));

		assertFalse(differences.containsKey(Unit.HOUR));

		assertTrue(differences.containsKey(Unit.MINUTE));
		assertEquals(differences.get(Unit.MINUTE), new Long(61));

		assertFalse(differences.containsKey(Unit.SECOND));

		assertTrue(differences.containsKey(Unit.MILLISECOND));
		assertEquals(differences.get(Unit.MILLISECOND), new Long(1001));
	}
}
