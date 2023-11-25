package com.ramRanjan.EmployeeManagementSystem.exception;

public class EmployeeNotFoundByIdException extends RuntimeException {

	private String message;

	public EmployeeNotFoundByIdException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
