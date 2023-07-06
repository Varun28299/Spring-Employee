package com.js.springemployee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.js.springemployee.dto.ResponseStructure;

@ControllerAdvice                   //any exception occurs in project will come here because of this annotation here we handle the exception
public class ApplicationExceptionHandler {

	@ExceptionHandler(value =NoIdFoundException.class)                                //if exception occured is equal to the value assigned i.e.,if exception is of Noidfound type then assign it to the method argument
	public ResponseEntity<ResponseStructure<String>> noIdFound(NoIdFoundException e){ //in this method we are returning the response in the form of response structure class(in dto layer)
		                                                                              //exception object is stored in e.
		ResponseStructure<String> res=new ResponseStructure<String>();
	    res.setData("Not Found");
	    res.setMessage(e.getMessage());
	    res.setStatusCode(HttpStatus.NOT_FOUND.value());
	    
	    return new ResponseEntity<ResponseStructure<String>>(res,HttpStatus.NOT_FOUND); // new-->because we are returning object
	}
}
