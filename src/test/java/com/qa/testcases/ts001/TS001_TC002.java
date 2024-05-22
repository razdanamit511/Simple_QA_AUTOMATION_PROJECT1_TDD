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

public class TS001_TC002 extends ReportUtil{

	private static Logger logger1 = LogManager.getLogger(TS001_TC002.class);

	@Test(description = "Verify presence of valid placeholder under Password label Testbox 'Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.'", groups = { "Regression",
			"Sanity" })
	public void TS001_TC002() throws Exception {

		driver.manage().window().maximize();

		Thread.sleep(Duration.ofMillis(2000));

		// Creation of Page class object.
		CreateAnAccountPage CreateAccount = new CreateAnAccountPage(driver);
		
		
		// Get test data for current test case from TestData.xlsx using XLUtil
		Map<String, String> TestData=XLUtils.getDataForTest("TS001_TC002", "Sheet1");
		
		driver.get(TestData.get("TestURL"));
		logger1.info("Create an account page launched.....");
		test.info("Create Account page got open");

		// Step1: Check presence of Password text-box

		Assert.assertTrue(CreateAccount.CheckPasswordTextboxPresence());
		logger1.info("Password textbox is present of on Create an account page");
		test.info("Password textbox is present of on Create an account page");

		// Step5: Check presence of CreateAnAccount button
        CreateAccount.SetPasswordTextbox(TestData.get("Password"));
		logger1.info("User enters demo string in Password textbox on Create an account page");
		test.info("User enters demo string in Password textbox on Create an account page");
		
		// Step6: Check presence of Password Warning placeholder under Password text-box
        Assert.assertEquals(CreateAccount.GetPasswordWarningPlaceholder(), "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.");
		logger1.info("Password warning placeholder appeared on Create an account page");
		test.info("Password warning placeholder appeared of on Create an account page");
	}

}
