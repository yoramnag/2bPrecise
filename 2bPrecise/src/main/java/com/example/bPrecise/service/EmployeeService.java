package com.example.bPrecise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bPrecise.dao.EmployeeRepository;
import com.example.bPrecise.entity.Employee;
import com.example.bPrecise.entity.Manager;
import com.example.bPrecise.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository EmployeeRepository;
	
	// Return all employees
	public List<Employee> findAll(){
		return EmployeeRepository.findAll();
	}
	
	//Return employee
	public Optional<Employee> findById(int id) {
		Optional<Employee> employee = EmployeeRepository.findById(id);
		
		if(!employee.isPresent()) {
			throw new EmployeeNotFoundException("id - " + id);
		}
		return employee;
	}
	
	// Save new employee 
	public Employee save (Employee employee) {
		return EmployeeRepository.save(employee);
	}

}
