package com.qsp.SpringDemo.ExceptionHandling;

public class EmailNotValidException extends Exception{

	@Override
	public String getMessage() {
		
		return "Email Not found";
	}
}
