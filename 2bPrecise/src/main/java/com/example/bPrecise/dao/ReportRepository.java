package com.example.bPrecise.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bPrecise.entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{

}
