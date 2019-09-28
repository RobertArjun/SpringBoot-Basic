package com.micro.app.ws.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.micro.app.ws.response.mapper.CustomErrorResponse;

@ControllerAdvice
public class AppExceptionHandlar extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleExceptionHandler(Exception ex, WebRequest wr) {
		/*
		 * return new ResponseEntity<>(ex, new HttpHeaders(),
		 * HttpStatus.INTERNAL_SERVER_ERROR);
		 */
		// Custom error Message
		String errorMessage = ex.getLocalizedMessage();
		if (errorMessage == null)
			errorMessage = ex.toString();

		CustomErrorResponse errorResponse = new CustomErrorResponse(new Date(), errorMessage);

		return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = { NullPointerException.class, UserServiceException.class })
	public ResponseEntity<Object> handleSpecificHandler(Exception ex, WebRequest wr) {
		String errorMessage = ex.getLocalizedMessage();
		if (errorMessage == null)
			errorMessage = ex.toString();

		CustomErrorResponse errorResponse = new CustomErrorResponse(new Date(), errorMessage);

		return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}
	

	/*
	 * @ExceptionHandler(value = { UserServiceException.class }) public
	 * ResponseEntity<Object> handleUserServiceExceptionHandler(UserServiceException
	 * ex, WebRequest wr) { String errorMessage = ex.getLocalizedMessage(); if
	 * (errorMessage == null) errorMessage = ex.toString();
	 * 
	 * CustomErrorResponse errorResponse = new CustomErrorResponse(new Date(),
	 * errorMessage);
	 * 
	 * return new ResponseEntity<>(errorResponse, new HttpHeaders(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 */

}
