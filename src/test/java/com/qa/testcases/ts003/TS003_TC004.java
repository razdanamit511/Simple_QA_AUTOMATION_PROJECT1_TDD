package com.qa.testcases.ts003;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.ForgotPasswordPage;
import com.qa.pages.SignInPage;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS003_TC004 extends ReportUtil {
	private Logger logger1 = LogManager.getLogger(TS003_TC004.class);

	@Test(description ="Verify that 'If there is an account associated with <email id> you will receive an email with a link to reset your password.' message is displayed provided user enters valid email address in email address textbox followed by click on Rest my account button", groups = {
			"Functional", "Sanity" })
	public void TS003_TC003() throws Exception {

		/* Create objects of pages you need for execution */
		ForgotPasswordPage forgotpassword = new ForgotPasswordPage(driver);
        SignInPage signpage=new SignInPage(driver);
        
        /* Create object of XLUtil utility to read test data from TestData.xlsx. */
        //Get data of Sheet3
		Map<String, String> TestData_Sheet2 = XLUtils.getDataForTest("TS002_TC004", "Sheet2");

		//Get data of Sheet2
		Map<String, String> TestData_Sheet3 = XLUtils.getDataForTest("TS003_TC004", "Sheet3");
		
		/* Test steps */

		// Step1: Open Forgot Password page
		driver.get(TestData_Sheet3.get("TestURL"));
		logger1.info("Launched Forgot password page");
		test.info("Launched Forgot password page");

		Thread.sleep(3000);

		// Step2: Enter invalid email address in emailID text-box.
		forgotpassword.SetEmailTextbox(TestData_Sheet3.get("Username"));
		logger1.info("User enters valid value in Email textbox");
		test.info("User enters valid value in Email textbox");
		Thread.sleep(3000);

		// Step3: User clicks on Reset My password button.
		forgotpassword.ClickResetMyPasswordButton();
		logger1.info("User clicked on Reset My Password button");
		test.info("User clicked on Reset My Password button");

		Thread.sleep(3000);

		//User lands on SignIn Page
		AssertJUnit.assertEquals("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2luZGV4Lw%2C%2C/", driver.getCurrentUrl());
		logger1.info("User lands on Customer SignIn page");
		test.info("User lands on  Customer SignIn page");
		
		Thread.sleep(3000);
		
		// Step3: Check presence of success message for reset password email input including
		String successMessage = signpage.GetForgotPasswordSuccessMessage();
		AssertJUnit.assertEquals(successMessage, "If there is an account associated with test2t@gmail.com you will receive an email with a link to reset your password.");
		logger1.info("Reset my password success message is displayed");
		test.info("Reset my password success message is displayed");
	}

}
