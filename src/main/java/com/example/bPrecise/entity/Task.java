package com.example.bPrecise.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Task {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="Text should have atleast 2 characters")
	private String text;
	
	@CreationTimestamp
	private Date assignDate;
	
	@FutureOrPresent
	private Date dueDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="employee_id")
	private Employee employee;

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(Integer id, @Size(min = 2, message = "Text should have atleast 2 characters") String text,
			Date assignDate, @FutureOrPresent Date dueDate) {
		super();
		this.id = id;
		this.text = text;
		this.assignDate = assignDate;
		this.dueDate = dueDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return String.format("Task [id=%s, text=%s, assignDate=%s , dueDate=%s]", this.getId(), this.getText(), this.getAssignDate(),this.getDueDate());
	}

}
