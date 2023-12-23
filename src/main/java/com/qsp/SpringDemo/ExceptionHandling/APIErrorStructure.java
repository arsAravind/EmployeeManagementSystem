package com.qsp.SpringDemo.ExceptionHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class APIErrorStructure {
	
	private HttpStatus httpStatus;
	private String httpMessage;
	private int httpStatuscode;
	private LocalDateTime dateTime;
}
