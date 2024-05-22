package com.qa.testcases.ts002;

import java.time.Duration;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.SignInPage;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS002_TC001 extends ReportUtil {

	private static Logger logger1 = LogManager.getLogger(TS002_TC001.class);

	@Test(description = "Verify that the Sign In form contains fields as per requirement 2", groups = { "Regression",
			"Smoke" })
	public void TS002_TC001() throws Exception {

		logger1 = Logger.getLogger(TS002_TC001.class);

		driver.manage().window().maximize();

		Thread.sleep(Duration.ofMillis(2000));

		/*  Creation of Page class object.  */
		SignInPage signin = new SignInPage(driver);
		
		
		//Fetch test data from TestData.xlsx using XLUtil utility.
		Map<String, String> TestData=XLUtils.getDataForTest("TS002_TC001", "Sheet2");
		
		//Step1: Open Signin page
		driver.get(TestData.get("TestURL"));
		logger1.info("Launched Sign IN page");
		test.info("Launched Sign IN page");

		// Step1: Check presence of Email label
		String actualEmailLabel = signin.GetEmailLabel();
		Assert.assertEquals(actualEmailLabel, "Email");
		logger1.info("Fetched email label is same as expected");
		test.info("Email label is present on sign In page");

		// Step2: Check presence of Email label
		String actualPasswordLabel = signin.GetPasswordLabel();
		Assert.assertEquals(actualPasswordLabel, "Password");
		logger1.info("Fetched Password label is same as expected");
		test.info("Password label is present on sign In page");

		// Step3: Check presence of Email textbox
		boolean resEmailTextbox = signin.CheckEmailTextboxPresence();
		Assert.assertTrue(resEmailTextbox);
		logger1.info("Email textbox is present of on signin page");
		test.info("Email Textbox is present on sign In page");

		// Step4: Check presence of Email label
		boolean resPasswordTextbox = signin.CheckPasswordTextboxPresence();
		Assert.assertTrue(resPasswordTextbox);
		logger1.info("Password textbox is present of on signin page");
		test.info("Password Textbox is present on sign In page");

		// Step5: Check presence of SignIn button
		boolean resSignInButton = signin.CheckSignInButtonPresence();
		Assert.assertTrue(resSignInButton);
		logger1.info("SignIn textbox is present of on signin page");
		test.info("SignIn Button is present on sign In page");
		
		// Step5: Check presence of Logout hyperlink
		boolean resLogoutHyperlink = signin.CheckLogoutHypelinkPresence();
		Assert.assertTrue(resLogoutHyperlink);
		logger1.info("Logout hyperlink is present of on signin page");
		test.info("Logout hyperlink is present of on signin page");
	}

}
