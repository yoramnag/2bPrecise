package com.example.bPrecise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bPrecise.dao.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

}
