package com.uxpsystems.assignment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
/**
 * 
 * @author shivkumb
 *	GlobalExceptionHandling for customized exception thrown from various instances
 */
public class GlobalExceptionHandling extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Exception handling for UserDataNotFoundException which return 404 status.
	 * Reason - "No user/users found !!"
	 */
	@ExceptionHandler(UserDataNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "No user/users found !!")
	public void exceptionHandlingUserDataNotFoundException() {
	
	} 
	
	/**
	 * Exception handling for InvalidInputInRequest which return 422 status.
	 * Reason - "Invalid input, please check input data format!!"
	 */
	@ExceptionHandler(InvalidInputInRequest.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY,reason = "Invalid input, please check input data format!!")
	public void exceptionHandlingInvalidInputInRequest(){
	
	}
	
	/**
	 * Exception handling for DataNotSavedException which return 406 status.
	 * Reason - "Username or password already exists, please check data and try again!!"
	 */
	@ExceptionHandler(DataNotSavedException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE,reason = "Username or password already exists, please check data and try again!!")
	public void exceptionInvalidDataException(){
	
	}
}
