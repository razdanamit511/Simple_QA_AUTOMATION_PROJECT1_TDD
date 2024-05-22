package com.qa.testcases.ts001;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.qa.pages.CreateAnAccountPage;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS001_TC003 extends ReportUtil{

	private static Logger logger1 = LogManager.getLogger(TS001_TC002.class);

	@Test(description = "Verify that system generates a validation message when clicking on submit button without filling all the mandatory fields.", groups = {
			"Regression", "Smoke" })
	public void TS001_TC003() throws Exception {
		driver.manage().window().maximize();

		Thread.sleep(Duration.ofMillis(2000));

		// Creation of Page class object.
		CreateAnAccountPage CreateAccount = new CreateAnAccountPage(driver);

		// Get test data for current test case from TestData.xlsx using XLUtil
		Map<String, String> TestData = XLUtils.getDataForTest("TS001_TC003", "Sheet1");

		driver.get(TestData.get("TestURL"));
		logger1.info("Create an account page launched.....");
		test.info("Create Account page got open");

		// Step1: Check presence of Password text-box
		CreateAccount.ClickCreateAnAccountButton();
		logger1.info("User clicks on Create an Account button on Create an account page");
		test.info("Password textbox is present of on Create an account page");

		// Step5: Check presence of "Warning message" under Email textbox
		Assert.assertTrue(CreateAccount.CheckPresenceOfMandatoryErrorEmail());
		logger1.info("User gets Mandatory error message for Email textbox on Create an account page");
		test.info("User gets Mandatory error message for Email textbox on Create an account page");

		// Step6: Check presence of Password Warning placeholder under Password text-box
		// Step5: Check presence of "Warning message" under Email textbox
		Assert.assertTrue(CreateAccount.CheckPresenceOfMandatoryErrorPassword());
		logger1.info("User gets Mandatory error message for Password textbox on Create an account page");
		test.info("User gets Mandatory error message for Password textbox on Create an account page");

		// Step5: Check presence of "Warning message" under Email textbox
		Assert.assertTrue(CreateAccount.CheckPresenceOfMandatoryErrorFirstName());
		logger1.info("User gets Mandatory error message for First Name textbox on Create an account page");
		test.info("User gets Mandatory error message for First Name textbox on Create an account page");

		
		// Step5: Check presence of "Warning message" under Email textbox
		Assert.assertTrue(CreateAccount.CheckPresenceOfMandatoryErrorLastName());
		logger1.info("User gets Mandatory error message for First Name textbox on Create an account page");
		test.info("User gets Mandatory error message for First Name textbox on Create an account page");

		
		// Step5: Check presence of "Warning message" under Confirm password textbox
		Assert.assertTrue(CreateAccount.CheckPresenceOfMandatoryErrorConfirmPass());
		logger1.info("User gets Mandatory error message for Confirm password textbox on Create an account page");
		test.info("User gets Mandatory error message for  Confirm password  textbox on Create an account page");

		
	}

}
