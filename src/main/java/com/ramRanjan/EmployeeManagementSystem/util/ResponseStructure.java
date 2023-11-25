package com.ramRanjan.EmployeeManagementSystem.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T> {
	
	private int status;
	private String message;
	private Object data;
	
	

}
