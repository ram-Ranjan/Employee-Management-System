package com.ramRanjan.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramRanjan.EmployeeManagementSystem.modules.Employee;
import com.ramRanjan.EmployeeManagementSystem.modules.Role;
import com.ramRanjan.EmployeeManagementSystem.service.EmployeeService;
import com.ramRanjan.EmployeeManagementSystem.util.ResponseStructure;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	// Rest Api to add Employee i.e Create Operation
	@PostMapping
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}

	// Rest Api to fetch all employees i.e Retrieve Operation
	@GetMapping("/findAllEmployees")
	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployees() {
		{
			return service.findAllEmployees();
		}
	}

	// Rest Api fetch Employee by name
	@GetMapping("/name/{empName}")
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByName(@PathVariable String empName) {
		return service.findEmployeeByName(empName);
	}

	// Rest Api to fetch Employee between salary range 70000-76000
	@GetMapping("/findBySalaryRange")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeBySalary() {

		return service.findEmployeeBySalary();

	}

	// Rest Api to Update Employee

	// Update Employee role
	@PutMapping("/role/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateRole(@PathVariable long id, @RequestParam Role role) {

		return service.updateRole(id, role);
	}

	// Update Employee salary
	@PutMapping("/salary/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateSalary(@PathVariable long id, @RequestParam long salary) {

		return service.updateSalary(id, salary);
	}

	// Update Employee teamName
	@PutMapping("/teamName/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateTeamName(@PathVariable long id,
			@RequestParam String teamName) {

		return service.updateTeamName(id, teamName);
	}

	// Update Employee
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@PathVariable long id,
			@RequestBody Employee updatedEmployee) {

		return service.updateEmployee(id, updatedEmployee);

	}
	// Delete Employee

	// Delete by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(@PathVariable long id) {
		return service.deleteEmployeeById(id);
	}

	// Delete by Name
	@DeleteMapping("/name/{empName}")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeByEmpName(@PathVariable String empName) {

		return service.deleteEmployeeByEmpName(empName);

	}

	// Delete All information
	@DeleteMapping("/deleteAll")
	public ResponseEntity<ResponseStructure<List<Employee>>> deleteAll() {
		return service.deleteAll();
	}

}
