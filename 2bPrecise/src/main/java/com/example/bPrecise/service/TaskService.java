package com.example.bPrecise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bPrecise.dao.TaskRepository;
import com.example.bPrecise.entity.Task;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	// Return all Tasks
	public List<Task> findAll() {
		return taskRepository.findAll();
	}
	
	// Save new task 
	public Task save (Task task) {
		return taskRepository.save(task);
	}

}
