package com.example.bPrecise.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import com.example.bPrecise.dao.ManagerRepository;
import com.example.bPrecise.entity.Manager;


@DataJpaTest
public class ManagerRepositoryTest {
	
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Test
	public void testFindAllManagers() {
		List<Manager> managers = managerRepository.findAll();
		assertEquals(2,managers.size());
	}
	
	@Test
	public void testFindOne() {
		Manager manager = managerRepository.findById(10001).get();
		assertEquals("Yoram",manager.getFirstName());
	}

}
