package com.example.bPrecise.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee extends Person{
	
	@Column(name="position")
	@Size(min=2, message="position should have atleast 2 characters")
	private String position;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="manager_id")
	private Manager manager;
	
	@OneToMany(mappedBy="employee")
	private List<Report> reports;
	
	@OneToMany(mappedBy="employee")
	private List<Task> tasks;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, String firstName, String lastName) {
		super(id, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public Employee(String position) {
		super();
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return String.format("Employee [id=%s, firstName=%s, lastName=%s , position=%s]", this.getId(), this.getFirstName(), this.getLastName(), position);
	}
	
	
	
	
	
	
}
