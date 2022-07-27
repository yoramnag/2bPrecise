package com.example.bPrecise.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.beans.Expression;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.bPrecise.entity.Manager;
import com.example.bPrecise.rest.ManagerRestController;
import com.example.bPrecise.service.EmployeeService;
import com.example.bPrecise.service.ManagerService;
import com.example.bPrecise.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(ManagerRestController.class)
public class ManagerRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ManagerService managerService;
	
	@MockBean
	private EmployeeService employeeService;
	
	@MockBean
	private TaskService taskService;
	
	@Test
	public void retrieveAllManagers_basic() throws Exception {
		
		when(managerService.findAll()).thenReturn(
				Arrays.asList(new Manager(1,"Eyal","Zoref"),new Manager(2,"Sahar","Kelly"))
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/api/manager")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:1,firstName:Eyal,lastName:Zoref}, "
						+ "{id:2,firstName:Sahar,lastName:Kelly}]"))
				.andReturn();
		
	}
	
	@Test
	public void retrieveAllOne_basic() throws Exception {
		Optional<Manager> manager = Optional.ofNullable(new Manager(1,"Eyal","Zoref"));
		when(managerService.findById(1)).thenReturn(manager);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/api/manager/1")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:1,firstName:Eyal,lastName:Zoref}"))
				.andReturn();
	}
	
//	@Test
//	public void saveNewManager_basic() throws Exception {
//		RequestBuilder request = MockMvcRequestBuilders.post("/api/manager")
//				.accept(MediaType.APPLICATION_JSON)
//				.content("{\"id\": 10003,\"firstName\": \"Ran\",\"lastName\": \"Avital\"}")
//				.contentType(MediaType.APPLICATION_JSON);
//		
//		MvcResult result = mockMvc.perform(request)
//				.andExpect(status().isCreated())
//				.andExpect(header().string("location",containsString("/api/manager/")))
//				.andReturn();
//		System.out.println("jkhhn");
//	}
	
	

}
