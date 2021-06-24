package com.cts.demo.service;

import java.util.List;

import com.cts.demo.model.Employee;

public interface IEmployeeService {

	/*
	 * 1. Get All Employees
	 */
	 public List<Employee> getAllEmployees();
	 
	 /*
	  * 2.Get Single Employee
	  */
	 public Employee getSingleEmployee(Integer eid);
	 
	 /*
	  * 3. Create or Save an Employee
	  */
	 
	 public Employee saveEmployee(Employee emp);
	 
	 /*
	  * 4. Delete Employee
	  */
	 public void deleteEmployee(Integer eid);
	 
	 /*
	  * 5. Updating Employee By eid
	  */
	
}
