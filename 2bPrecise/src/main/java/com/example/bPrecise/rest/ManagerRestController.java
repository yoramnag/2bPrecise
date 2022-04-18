package com.example.bPrecise.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;

import com.example.bPrecise.entity.Employee;
import com.example.bPrecise.entity.Manager;
import com.example.bPrecise.service.EmployeeService;
import com.example.bPrecise.service.ManagerService;

@RestController
@RequestMapping("/api")
public class ManagerRestController {
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private EmployeeService employeeService;
	
	// expose "/manager" and return list of managers
	@GetMapping("/manager")
	public List<Manager> retrieveAllManagers() {
		return managerService.findAll();
	}
	
	@GetMapping("/manager/{id}")
	public EntityModel<Manager> retrieveManager(@PathVariable int id) {
		Optional<Manager> manager = managerService.findById(id);
		EntityModel<Manager> resource = EntityModel.of(manager.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllManagers());
		resource.add(linkTo.withRel("all-managers"));
		return resource;
	}
	
	@PostMapping("/manager")
	public ResponseEntity<Object> createManager(@Valid @RequestBody Manager manager) {
		manager.setId(0);
		Manager savedManager = managerService.save(manager);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedManager.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/manager")
	public ResponseEntity<Object> updateManager(@Valid @RequestBody Manager manager) {
		managerService.findById(manager.getId());
		managerService.save(manager);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/manager/{id}")
	public ResponseEntity<Object> deleteManager(@PathVariable int id) {
		managerService.findById(id);
		managerService.deleteManager(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/manager/{id}/employee")
	public List<Employee> retrieveAllEmployees(@PathVariable int id){
		Optional<Manager> manager = managerService.findById(id);
		return manager.get().getEmployees();
	}
	
	@PostMapping("/manager/{id}/employee")
	public ResponseEntity<Object> createEmployee(@PathVariable int id, @RequestBody Employee employee) {
		employee.setId(0);
		Optional<Manager> managerOptional = managerService.findById(id);
		Manager manager = managerOptional.get();
		employee.setManager(manager);
		employeeService.save(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	

}
