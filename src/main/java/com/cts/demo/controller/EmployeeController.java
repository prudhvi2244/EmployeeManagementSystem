package com.cts.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.demo.model.Employee;
import com.cts.demo.service.IEmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService eservice;
	
	/*
	 * Creating An Employee
	 * http://localhost:8080/employees/saveEmployee
	 */
	@PostMapping(value = "/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp)
	{
		Employee employee=eservice.saveEmployee(emp);
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	}
	
	
	/*
	 *  Getting All Employees
	 *  http://localhost:8080/employees/allEmployees
	 */
	
	@GetMapping(value = "/allEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> allEmployees=eservice.getAllEmployees();
		return new ResponseEntity<List<Employee>>(allEmployees,HttpStatus.OK);
	}
	
	/*
	 * Get Single Employee By Providing Employee ID
	 * http://localhost:8080/employees/getSingleEmployee/1
	 */
	@GetMapping(value = "/getSingleEmployee/{eid}")
	public ResponseEntity<Employee> getSingleEmployee(@PathVariable Integer eid)
	{
		Employee emp=eservice.getSingleEmployee(eid);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	/*
	 * Delete Employee By ID
	 * http://localhost:8080/employees/deleteEmployee/1
	 */
	
	@DeleteMapping(value = "/deleteEmployee/{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer eid)
	{
		Employee emp=eservice.getSingleEmployee(eid);
		eservice.deleteEmployee(emp.getEid());
		return new ResponseEntity<String>("Employee With Given ID :"+eid+" Deleted Successfully",HttpStatus.OK);
	}

}
