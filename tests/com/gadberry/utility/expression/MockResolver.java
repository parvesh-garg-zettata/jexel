package com.gadberry.utility.expression;

/**
 * @author Aaron Gadberry
 * 
 */
public class MockResolver implements Resolver {

    @Override
    public boolean canResolve(String path) {
	return true;
    }

    @Override
    public Object resolve(String path) {
	return path;
    }

}
