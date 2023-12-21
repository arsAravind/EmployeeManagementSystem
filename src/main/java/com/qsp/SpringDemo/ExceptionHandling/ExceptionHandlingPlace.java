package com.qsp.SpringDemo.ExceptionHandling;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingPlace {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> entity(IdNotFoundException id)
	{
		return new ResponseEntity<Object>(id.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PasswordInvalidException.class)
	public ResponseEntity<Object> entity(PasswordInvalidException p)
	{
		return new ResponseEntity<Object>(p.getMessage(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmailNotValidException.class)
	public ResponseEntity<Object> entity(EmailNotValidException e)
	{
		ResponseEntity<Object> res =  new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		
		return res;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> map(MethodArgumentNotValidException m)
	{
		Map<String, String> map=new HashMap<>();
		m.getBindingResult().getFieldErrors().forEach((errors)->{
			map.put(errors.getField(), errors.getDefaultMessage());
		});
		
//		for(FieldError f: fieldErrors)
//		{
//			map.put(f.getField(), f.getDefaultMessage());
//		}
		return map;
	}
	
	


}
