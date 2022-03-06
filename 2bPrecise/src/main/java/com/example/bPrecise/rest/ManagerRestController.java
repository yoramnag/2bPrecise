package com.example.bPrecise.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bPrecise.entity.Manager;
import com.example.bPrecise.service.ManagerService;

@RestController
@RequestMapping("/api")
public class ManagerRestController {
	
	@Autowired
	private ManagerService managerService;
	
	// expose "/manager" and return list of managers
	@GetMapping("/manager")
	public List<Manager> findAll() {
		return managerService.findAll();
	}
	
	

}
