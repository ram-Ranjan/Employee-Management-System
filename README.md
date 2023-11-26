# Employee Management System

## Overview

A simple Employee Management System designed for CRUD operations using Spring Boot and MySQL.

## Technologies Used

- Java 17
- Spring Boot 3.1.6
- Spring Data JPA
- MySQL Connector Java 8.0.28
- Lombok
- Maven

## Getting Started

1. Clone the repository:

   ```bash
   git clone [https://github.com/ram-Ranjan/Employee-Management-System](https://github.com/ram-Ranjan/Employee-Management-System.git)
   
Navigate to the project directory:
   ```bash
cd EmployeeManagementSystem

Build the project:
   ```bash
mvn clean install

Run the application:
   ```bash
mvn spring-boot:run



API Endpoints
POST /employee: Add a new employee

GET /employee/findAllEmployees: Get a list of all employees

GET /employee/name/{empName}: Get employee details by name

GET /employee/findBySalaryRange: Get employees with salary between 70000 and 76000

PUT /employee/role/{id}: Update the role of an employee

PUT /employee/salary/{id}: Update the salary of an employee

PUT /employee/teamName/{id}: Update the team name of an employee

PUT /employee/{id}: Update all details of an employee

DELETE /employee/{id}: Delete an employee by ID

DELETE /employee/name/{empName}: Delete an employee by name

DELETE /employee/deleteAll: Delete all employees
