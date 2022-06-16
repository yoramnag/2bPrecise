package com.example.bPrecise.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.bPrecise.dao.ReportRepository;
import com.example.bPrecise.entity.Report;

@DataJpaTest
public class ReportRepositoryTest {
	
	@Autowired
	private ReportRepository reportRepository;
	
	@Test
	public void testFindAllManagers() {
		List<Report> report = reportRepository.findAll();
		assertEquals(2,report.size());
	}
	
	@Test
	public void testFindOne() {
		Report report = reportRepository.findById(30001).get();
		assertEquals("report 1",report.getText());
		assertEquals(20001,report.getEmployee().getId());
	}

}
