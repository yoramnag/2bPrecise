package com.example.bPrecise.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bPrecise.entity.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
