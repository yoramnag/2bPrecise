package com.example.bPrecise.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.bPrecise.dao.TaskRepository;
import com.example.bPrecise.entity.Task;

@DataJpaTest
public class TaskRepositoryTest {
	
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Test
	public void testFindAllManagers() {
		List<Task> task = taskRepository.findAll();
		assertEquals(2,task.size());
	}
	
	@Test
	public void testFindOne() {
		Task task = taskRepository.findById(40001).get();
		assertEquals("task 1",task.getText());
	}

}
