package com.qa.base;


import com.qa.util.ReadConfig;

import org.apache.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

	public static WebDriver driver;
	private static Logger logger1 = LogManager.getLogger(BaseTest.class);

	/* Creation of ExtentReports object */
	public static ExtentReports report;

	/* Creation of ExtentReporter object */
	public static ExtentSparkReporter reporter;

	/* Creation of ExtentTest object */
	public static ExtentTest test;

	public static String reportName;

	public static ReadConfig config = new ReadConfig();

	@Parameters("browser")
	@BeforeClass()
	public void setup(String str) throws Exception {
		System.out.println("Before class startted.....");

		String baseurl = config.getApplicationUrl();

		switch (str) {
		case "chrome":
			driver = new ChromeDriver();
			logger1.info("Chrome driver got initialized");
			// Launch base URL
			driver.get(baseurl);
			logger1.info("Home URL got open successfully.");
			break;
		case "edge":
			driver = new EdgeDriver();
			// Launch base URL

			logger1.info("Edge driver got initialized");
			// Launch base URL
			driver.get(baseurl);
			logger1.info("Home URL got open successfully.");
			break;
		case "firefox":
			driver = new FirefoxDriver();
			logger1.info("firefox driver got initialized");
			// Launch base URL
			driver.get(baseurl);
			logger1.info("Home URL got open successfully.");
			break;
		default:
			System.out.println("Wrong input for browser name");
			break;
		}

	}

	@AfterClass
	public void tearDown() {
		System.out.println("after class startted.....");

		driver.quit();
		logger1.info("driver quitted successfully.....");
	}

}
