package com.nagarro.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.nagarro.automation.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

    	String browser = System.getProperty("browser");
    	if (browser == null || browser.isEmpty()) {
    	    browser = ConfigReader.getProperty("browser");
    	}
    	if (browser == null || browser.isEmpty()) {
    	    browser = "chrome";
    	}
    	
    	String headless = System.getProperty("headless");
    	if (headless == null || headless.isEmpty()) {
    	    headless = ConfigReader.getProperty("headless");
    	}
    	if (headless == null || headless.isEmpty()) {
    	    headless = "true";
    	}
    	
    	if ("chrome".equalsIgnoreCase(browser)) {

            ChromeOptions options = new ChromeOptions();

            if ("true".equalsIgnoreCase(headless)) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
            }
            
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver(options));
        }

        else if ("edge".equalsIgnoreCase(browser)) {

            EdgeOptions options = new EdgeOptions();

            if ("true".equalsIgnoreCase(headless)) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
            }

            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver(options));
        }

        else if ("firefox".equalsIgnoreCase(browser)) {

            FirefoxOptions options = new FirefoxOptions();

            if ("true".equalsIgnoreCase(headless)) {
                options.addArguments("--headless");
            }

            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver(options));
        }

        else {
            throw new RuntimeException("Invalid Browser Name");
        }

        if (!headless.equalsIgnoreCase("true")) {
            driver.get().manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}