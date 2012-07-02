package com.gadberry.utility.expression;

/**
 * @author Aaron Gadberry
 */

public class InvalidArgumentsException extends Exception {

    private static final long serialVersionUID = 4906613720234551904L;

    /**
     * Create an exception symbolizing an invalid set of arguments for a given
     * {@link Operator}
     * 
     * @param message
     *            to the user indicating the problem
     */
    public InvalidArgumentsException(String message) {
	super(message);
    }

}
