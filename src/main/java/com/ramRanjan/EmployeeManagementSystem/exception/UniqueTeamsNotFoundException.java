package com.ramRanjan.EmployeeManagementSystem.exception;

public class UniqueTeamsNotFoundException extends RuntimeException {
	
private String message;
	
	public UniqueTeamsNotFoundException(String message)
	{
		this.message= message;
	}
	
	public String getMessage()
	{
		return message;
	}

}
