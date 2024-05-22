package com.qa.testcases.ts003;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.ForgotPasswordPage;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS003_TC002 extends ReportUtil{
	
	private Logger logger1 = LogManager.getLogger(TS003_TC002.class);
	
	@Test(description = "Verify that 'Required field' error message is displayed under all Mandatory fields provded user clicks on 'Reset my password' button without entering any value in Mandatory field textbox.", groups = {"Smoke","Sanity","Functional"})
	public void TS003_TC002() throws Exception {
		
		driver.manage().window().maximize();

		// Creation of Page class object for all pages that u need for execution.
		ForgotPasswordPage ForgotPassword = new ForgotPasswordPage(driver);

		// Call XLUtil class method to fetch test data we need for execution.
		Map<String, String> TestData = XLUtils.getDataForTest("TS003_TC002", "Sheet3");

		Thread.sleep(3000);
		
		// Step1: Open Sign in page
		driver.get(TestData.get("TestURL"));
		logger1.info("Launched Forgot password page");
		test.info("Launched Forgot password page");

		Thread.sleep(3000);
		
		//Step2: User clicks on "Reset my password" button.
		ForgotPassword.ClickResetMyPasswordButton();
		logger1.info("Clicked Forgot Password button");
		test.info("Clicked Forgot Password button");
		
		Thread.sleep(3000);
		
		//Step3: User checks presence of "This is a required field." message for Email text box.
		Assert.assertEquals(ForgotPassword.CheckPresenceErrorMessage(), true);
		logger1.info("Mandatory message displayed for mandatory email textbox.");
		test.info("Mandatory message displayed for mandatory email textbox.");

		
	}
	

}
