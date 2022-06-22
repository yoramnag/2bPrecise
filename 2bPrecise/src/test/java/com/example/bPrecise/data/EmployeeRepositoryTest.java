package com.example.bPrecise.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.bPrecise.dao.EmployeeRepository;
import com.example.bPrecise.entity.Employee;

@DataJpaTest
public class EmployeeRepositoryTest {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void testFindAllManagers() {
		List<Employee> employee = employeeRepository.findAll();
		assertEquals(2,employee.size());
	}
	
	@Test
	public void testFindOne() {
		Employee employee = employeeRepository.findById(20002).get();
		assertEquals("Alon",employee.getFirstName());
	}

}
