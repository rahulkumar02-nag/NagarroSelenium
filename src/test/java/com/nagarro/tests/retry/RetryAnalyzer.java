package com.nagarro.tests.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.nagarro.automation.utils.ConfigReader;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private int maxRetry;

    public RetryAnalyzer() {
        // Read from config file
        try {
            maxRetry = Integer.parseInt(ConfigReader.getProperty("retryCount"));
        } catch (Exception e) {
            maxRetry = 2; // default fallback
        }
    }

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxRetry) {
            count++;

            System.out.println("Retrying Test: " + result.getName() 
                + " | Attempt: " + count);

            return true;
        }

        return false;
    }
}