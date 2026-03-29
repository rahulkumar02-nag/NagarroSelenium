package com.nagarro.automation.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.nagarro.automation.driver.DriverFactory;


public class ScreenshotUtil {
	
	public static String getScreenshot(String testName) {
		WebDriver driver = DriverFactory.getDriver();
		
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String folderPath = System.getProperty("user.dir") + "/reports/screenshots/";
	    
	    File folder = new File(folderPath);
	    if (!folder.exists()) {
	        folder.mkdirs();  
	    }

	    String fullPath = folderPath + testName + "_" + timeStamp + ".png";
	    
        TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
        
        File des = new File(fullPath);
		try {
			FileHandler.copy(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fullPath;
	}

}
