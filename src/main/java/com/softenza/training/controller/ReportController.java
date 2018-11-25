package com.softenza.training.controller;

import java.sql.SQLException;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softenza.training.model.RunReportVO;
import com.softenza.training.service.GenericService;
import com.softenza.training.service.ReportService;


@RestController
@RequestMapping("/service/report")
@CrossOrigin
public class ReportController {

	private static final Logger LOGGER = Logger.getLogger(ReportController.class);

	@Autowired
	GenericService genericService;
	
	@Autowired
	ReportService reportService;
	@Autowired
	ServletContext context;


	@RequestMapping(value = "/printReport", method = RequestMethod.POST, headers = "Accept=application/json")
	public RunReportVO printReport(@RequestBody RunReportVO runReport) throws SQLException {
		String reportName = null;
		if (runReport.getReportId() == null) {
			reportName = this.printReportByName(runReport);
		} 
		RunReportVO report = new RunReportVO();
		report.setReportName(reportName);
		return report;

	}
	
	//@RequestMapping(value = "/printReportByName", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/pdf")
	private String printReportByName(RunReportVO runReport) throws SQLException {
		String reportName = reportService.createReport(runReport);

		return reportName;

	}
}