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

        String browser = ConfigReader.getProperty("browser");
        String headless = ConfigReader.getProperty("headless");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            if (headless.equalsIgnoreCase("true")) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
            }

            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver(options));
        }

        else if (browser.equalsIgnoreCase("edge")) {

            EdgeOptions options = new EdgeOptions();

            if (headless.equalsIgnoreCase("true")) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
            }

            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver(options));
        }

        else if (browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions options = new FirefoxOptions();

            if (headless.equalsIgnoreCase("true")) {
                options.addArguments("--headless");
            }

            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver(options));
        }

        else {
            throw new RuntimeException("Invalid Browser Name");
        }

        driver.get().manage().window().maximize();
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