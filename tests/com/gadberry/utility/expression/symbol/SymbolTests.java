package com.gadberry.utility.expression.symbol;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gadberry.utility.expression.Argument;
import com.gadberry.utility.expression.Symbol;

/**
 * @author Aaron Gadberry
 * 
 */
public class SymbolTests {

    private Symbol op = null;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
	op = new MockSymbol(null);
    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
	op = null;
    }

    /**
     * This checks basic argument resolution
     */
    @Test
    public void testParseArgs() {
	List<String> tokens = new ArrayList<String>();
	tokens.add("1 - 2");
	tokens.add("+");
	tokens.add("max(3, 4)");
	int position = 1;
	List<Argument> args = op.parseArgs(tokens, position);
	assertEquals(new Argument("1 - 2", null), args.get(0));
	assertEquals(new Argument("max(3, 4)", null), args.get(1));
    }
}
