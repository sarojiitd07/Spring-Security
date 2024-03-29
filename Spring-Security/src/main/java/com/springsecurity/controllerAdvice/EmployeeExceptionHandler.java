package com.springsecurity.controllerAdvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springsecurity.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class EmployeeExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String>  exceptionHandler(MethodArgumentNotValidException ex){
		Map<String,String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public Map<String,String> businessLogicHandler(EmployeeNotFoundException ex){
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("Error Message", ex.getMessage());
		return errorMap;
	}
}
