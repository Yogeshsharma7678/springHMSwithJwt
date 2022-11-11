package com.HMS.advice;
/*exceptionHandler class to handle exceptions which is define by user 
 *  or system
 */
import java.util.HashMap;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.HMS.exception.GlobalException;
@RestControllerAdvice
public class exceptionHandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	
	//to handle method argument not valid exception 
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> InvalidArgumentHandler(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

	//Handling  user define exception
	@ExceptionHandler(GlobalException.class)
	public Map<String, String> GlobalExceptionHandler(GlobalException ge) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("Errorr : ", ge.getMessage());
		return errorMap;
	}
}
