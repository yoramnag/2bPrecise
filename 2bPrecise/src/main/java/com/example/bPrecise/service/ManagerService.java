package com.example.bPrecise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bPrecise.dao.ManagerRepository;
import com.example.bPrecise.entity.Manager;
import com.example.bPrecise.exception.ManagerNotFoundException;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	// return all Managers
	public List<Manager> findAll() {
		return managerRepository.findAll();
	}
	
	//return manager
	public Optional<Manager> findById(int id) {
		Optional<Manager> manager = managerRepository.findById(id);
		
		if(!manager.isPresent()) {
			throw new ManagerNotFoundException("id - " + id);
		}
		return manager;
		
	}

}
