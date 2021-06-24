package com.cts.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.demo.exception.EmployeeNotFoundException;
import com.cts.demo.model.Employee;
import com.cts.demo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee saveEmployee(Employee emp) {
		Employee employee = repo.save(emp);
		return employee;
	}

	@Override
	public void deleteEmployee(Integer eid) {
		
		repo.deleteById(eid);

	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = (List<Employee>) repo.findAll();

		return allEmployees;
	}

	@Override
	public Employee getSingleEmployee(Integer eid) {
	  Optional<Employee> emp=repo.findById(eid);
	  return emp.orElseThrow(()-> new EmployeeNotFoundException("Employee With Given ID :"+eid+" Not Available"));
			  
	}

}
