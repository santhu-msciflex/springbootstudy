package com.example.demo.userservice;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleGenralException(Exception ex, WebRequest request) throws Exception {

		ResponseExceptionStructure structure = new ResponseExceptionStructure(new Date(), ex.getMessage(),
				request.getDescription(true));
		return new ResponseEntity<Object>(structure, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) throws Exception {

		ResponseExceptionStructure structure = new ResponseExceptionStructure(new Date(), ex.getMessage(),
				request.getDescription(true));
		return new ResponseEntity<Object>(structure, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ResponseExceptionStructure structure = new ResponseExceptionStructure(new Date(), "Invalid data",
				ex.getBindingResult().toString());
		return new ResponseEntity<Object>(structure, HttpStatus.BAD_REQUEST);

	}
}
