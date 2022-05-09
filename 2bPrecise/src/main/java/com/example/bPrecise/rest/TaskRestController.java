package com.example.bPrecise.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bPrecise.entity.Task;
import com.example.bPrecise.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskRestController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/task")
	public List<Task> retrieveAllEmployees() {
		return taskService.findAll();
	}

}
