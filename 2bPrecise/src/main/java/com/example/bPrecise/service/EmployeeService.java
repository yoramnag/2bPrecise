package com.example.bPrecise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bPrecise.dao.EmployeeRepository;
import com.example.bPrecise.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository EmployeeRepository;
	
	// Return all employees
	public List<Employee> findAll(){
		return EmployeeRepository.findAll();
	}

}
