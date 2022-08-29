package com.jdot.crudStudentData.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;



public class GlobalExceptionHandler {
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> RecordNotFoundException(RecordNotFoundException exception)
	{
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}

}
