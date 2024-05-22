package com.qa.testcases.ts003;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.ForgotPasswordPage;
import com.qa.pages.SignInPage;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS003_TC003 extends ReportUtil{

	private Logger logger1=LogManager.getLogger(TS003_TC003.class);
	
	@Test(description = "Verify that \"Please enter a valid email address (Ex: johndoe@domain.com).\" error message is displayed under Email textbox provided user enters Invalid email address in email textbox and clicks on SignIn button", groups = {"Functional","Smoke"})
	public void TS003_TC003() throws Exception {
             
		/*   Create objects of pages you need for execution   */
		ForgotPasswordPage forgotpassword=new ForgotPasswordPage(driver);
		
		/* Create object of XLUtil utility to read test data from TestData.xlsx. */
		Map<String, String>  TestData=XLUtils.getDataForTest("TS003_TC003", "Sheet3");
		
		/*                    Test steps               */
		
		//Step1: Open Forgot Password page
		driver.get(TestData.get("TestURL"));
		logger1.info("Launched Forgot password page");
		test.info("Launched Forgot password page");
		
		Thread.sleep(3000);
		
		//Step2: Enter invalid email address in emailID text-box.
		forgotpassword.SetEmailTextbox(TestData.get("Username"));
		logger1.info("User enters invalid value in Email textbox");
		test.info("User enters invalid value in Email textbox");
		Thread.sleep(3000);
		
		//Step3: User clicks on Reset My password button.
		forgotpassword.ClickResetMyPasswordButton();
		logger1.info("User clicked on Reset My Password button");
		test.info("User clicked on Reset My Password button");
		
		Thread.sleep(3000);
		
		//Step3: Check presence of error message for invalid email input including error message text
		String errorVal=forgotpassword.CheckErrorMessageValueEmailTextbox();
		Assert.assertEquals(errorVal, "Please enter a valid email address (Ex: johndoe@domain.com).");
		logger1.info("Error messaged displayed for invalid value in Email textbox.");
		test.info("Error messaged displayed for invalid value in Email textbox.");
	}
	
	
}
