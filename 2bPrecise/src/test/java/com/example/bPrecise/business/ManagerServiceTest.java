package com.example.bPrecise.business;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.bPrecise.dao.ManagerRepository;
import com.example.bPrecise.entity.Manager;
import com.example.bPrecise.service.ManagerService;

@ExtendWith(MockitoExtension.class)
public class ManagerServiceTest {
	
	@InjectMocks
	private ManagerService managerService;
	
	@Mock
	private ManagerRepository managerRepository;
	
	@Test
	public void retrieveAllManagers_basic() {
		when(managerRepository.findAll()).thenReturn(Arrays.asList(new Manager(1,"Ziv","Cohen"),
				new Manager(2, "Admon", "Hagbi")));
		List<Manager> managers = managerService.findAll();
		
		assertEquals("Ziv",managers.get(0).getFirstName());
	}

}
