package com.nagarro.tests.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.nagarro.automation.reports.ExtentTestManager;
import com.nagarro.automation.utils.ScreenshotUtil;


public class TestListener implements ITestListener {

	private static ExtentReports extent = com.nagarro.automation.reports.ExtentManager.getInstance();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getName());
		ExtentTestManager.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

	    String path = ScreenshotUtil.getScreenshot(result.getName());

	    ExtentTestManager.getTest().fail(result.getThrowable());

	    try {
	        ExtentTestManager.getTest().fail("Screenshot",
	            MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip(result.getThrowable());
    }

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
