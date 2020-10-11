package com.auctivity.exceptions;

public class ForbiddenAccessException extends Exception{

	/**
	 * @param message
	 * @param cause
	 */
	public ForbiddenAccessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ForbiddenAccessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ForbiddenAccessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
