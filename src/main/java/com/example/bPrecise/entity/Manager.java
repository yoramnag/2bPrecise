package com.example.bPrecise.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Manager extends Person{
	
	@OneToMany(mappedBy="manager")
	private List<Employee> employees;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(Integer id, String firstName, String lastName) {
		super(id, firstName, lastName);
		// TODO Auto-generated constructor stub
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return String.format("Manager [id=%s, firstName=%s, lastName=%s]", this.getId(), this.getFirstName(), this.getLastName());
	}

	
	
	
}
