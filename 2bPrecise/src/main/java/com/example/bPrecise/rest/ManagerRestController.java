package com.example.bPrecise.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import com.example.bPrecise.entity.Manager;
import com.example.bPrecise.service.ManagerService;

@RestController
@RequestMapping("/api")
public class ManagerRestController {
	
	@Autowired
	private ManagerService managerService;
	
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

}
