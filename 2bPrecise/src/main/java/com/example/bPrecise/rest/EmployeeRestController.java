package com.example.bPrecise.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bPrecise.entity.Employee;
import com.example.bPrecise.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// expose "/employee" and return list of employees
	@GetMapping("/employee")
	public List<Employee> retrieveAllEmployees() {
		return employeeService.findAll();
	}

}
