package com.ness.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class AlreadyDeleted {
	@ExceptionHandler(AuthorAlreadyExists.class)
	public ResponseEntity<String> authorAlreadyDeleted()
	{
		return new ResponseEntity<String>("author is already deleted",HttpStatus.NOT_ACCEPTABLE);
	}
	

}
