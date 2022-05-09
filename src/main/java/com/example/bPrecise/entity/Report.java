package com.example.bPrecise.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Report {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="Text should have atleast 2 characters")
	private String text;
	
	@CreationTimestamp
	private Date date;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="employee_id")
	private Employee employee;

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(Integer id, String text) {
		super();
		this.id = id;
		this.text = text;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return String.format("Report [id=%s, text=%s, date=%s]", this.getId(), this.getText(), this.getDate());
	}
	

}
