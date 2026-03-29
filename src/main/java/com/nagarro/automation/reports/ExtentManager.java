package com.nagarro.automation.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	/*
	 * We need to create these 4 utils for complete Extent Report:
	 * 
	 * 1. ExtentManager (create report) 
	 * 2. ExtentTestManager (ThreadLocal test) 
	 * 3. Listener using ExtentReport 
	 * 4. Screenshot attach
	 * 
	 */
	
	public static ExtentReports getExtentReport() {

		if (extent == null) {

			String reportPath = System.getProperty("user.dir") 
			        + "/reports/ExtentReport_" + System.currentTimeMillis() + ".html";

			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
			reporter.config().setReportName("Automation Report");
			reporter.config().setDocumentTitle("Selenium Hybrid Framework");
			reporter.config().setTimeStampFormat("dd-MM-yyyy");

			extent = new ExtentReports();
			extent.attachReporter(reporter);

			extent.setSystemInfo("Tester", "Rahul");
			extent.setSystemInfo("Env", "QA");
			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("Browser", "Chrome");

		}
		return extent;

	}

	public static ExtentReports getInstance() {
	    return getExtentReport();
	}

}
