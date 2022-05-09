package com.example.bPrecise.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="first_name")
	@Size(min=2, message="first name should have atleast 2 characters")
	private String firstName;
	
	@Column(name="last_name")
	@Size(min=2, message="last name should have atleast 2 characters")
	private String lastName;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Person [id=%s, firstName=%s, lastName=%s]", id, firstName, lastName);
	}
	
	

}
