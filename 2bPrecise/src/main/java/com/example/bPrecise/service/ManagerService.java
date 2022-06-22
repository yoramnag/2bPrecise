package com.example.bPrecise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.bPrecise.dao.ManagerRepository;
import com.example.bPrecise.entity.Employee;
import com.example.bPrecise.entity.Manager;
import com.example.bPrecise.exception.ManagerNotFoundException;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	// Return all Managers
	public List<Manager> findAll() {
		return managerRepository.findAll();
	}
	
	//Return manager
	public Optional<Manager> findById(int id) {
		Optional<Manager> manager = managerRepository.findById(id);
		
		if(!manager.isPresent()) {
			throw new ManagerNotFoundException("id - " + id);
		}
		return manager;
	}
	
	// Save new manager 
	public Manager save (Manager manager) {
		return managerRepository.save(manager);
	}
	
	// Delete manager
	public void deleteManager(int id) {
		managerRepository.deleteById(id);
	}
	
	public boolean isManagerExist(int id) {
		Optional<Manager> manager = managerRepository.findById(id);
		
		if(!manager.isPresent()) {
			throw new ManagerNotFoundException("id - " + id);
		}
		return true;
	}
	
	public boolean checkIfEmployeeIsUnderManager(List<Employee> empList , int empId) {
		for (int i = 0; i < empList.size(); i++) {
			if(empList.get(i).getId() == empId) {
				return true;
			}
		}
		return false; 
	}
	
	

}
