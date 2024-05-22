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

public class TS003_TC001 extends ReportUtil {

	private Logger logger1 = LogManager.getLogger(TS003_TC002.class);
   
	@Test(description = "Verify that user gets below mentioned labels/Fields on \"Forgot Password' webpage : -\r\n"
			+ "\r\n" + "Labels: -\r\n" + "\"Forgot Password\"\r\n"
			+ "\"Please enter your email address below to receive a password reset link.\"\r\n"
			+ "'Email\" ( with *)\r\n" + "\"Required * fields\"\r\n" + "\r\n" + "Buttons: -\r\n"
			+ "\"Reset my Password\"", groups = { "Regression", "Smoke" })
	public void TS003_TC001() throws Exception {

		driver.manage().window().maximize();

		// Creation of Page class object for all pages that u need for execution.
		ForgotPasswordPage ForgotPassword = new ForgotPasswordPage(driver);

		// Call XLUtil class method to fetch test data we need for execution.
		Map<String, String> TestData = XLUtils.getDataForTest("TS003_TC001", "Sheet3");

		Thread.sleep(3000);

		// Step1: Open Sign in page
		driver.get(TestData.get("TestURL"));
		logger1.info("Launched Forgot password page");
		test.info("Launched Forgot password page");

		Thread.sleep(3000);

		// Step2: Check ForgotPassword label
		Assert.assertEquals(ForgotPassword.CheckPresenceForgotPasswordLabel(), true);
		logger1.info("Forgot password label is present on Forgot Password page.");
		test.info("Forgot password label is present on Forgot Password page.");

		Thread.sleep(3000);

		// Step3: Check Info message label
		Assert.assertEquals(ForgotPassword.CheckPresenceInfoMessage(), true);
		logger1.info("Info message is present on Forgot Password page.");
		test.info("Info message is present on Forgot Password page.");

		Thread.sleep(3000);

		// Step4: Check Email label
		Assert.assertEquals(ForgotPassword.CheckPresenceEmailLabel(), true);
		logger1.info("Email label is present on Forgot Password page.");
		test.info("Email label is present on Forgot Password page.");

		Thread.sleep(3000);

		// Step5: Check Email Text box
		Assert.assertEquals(ForgotPassword.CheckPresenceEmailTextbox(), true);
		logger1.info("Email textbox is present on Forgot Password page.");
		test.info("Email textbox is present on Forgot Password page.");

		// Step6: Check Reset My Password button
		Assert.assertEquals(ForgotPassword.CheckPresenceResetMyPasswordButton(), true);
		logger1.info("Reset My Password button is present on Forgot Password page.");
		test.info("Reset My Password button is present on Forgot Password page.");

	}

}
