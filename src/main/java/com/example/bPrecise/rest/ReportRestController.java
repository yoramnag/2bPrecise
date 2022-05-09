package com.example.bPrecise.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bPrecise.entity.Report;
import com.example.bPrecise.service.ReportService;

@RestController
@RequestMapping("/api")
public class ReportRestController {
	
	@Autowired
	private ReportService reportService;
	
	// expose "/report" and return list of reports
	@GetMapping("/report")
	public List<Report> retrieveAllReports() {
		return reportService.findAll();
	}
	
	

}
