package com.uxpsystems.assignment.exceptions;
/**
 * 
 * @author shivkumb
 * This is DataNotSavedException will be thrown when user tries to save data but gets unique constraints on username and password
 */
public class DataNotSavedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This is DataNotSavedException class constructor will be thrown when user tries to save data but gets unique constraints on username and password
	 */
	public DataNotSavedException() {
		
	}
}
