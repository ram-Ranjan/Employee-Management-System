package com.ramRanjan.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramRanjan.EmployeeManagementSystem.modules.Employee;
import com.ramRanjan.EmployeeManagementSystem.service.EmployeeService;
import com.ramRanjan.EmployeeManagementSystem.util.ResponseStructure;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService service;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(@RequestBody Employee employee){
		return service.addEmployee(employee);
	}
	}
	
	
	


