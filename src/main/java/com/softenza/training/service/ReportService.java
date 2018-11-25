package com.softenza.training.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;


@Service(value="reportService")
public interface ReportService {
	
	public String createReport(Long userId, Short role, String reportName) throws SQLException;
}
