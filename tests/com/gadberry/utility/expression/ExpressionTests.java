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
			assertEquals(new Expression("max( ( 1 + 2 ), 2 + 3 ) + 1").evaluate(), new Argument(new Double(6), null));
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
			assertEquals(new Expression("max( ( 1 + 2 ), 2 + 3 ) + 1").evaluate(), new Argument(new Double(6), null));
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
			assertEquals(Expression.evaluate("max( 1, a, 2 )"), new Argument("max( 1, a, 2 )", null));
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
			assertEquals(Expression.evaluate("max( ( 1 + 2 , 2 + 3 )"), new Argument(new Double(5), null));
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
			assertEquals(Expression.evaluate("1"), new Argument(new Double(1), null));

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

		assertEquals(expression.getOperatorSet(), operatorSet);
	}

	/**
	 * 
	 */
	@Test
	public void testGetResolver() {
		Resolver resolver = new MockResolver();

		Expression expression = new Expression("'abc + def'");
		expression.setResolver(resolver);

		assertEquals(expression.getResolver(), resolver);
	}

	/**
	 * 
	 */
	@Test
	public void testLiterals() {
		try {
			assertEquals(Expression.evaluate("'abc + def'").toString(), "abc + def");
			assertEquals(Expression.evaluate("'a +b' + c").toString(), "a +bc");
			assertEquals(Expression.evaluate("'1+ 2' + 3").toString(), "1+ 23");
			assertEquals(Expression.evaluate("substr('1 + 3', 2, 3)").toString(), "+");
			assertEquals(Expression.evaluate("a''bc + d").toString(), "a'bcd");
			assertEquals(Expression.evaluate("substr('abc'+'def',1)").toString(), "bcdef");
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
			assertEquals(Expression.evaluate("max( ( 1 + 2 ), 2 + 3 )").toDouble(), new Double(5));
			assertEquals(Expression.evaluate("min(max(1,2),2 + 3)").toDouble(), new Double(2));
			assertEquals(Expression.evaluate("2 * ( 2 + 3 )").toDouble(), new Double(10));
			assertEquals(Expression.evaluate("( 1 + 1 ) * ( 2 + 3 )").toDouble(), new Double(10));
			assertEquals(Expression.evaluate("( 1 * 5 ) + ( 6 / 3 )").toDouble(), new Double(7));
			assertEquals(Expression.evaluate("1 + 2 * 6 / 3").toDouble(), new Double(5));
			assertEquals(Expression.evaluate("( 1 + 2) * 6 / 3").toDouble(), new Double(6));
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

		assertEquals(expression.getOperatorSet(), operatorSet);
	}

	/**
	 * 
	 */
	@Test
	public void testSetResolver() {
		Resolver resolver = new MockResolver();

		Expression expression = new Expression("'abc + def'");
		expression.setResolver(resolver);

		assertEquals(expression.getResolver(), resolver);
	}

	/**
	 * 
	 */
	@Test
	public void testStaticEvaluate() {
		try {
			assertEquals(Expression.evaluate("max( ( 1 + 2 ), 2 + 3 ) + 1"), new Argument(new Double(6), null));
		} catch (InvalidExpressionException e) {
			e.printStackTrace();
			fail();
		}
	}
}