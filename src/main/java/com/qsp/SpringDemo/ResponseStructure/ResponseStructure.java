package com.qsp.SpringDemo.ResponseStructure;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import lombok.Data;
@Data
public class ResponseStructure<T> {

	private T data;
	private String httpMessage;
	private int httpStatuscode;
	private HttpStatus status;
	private LocalDate date;
}
