package com.qa.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



/* This class will help us for Report gen for our project */

public class ReportUtil extends CommonUtils {

	@BeforeSuite
	public void Suite_StartUp() {
		
		System.out.println("before suite started.....");
		
		report = new ExtentReports();

	//Dynamic report name generation with timestamp
		
		reportName=new SimpleDateFormat("dd-MM-yyy_hh.mm.ss").format(new Date()); //retuns date with time i.e. timestamp

		reporter = new ExtentSparkReporter(
				"C:\\Users\\razda\\eclipse-workspace\\Projects\\Project1\\Reports\\"+reportName+".html");

		report.attachReporter(reporter);

		/* Add environment info that are common to all tests - OS and Java-version */

		report.setSystemInfo("OS", System.getProperty("os.name"));

		report.setSystemInfo("JAVA VERSION", System.getProperty("java.version"));
		System.out.println("Befoe Suite done");

	}

	@BeforeMethod
	public void Method_StartUp(Method m, ITestContext context) {
		System.out.println("before method started.....");
		String methodName = m.getName();
		System.out.println("Method name :" + methodName);

		/* create ExtentTest object for every @Test method */
		test = report.createTest(methodName,m.getAnnotation(Test.class).description());
        
		/*
		 * Assign Group/category to test ...capturing value from groups attribute
		 * of @Test annotation
		 */

		// test.assignCategory();

		String[] strA = m.getAnnotation(Test.class).groups();

		for (int i = 0; i < strA.length; i++) {
			test.assignCategory(strA[i]);
		}

		/* Assign Author and Device value to test */

		test.assignAuthor(context.getCurrentXmlTest().getParameter("author1"));

		test.assignDevice(context.getCurrentXmlTest().getParameter("device1"));
System.out.println("Befoe Method done");
	}

	@AfterMethod
	public void Method_TearDown(ITestResult result) {
		System.out.println("after method started.....");
		if (result.getStatus() == ITestResult.SUCCESS) {

			/* add pass log into extent report file */
			test.pass("Test got passed....!!!!");
		}

		/* Capture ss and add the ss for failed tests into Report at Test Level */
		else if (result.getStatus() == ITestResult.FAILURE) {

			/* Add fail test log */
			test.fail("Test got failed ..!!!!!");

			/* Add ss at Test Level of Extent Report */
			test.addScreenCaptureFromBase64String(CaptureSS());
		}

		else if (result.getStatus() == ITestResult.SKIP) {

			/* add Skip log into extent report file */
			test.skip("Test got skipped !!!!");
		}
		System.out.println("After method done");
	}

	@AfterSuite
	public void Suite_TearDown() throws IOException {
		System.out.println("after suite started.....");
		/* Flush report and gen report file */
		report.flush();

		/* Find gen report and open it as URI */
		Desktop.getDesktop().browse(
				new File("C:\\Users\\razda\\eclipse-workspace\\Projects\\Project1\\Reports\\"+reportName+".html")
						.toURI());
		
		System.out.println("After Suite done");

	}



}
