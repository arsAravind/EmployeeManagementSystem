package com.qsp.SpringDemo.ExceptionHandling;

public class PasswordInvalidException extends Exception{

	@Override
	public String getMessage() {
		
		return "Password is invalid";
	}
}
