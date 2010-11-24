package com.gadberry.utility.expression;

/**
 * @author Aaron Gadberry
 */

public class ArgumentCastException extends RuntimeException {

	private static final long serialVersionUID = -4298090765367524519L;
	
	static String createMessage(String type, Argument arg) {
		StringBuffer exceptionMessage = new StringBuffer("Argument can not be interpreted as a ");
		exceptionMessage.append(type);
		if(arg.getObject() == null){
			exceptionMessage.append(".  Arg is null.");
		} else {
			exceptionMessage.append(".  Arg Class:" + arg.getClass().toString() + " Value:" + arg.toString());
		}
		return exceptionMessage.toString();
	}
	
	ArgumentCastException(String message) {
		super(message);
	}
}
