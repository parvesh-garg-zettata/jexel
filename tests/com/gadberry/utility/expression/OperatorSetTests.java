package com.gadberry.utility.expression;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gadberry.utility.expression.symbol.AdditionSymbol;
import com.gadberry.utility.expression.symbol.SubtractionSymbol;

/**
 * @author Aaron Gadberry
 * 
 */
public class OperatorSetTests {

    private OperatorSet opSet = null;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
	opSet = OperatorSet.getStandardOperatorSet();
    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
	opSet = null;
    }

    /**
	 * 
	 */
    @Test
    public void testAddOperator() {
	Operator op = null;

	op = opSet.findOperator("+", null);
	if (!(op instanceof AdditionSymbol)) {
	    fail();
	}

	opSet = new OperatorSet();

	op = opSet.findOperator("+", null);
	if (!(op == null)) {
	    fail();
	}

	opSet.addOperator("+", AdditionSymbol.class);
	op = opSet.findOperator("+", null);
	if (!(op instanceof AdditionSymbol)) {
	    fail();
	}
    }

    /**
	 * 
	 */
    @Test
    public void testFindOperator() {
	Operator op = null;

	op = opSet.findOperator("+", null);
	if (!(op instanceof AdditionSymbol)) {
	    fail();
	}

	op = opSet.findOperator("+a", null);
	if (!(op instanceof AdditionSymbol)) {
	    fail();
	}

	op = opSet.findOperator("aaaaaaaa", null);
	if (!(op == null)) {
	    fail();
	}
    }

    /**
	 * 
	 */
    @Test
    public void testGetSymbols() {
	opSet = new OperatorSet();
	opSet.addOperator("+", AdditionSymbol.class);
	opSet.addOperator("-", SubtractionSymbol.class);

	List<String> symbols = opSet.getDelimeters();
	if (!symbols.contains("+")) {
	    fail();
	} else if (!symbols.contains("-")) {
	    fail();
	} else if (symbols.contains("*")) {
	    fail();
	}
    }
}
