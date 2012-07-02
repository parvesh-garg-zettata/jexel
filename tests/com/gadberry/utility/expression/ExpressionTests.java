package com.gadberry.utility.expression;

import org.junit.Test;

import com.gadberry.utility.expression.symbol.AdditionSymbol;
import com.gadberry.utility.expression.symbol.SubtractionSymbol;

import junit.framework.TestCase;

/**
 * @author Aaron Gadberry
 * 
 */
public class ExpressionTests extends TestCase {

    /**
	 * 
	 */
    @Test
    public void testConstructor() {
	try {
	    assertEquals(
		    new Expression("max( ( 1 + 2 ), 2 + 3 ) + 1").evaluate(),
		    new Argument(new Double(6), null));
	} catch (InvalidExpressionException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
	 * 
	 */
    @Test
    public void testEvaluate() {
	try {
	    assertEquals(
		    new Expression("max( ( 1 + 2 ), 2 + 3 ) + 1").evaluate(),
		    new Argument(new Double(6), null));
	} catch (InvalidExpressionException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
	 * 
	 */
    @Test
    public void testEvaluateExpressionWithInvalidArguments() {
	try {
	    assertEquals(new Argument("max( 1, a, 2 )", null),
		    Expression.evaluate("max( 1, a, 2 )"));
	} catch (InvalidExpressionException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
	 * 
	 */
    @Test
    public void testEvaluateInvalidExpression() {
	try {
	    assertEquals(new Argument(new Double(5), null),
		    Expression.evaluate("max( ( 1 + 2 , 2 + 3 )"));
	    fail();
	} catch (InvalidExpressionException e) {
	}
    }

    /**
	 * 
	 */
    @Test
    public void testEvaluateNonExpression() {
	try {
	    assertEquals(new Argument(new Double(1), null),
		    Expression.evaluate("1"));

	} catch (InvalidExpressionException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
	 * 
	 */
    @Test
    public void testGetOperatorSet() {
	OperatorSet operatorSet = new OperatorSet();
	operatorSet.addOperator("+", AdditionSymbol.class);
	operatorSet.addOperator("-", SubtractionSymbol.class);

	Expression expression = new Expression("'abc + def'");
	expression.setOperatorSet(operatorSet);

	assertEquals(operatorSet, expression.getOperatorSet());
    }

    /**
	 * 
	 */
    @Test
    public void testGetResolver() {
	Resolver resolver = new MockResolver();

	Expression expression = new Expression("'abc + def'");
	expression.setResolver(resolver);

	assertEquals(resolver, expression.getResolver());
    }

    /**
	 * 
	 */
    @Test
    public void testLiterals() {
	try {
	    assertEquals("abc + def", Expression.evaluate("'abc + def'")
		    .toString());
	    assertEquals("a +bc", Expression.evaluate("'a +b' + c").toString());
	    assertEquals("1+ 23", Expression.evaluate("'1+ 2' + 3").toString());
	    assertEquals("+", Expression.evaluate("substr('1 + 3', 2, 3)")
		    .toString());
	    assertEquals(", 3", Expression.evaluate("substr('1 , 3', 2, 5)")
		    .toString());
	    assertEquals("a'bcd", Expression.evaluate("a''bc + d").toString());
	    assertEquals("bcdef", Expression.evaluate("substr('abc'+'def',1)")
		    .toString());
	    assertTrue(Expression.evaluate("'abc'==abc").toBoolean());
	} catch (InvalidExpressionException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
	 * 
	 */
    @Test
    public void testParenthesees() {
	try {
	    assertEquals(5d, Expression.evaluate("max( ( 1 + 2 ), 2 + 3 )")
		    .toDouble(), 0d);
	    assertEquals(2d, Expression.evaluate("min(max(1,2),2 + 3)")
		    .toDouble(), 0d);
	    assertEquals(10d, Expression.evaluate("2 * ( 2 + 3 )").toDouble(),
		    0d);
	    assertEquals(10d, Expression.evaluate("( 1 + 1 ) * ( 2 + 3 )")
		    .toDouble(), 0d);
	    assertEquals(7d, Expression.evaluate("( 1 * 5 ) + ( 6 / 3 )")
		    .toDouble(), 0d);
	    assertEquals(5d, Expression.evaluate("1 + 2 * 6 / 3").toDouble(),
		    0d);
	    assertEquals(6, Expression.evaluate("( 1 + 2) * 6 / 3").toDouble(),
		    0d);
	} catch (InvalidExpressionException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
	 * 
	 */
    @Test
    public void testPriorities() {
	try {
	    assertTrue(Expression.evaluate("2 > 1 AND 1 < 2 OR 1 <= 0")
		    .toBoolean());
	    assertTrue(Expression.evaluate("2 >= 1 || 3 <= 2").toBoolean());
	    assertTrue(Expression.evaluate("5 * 5 >= 2 + 2 - 1").toBoolean());
	    assertTrue(Expression.evaluate("5 + 2 == 2 + 5").toBoolean());
	    assertTrue(Expression.evaluate("1 == 1 AND 2 == 2").toBoolean());
	} catch (InvalidExpressionException e) {
	    e.printStackTrace();
	    fail();
	} catch (ArgumentCastException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
	 * 
	 */
    @Test
    public void testSetOperatorSet() {
	OperatorSet operatorSet = new OperatorSet();
	operatorSet.addOperator("+", AdditionSymbol.class);
	operatorSet.addOperator("-", SubtractionSymbol.class);

	Expression expression = new Expression("'abc + def'");
	expression.setOperatorSet(operatorSet);

	assertEquals(operatorSet, expression.getOperatorSet());
    }

    /**
	 * 
	 */
    @Test
    public void testSetResolver() {
	Resolver resolver = new MockResolver();

	Expression expression = new Expression("'abc + def'");
	expression.setResolver(resolver);

	assertEquals(resolver, expression.getResolver());
    }

    /**
	 * 
	 */
    @Test
    public void testStaticEvaluate() {
	try {
	    assertEquals(new Argument(new Double(6), null),
		    Expression.evaluate("max( ( 1 + 2 ), 2 + 3 ) + 1"));
	} catch (InvalidExpressionException e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /**
	 * 
	 */
    /*
     * @Test public void testStringLiteral() { try { Expression exp = new
     * Expression("$DEST=='57889' AND $MSISDN==919873364511");
     * exp.setResolver(new KeywordResolver("10 11 	12","919873364511","57889"));
     * Argument arg = exp.evaluate(); System.out.println(arg.toString()); }
     * catch (InvalidExpressionException e) { e.printStackTrace(); fail(); } }
     */
}