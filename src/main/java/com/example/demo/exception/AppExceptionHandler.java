package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.model.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler  extends ResponseEntityExceptionHandler {
	
	public ResponseEntity<Object> handleAnyException(Exception ex , WebRequest request) {
		
		String error = ex.getLocalizedMessage();
		if( error == null ) 
			error = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(new Date() , error);
		
		return new ResponseEntity<Object>(error , new HttpHeaders() , HttpStatus.FORBIDDEN);
	}
}
