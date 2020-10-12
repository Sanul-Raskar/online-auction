package com.auctivity.exceptions;

public class InsufficientBalanceException extends Exception{

	/**
	 * @param message
	 * @param cause
	 */
	public InsufficientBalanceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public InsufficientBalanceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public InsufficientBalanceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
