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

public class TS001_TC001 extends ReportUtil {

	private static Logger logger1 = LogManager.getLogger(TS001_TC001.class); // We have to add this statememt for every
																				// class whose logs we want to record.

	@Test(description = "Verify that the Create an Account form contains fields as per req 1", groups = { "Sanity",
			"Smoke" })
	public void TS001_TC001() throws Exception {

		driver.manage().window().maximize();

		Thread.sleep(Duration.ofMillis(2000));

		// Creation of Page class object.
		CreateAnAccountPage CreateAccount = new CreateAnAccountPage(driver);

		// Get test data for current test case from TestData.xlsx using XLUtil
		Map<String, String> TestData_TS001_TC001 = XLUtils.getDataForTest("TS001_TC001", "Sheet1");

		driver.get(TestData_TS001_TC001.get("TestURL"));
		test.info("Create Account page got open");

		// Step1: Check presence of Email label
		Assert.assertEquals(CreateAccount.GetEmailLabel(), "Email");
		logger1.info("Email label is present on Create an Account page");
		test.info("Email label is present on Create an Account page");

		// Step2: Check presence of Password label
		Assert.assertEquals(CreateAccount.GetPasswordLabel(), "Password");
		logger1.info("Password label is present on Create an Account page");
		test.info("Password label is present on Create an Account page");

		// Step4: Check presence of Email text-box

		Assert.assertTrue(CreateAccount.CheckEmailTextboxPresence());
		logger1.info("Email textbox is present of on Create an account page");
		test.info("Email textbox is present of on Create an account page");

		// Step4: Check presence of Password text-box

		Assert.assertTrue(CreateAccount.CheckPasswordTextboxPresence());
		logger1.info("Password textbox is present of on Create an account page");
		test.info("Password textbox is present of on Create an account page");

		// Step5: Check presence of CreateAnAccount button

		Assert.assertTrue(CreateAccount.CheckCreateAnAccountButtonPresence());
		logger1.info("Create An Account button is present of on Create an account page");
		test.info("Create An Account button is present of on Create an account page");
	}
}
