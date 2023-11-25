package com.ramRanjan.EmployeeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramRanjan.EmployeeManagementSystem.exception.EmployeeNotFoundByIdException;
import com.ramRanjan.EmployeeManagementSystem.exception.UniqueTeamsNotFoundException;
import com.ramRanjan.EmployeeManagementSystem.modules.Employee;
import com.ramRanjan.EmployeeManagementSystem.modules.Role;
import com.ramRanjan.EmployeeManagementSystem.repository.EmployeeRepository;
import com.ramRanjan.EmployeeManagementSystem.util.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	// Save Employee Rest Apis
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(Employee employee) {
		empRepository.save(employee);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Employee added successfully.");
		structure.setData(employee);
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);

	}

	// Find Employee Rest Apis
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeById(long id) {
		Optional<Employee> existingEmployee = empRepository.findById(id);
		
		if (existingEmployee.isPresent()) {
		ResponseStructure<Employee> structure = new ResponseStructure<>();

		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("Employee found.");
		structure.setData(existingEmployee);
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
	}else {
		throw new EmployeeNotFoundByIdException("Failed to find Employee!");
	}
	}
	

	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployees() {
		List<Employee> employees = empRepository.findAll();
		if(employees!=null) {
			ResponseStructure<List<Employee>> structure = new ResponseStructure<>();

			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employee found.");
			structure.setData(employees);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		}else {
			throw new EmployeeNotFoundByIdException("Failed to find Employee!");
		}
	}
	

	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByName(String empName) {
		Optional<Employee> existingEmployee = empRepository.findByEmpName(empName);
		
		if (existingEmployee.isPresent()) {
			ResponseStructure<Employee> structure = new ResponseStructure<>();

			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employee found.");
			structure.setData(existingEmployee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		}else {
			throw new EmployeeNotFoundByIdException("Failed to find Employee!");
		}
		
		
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeBySalary(long salary) {
		List<Employee> empList = empRepository.findByEmpSalary(salary);

		if(empList!=null) {
			ResponseStructure<List<Employee>> structure = new ResponseStructure<>();

			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employee found.");
			structure.setData(empList);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		}else {
			throw new EmployeeNotFoundByIdException("Failed to find Employee!");
		}
	
	}
	
	public ResponseEntity<ResponseStructure<List<String>>> findAllUniqueTeams() {
		List<String> teamsList = empRepository.findAllUniqueTeams();
		
		if(teamsList!=null) {
			ResponseStructure<List<String>> structure = new ResponseStructure<>();

			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Unique Teams found.");
			structure.setData(teamsList);
			return new ResponseEntity<ResponseStructure<List<String>>>(structure, HttpStatus.FOUND);
		}else {
			throw new UniqueTeamsNotFoundException("Failed to find Unique Teams!");
		}
	}

	// Update Rest Apis

	public ResponseEntity<ResponseStructure<Employee>> updateRole(long id, Role role) {

		Optional<Employee> existingEmployee = empRepository.findById(id);
		
		if (existingEmployee.isPresent()) {
			ResponseStructure<Employee> structure = new ResponseStructure<>();

			Employee employee = existingEmployee.get();
			employee.setRole(role);
			empRepository.save(employee);
			
			
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employee Updated.");
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		}else {
			throw new EmployeeNotFoundByIdException("Failed to find Employee!");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateSalary(long id, long salary) {

		Optional<Employee> existingEmployee = empRepository.findById(id);
		
		if (existingEmployee.isPresent()) {
			ResponseStructure<Employee> structure = new ResponseStructure<>();

			Employee employee = existingEmployee.get();
			employee.setSalary(salary);
			empRepository.save(employee);
			
			
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employee Updated.");
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		}else {
			throw new EmployeeNotFoundByIdException("Failed to find Employee!");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateTeamName(long id, String teamName) {

		Optional<Employee> existingEmployee = empRepository.findById(id);
		if (existingEmployee.isPresent()) {
			ResponseStructure<Employee> structure = new ResponseStructure<>();

			Employee employee = existingEmployee.get();
			employee.setTeamName(teamName);
			empRepository.save(employee);
			
			
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employee Updated.");
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		}else {
			throw new EmployeeNotFoundByIdException("Failed to find Employee!");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(long id, Employee updatedEmployee) {

		Optional<Employee> existingEmployee = empRepository.findById(id);
		
		if (existingEmployee.isPresent()) {
			ResponseStructure<Employee> structure = new ResponseStructure<>();

			Employee employee = existingEmployee.get();
			
			employee.setId(id);

			if (updatedEmployee.getEmpName() != null)
				employee.setEmpName(updatedEmployee.getEmpName());

			if (updatedEmployee.getCompanyName() != null)
				employee.setEmpName(updatedEmployee.getCompanyName());

			if (updatedEmployee.getRole() != null)
				employee.setRole(updatedEmployee.getRole());

			if (updatedEmployee.getSalary() != 0)
				employee.setSalary(updatedEmployee.getSalary());

			if (updatedEmployee.getTeamName() != null)
				employee.setTeamName(updatedEmployee.getTeamName());
			
			empRepository.save(employee);
			
			
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employee Updated.");
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		}else {
			throw new EmployeeNotFoundByIdException("Failed to find Employee!");
		}


	}

	// Delete Rest Apis
	
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(long id) {

		Optional<Employee> existingEmployee = empRepository.findById(id);
		if (existingEmployee.isPresent()) {

			ResponseStructure<Employee> structure = new ResponseStructure<>();

			empRepository.delete(existingEmployee.get());
			
			
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employee Deleted.");
			structure.setData(existingEmployee.get());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		}else {
			throw new EmployeeNotFoundByIdException("Failed to find Employee!");
		}
	}
	
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeByEmpName(String empName) {
		Optional<Employee> existingEmployee = empRepository.findByEmpName(empName);

		if (existingEmployee.isPresent()) {

			ResponseStructure<Employee> structure = new ResponseStructure<>();

			empRepository.delete(existingEmployee.get());
			
			
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employee Deleted.");
			structure.setData(existingEmployee.get());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		}else {
			throw new EmployeeNotFoundByIdException("Failed to find Employee!");
		}
	}

	public void deleteAll() {
		empRepository.deleteAll();
	}

}
