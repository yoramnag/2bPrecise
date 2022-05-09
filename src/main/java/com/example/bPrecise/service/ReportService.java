package com.example.bPrecise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bPrecise.dao.ReportRepository;
import com.example.bPrecise.entity.Report;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository reportRepository; 
	
	// Return all employees
	public List<Report> findAll(){
		return reportRepository.findAll();
	}
	
	// Save new employee 
	public Report save (Report report) {
		return reportRepository.save(report);
	}
	
	

}
