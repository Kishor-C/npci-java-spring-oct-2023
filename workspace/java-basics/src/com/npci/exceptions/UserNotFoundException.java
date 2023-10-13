package com.npci.exceptions;
/*
 * Any class that extends Exception is Checked Exception except RuntimException which is an 
 * Unchecked Exception
 */
public class UserNotFoundException extends Exception {
	// it is always recommended to create constructors that matches the Exception class constructors
	// so you can generate the constructors from the super class
		
	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}
}
