package com.qsp.SpringDemo.ExceptionHandling;

public class IdNotFoundException extends Exception {

	@Override
	public String getMessage() {

		return "Employee ID not found";
	}
}
