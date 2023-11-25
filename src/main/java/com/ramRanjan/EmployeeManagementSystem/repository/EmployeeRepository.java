package com.ramRanjan.EmployeeManagementSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ramRanjan.EmployeeManagementSystem.modules.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{

	

	public Optional<Employee> findByEmpName(String empName);

    @Query("SELECT e FROM Employee e WHERE e.salary >= 70000 AND e.salary <= 76000")
	public List<Employee> findByEmpSalary(long salary);

    
    @Query("SELECT DISTINCT e.teamName from Employee e")
	public List<String> findAllUniqueTeams();
	
	
	
	

}
