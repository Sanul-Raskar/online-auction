package com.auctivity.exceptions;

public class InvalidDataFormatException extends Exception{

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidDataFormatException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public InvalidDataFormatException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public InvalidDataFormatException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
