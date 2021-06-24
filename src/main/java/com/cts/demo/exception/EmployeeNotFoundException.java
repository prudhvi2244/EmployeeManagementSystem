package com.cts.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {
		
	String msg;
	public EmployeeNotFoundException(String msg) {
		super(msg);
		System.out.println(msg);
	}

}
