package com.cgi.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Value(value="${data.exception.msg}")
	private String msg;
	
	@ExceptionHandler(value = DepartmentAlreadyExistsException.class)
	public ResponseEntity<String> DepartmentAlreadyExistsException(DepartmentAlreadyExistsException dap){
	        return new ResponseEntity<String>(msg, HttpStatus.CONFLICT);
	   }
		

}
