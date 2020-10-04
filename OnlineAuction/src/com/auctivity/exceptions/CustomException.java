/**
 * 
 * This java file is a class that throws Custom Exception
 * This class extends Exception class as Super class
 */

package com.auctivity.exceptions;

/**
 * @author PRANAV
 *
 */
public class CustomException extends Exception {

	/**
	 * @param arg0
	 * @param arg1
	 */
	public CustomException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public CustomException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	
	
}
