package com.example.bPrecise.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bPrecise.entity.Employee;
import com.example.bPrecise.entity.Manager;
import com.example.bPrecise.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// expose "/employee" and return list of employees
	@GetMapping("/employee")
	public List<Employee> retrieveAllEmployees() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public EntityModel<Employee> retrieveEmployee(@PathVariable int id) {
		Optional<Employee> employee = employeeService.findById(id);
		EntityModel<Employee> resource = EntityModel.of(employee.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllEmployees());
		resource.add(linkTo.withRel("all-employee"));
		return resource;
	}

}
