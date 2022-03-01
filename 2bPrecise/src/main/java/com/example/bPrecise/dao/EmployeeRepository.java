package com.example.bPrecise.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bPrecise.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
