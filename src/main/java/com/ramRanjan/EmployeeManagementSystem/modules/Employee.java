package com.ramRanjan.EmployeeManagementSystem.modules;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empId")
	private long id;
	@Column(name = "empName")
	private String empName;
	@Column(name = "companyName")
	private String companyName;
	@Column(name = "role")
	private Role role;
	@Column(name = "TeamName")
	private String teamName;
	@Column(name = "empSalary")
	private long salary;
	
	

}
