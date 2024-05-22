package com.qa.testcases.ts001;

import java.time.Duration;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.CreateAnAccountPage;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS001_TC004 extends ReportUtil {

	private static Logger logger1 = LogManager.getLogger(TS001_TC004.class);

	@Test(description = "Verify that entering blank spaces on mandatory fields lead to validation error", groups = {
			"Functional", "Smoke" })
	public void TS001_TC004() throws Exception {

		driver.manage().window().maximize();

		Thread.sleep(Duration.ofMillis(2000));

		// Creation of Page class object.
		CreateAnAccountPage CreateAccount = new CreateAnAccountPage(driver);

		// Get test data for current test case from TestData.xlsx using XLUtil
		Map<String, String> TestData = XLUtils.getDataForTest("TS001_TC004", "Sheet1");

		/* TEST STEPS */
		// Step1: Open Create an account page
		driver.get(TestData.get("TestURL"));
		logger1.info("Create an account page launched.....");
		test.info("Create Account page got open");

		Thread.sleep(3000);

		Thread.sleep(3000);

		// Step3: Enter Blank space in Confirm Password text-box
		CreateAccount.SetFirstNameTextbox(" ");
		logger1.info("Entererd Blankspace in First name textbox");
		test.info("Entererd Blankspace in First name textbox");

		Thread.sleep(3000);

		// Step3: Enter Blank space in Confirm Password text-box
		CreateAccount.SetLastNameTextbox(" ");
		logger1.info("Entererd Blankspace in Last name textbox");
		test.info("Entererd Blankspace in Last name textbox");

		Thread.sleep(2000);
		
		// Step2: Enter Blank space in Email text-box
		CreateAccount.SetEmailTextbox(" ");
		logger1.info("Entererd Blankspace in Email textbox");
		test.info("Entererd Blankspace in Email textbox");

		Thread.sleep(3000);
		// Step3: Enter Blank space in Password text-box
		CreateAccount.SetPasswordTextbox(" ");
		logger1.info("Entererd Blankspace in Password textbox");
		test.info("Entererd Blankspace in Password textbox");

		Thread.sleep(3000);

		// Step3: Enter Blank space in Confirm Password text-box
		CreateAccount.SetConfirmPasswordTextbox(" ");
		logger1.info("Entererd Blankspace in Confirm Password textbox");
		test.info("Entererd Blankspace in Confirm Password textbox");

		Thread.sleep(5000);

		// Step1: Check presence of Password text-box
		CreateAccount.ClickCreateAnAccountButton();
		logger1.info("User clicks on Create an Account button on Create an account page");
		test.info("Password textbox is present of on Create an account page");

		Thread.sleep(3000);

		/* Check warning messages for all mandatory text-boxes */

		// Step5: Check presence of "Warning message" under Email text-box
		Assert.assertTrue(CreateAccount.CheckPresenceOfMandatoryErrorEmail());
		logger1.info("User got Mandatory error message for Email textbox on Create an account page");
		test.info("User got Mandatory error message for Email textbox on Create an account page");

		Thread.sleep(3000);
		// Step6: Check presence of Password Warning placeholder under Password text-box
		// Step5: Check presence of "Warning message" under Email text-box
		Assert.assertTrue(CreateAccount.CheckPresenceOfMandatoryErrorPassword());
		logger1.info("User got Mandatory error message for Password textbox on Create an account page");
		test.info("User got Mandatory error message for Password textbox on Create an account page");

		Thread.sleep(3000);
		// Step5: Check presence of "Warning message" under Email text-box
		Assert.assertTrue(CreateAccount.CheckPresenceOfMandatoryErrorFirstName());
		logger1.info("User got Mandatory error message for First Name textbox on Create an account page");
		test.info("User got Mandatory error message for First Name textbox on Create an account page");

		Thread.sleep(3000);
		// Step5: Check presence of "Warning message" under Email text-box
		Assert.assertTrue(CreateAccount.CheckPresenceOfMandatoryErrorLastName());
		logger1.info("User got Mandatory error message for First Name textbox on Create an account page");
		test.info("User got Mandatory error message for First Name textbox on Create an account page");

		Thread.sleep(3000);

		// Step5: Check presence of "Warning message" under Confirm password text-box
		Assert.assertTrue(CreateAccount.CheckPresenceOfMandatoryErrorConfirmPass());
		logger1.info("User got Mandatory error message for Confirm password textbox on Create an account page");
		test.info("User got Mandatory error message for Confirm password  textbox on Create an account page");

	}

}
