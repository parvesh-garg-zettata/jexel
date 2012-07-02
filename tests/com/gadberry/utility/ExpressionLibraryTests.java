package com.gadberry.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.gadberry.utility.expression.Expression;
import com.gadberry.utility.expression.InvalidExpressionException;
import com.gadberry.utility.expression.SimpleResolver;

/**
 * @author Aaron Gadberry
 * 
 */
public class ExpressionLibraryTests {

    /**
	 * 
	 */
    @Test
    public void testOperators() {
	try {
	    assertEquals(2d, Expression.evaluate("1 + 1").toDouble(),
		    FuzzyEquals.TOLERANCE);
	    assertEquals(0d, Expression.evaluate("1 - 1").toDouble(),
		    FuzzyEquals.TOLERANCE);
	    assertEquals(2d, Expression.evaluate("1 * 2").toDouble(),
		    FuzzyEquals.TOLERANCE);
	    assertEquals(2d, Expression.evaluate("6 / 3").toDouble(),
		    FuzzyEquals.TOLERANCE);
	    assertEquals(2d, Expression.evaluate("6 % 4").toDouble(),
		    FuzzyEquals.TOLERANCE);

	    assertTrue(Expression.evaluate("true && true").toBoolean());
	    assertFalse(Expression.evaluate("true AND false").toBoolean());
	    assertTrue(Expression.evaluate("true || true").toBoolean());
	    assertTrue(Expression.evaluate("true OR false").toBoolean());
	    assertFalse(Expression.evaluate("not(true)").toBoolean());

	    assertEquals(6d, Expression.evaluate("max(2,3,6)").toDouble(),
		    FuzzyEquals.TOLERANCE);
	    assertEquals(2d, Expression.evaluate("min(2,3,6)").toDouble(),
		    FuzzyEquals.TOLERANCE);
	    assertEquals(2d, Expression.evaluate("floor(2.2)").toDouble(),
		    FuzzyEquals.TOLERANCE);
	    assertEquals(4d, Expression.evaluate("ceil(3.6)").toDouble(),
		    FuzzyEquals.TOLERANCE);
	    assertEquals(-3d, Expression.evaluate("neg(3)").toDouble(),
		    FuzzyEquals.TOLERANCE);
	    assertEquals(3d, Expression.evaluate("abs(neg(3))").toDouble(),
		    FuzzyEquals.TOLERANCE);
	    assertEquals(Math.cos(Math.toRadians(180)),
		    Expression.evaluate("cos(rad(180))").toDouble(),
		    FuzzyEquals.TOLERANCE);
	    assertEquals(Math.sin(Math.toRadians(90)),
		    Expression.evaluate("sin(rad(90))").toDouble(),
		    FuzzyEquals.TOLERANCE);
	    assertEquals(Math.tan(Math.toRadians(45)),
		    Expression.evaluate("tan(rad(45))").toDouble(),
		    FuzzyEquals.TOLERANCE);
	    assertEquals(Math.acos(0), Expression.evaluate("acos(0)")
		    .toDouble(), FuzzyEquals.TOLERANCE);
	    assertEquals(Math.asin(180), Expression.evaluate("asin(180)")
		    .toDouble(), FuzzyEquals.TOLERANCE);
	    assertEquals(Math.atan(1), Expression.evaluate("atan(1)")
		    .toDouble(), FuzzyEquals.TOLERANCE);

	    assertTrue(Expression.evaluate("1 == 1").toBoolean());
	    assertTrue(Expression.evaluate("1 > 0").toBoolean());
	    assertTrue(Expression.evaluate("1 < 2").toBoolean());
	    assertTrue(Expression.evaluate("1 <= 2").toBoolean());

	    assertTrue(Expression.evaluate("1 >= 1").toBoolean());

	    assertEquals("b", Expression.evaluate("substr(abcd,1,2)")
		    .toString());

	    Expression exp = new Expression(
		    "dateDifference(01/01/2006, 01/05/2006, |DAY|)");
	    exp.setResolver(new SimpleResolver());
	    assertEquals(4d, exp.evaluate().toDouble(), FuzzyEquals.TOLERANCE);

	    exp = new Expression("max(1, 2, NULL)");
	    exp.setResolver(new SimpleResolver());
	    assertEquals("max(1, 2, NULL)", exp.evaluate().toString());

	} catch (InvalidExpressionException e) {
	    e.printStackTrace();
	    fail();
	}
    }
}
