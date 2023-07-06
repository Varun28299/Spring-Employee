package com.js.springemployee.dto;

public class ResponseStructure<T>{

	private T data;   //data is T type(T we mentioned as generic in class T is object)
	private String message;
	private int statusCode;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
