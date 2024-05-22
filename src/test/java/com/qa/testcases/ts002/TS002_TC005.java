package com.qa.testcases.ts002;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.SignInPage;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS002_TC005 extends ReportUtil {

	private static Logger logger1 = LogManager.getLogger(TS002_TC005.class);

	@Test(description = "Verify that user is able to Sign in successfully provided user enters correct username and password in username and password textboxes followed by click on Sign In button", groups = {
			"Sanity", "Functional" })
	public void TS002_TC005() throws Exception {

		driver.manage().window().maximize();

		// Creation of Page class object for all pages that u need for execution.
		SignInPage signin = new SignInPage(driver);

		// Call XLUtil class method to fetch test data we need for execution.
		Map<String, String> TestData = XLUtils.getDataForTest("TS002_TC005", "Sheet2");

		Thread.sleep(3000);
		// Step1: Open Sign in page
		driver.get(TestData.get("TestURL"));
		logger1.info("Launched Sign IN page");
		test.info("Launched Sign IN page");

		Thread.sleep(3000);

		// Step1:set value in Email text box
		signin.SetEmail(TestData.get("Username"));
		logger1.info("User enters username in Email textbox");
		test.info("User enters username in Email textbox");

		Thread.sleep(3000);
		// Step2: Set value in Password text box
		signin.SetPassword(TestData.get("Password"));
		logger1.info("User  enters Password in Password textbox");
		test.info("User  enters Password in Password textbox");

		Thread.sleep(3000);

		// Step3: Click on SignIn button
		signin.ClickSignInButton();

		Thread.sleep(3000);
		logger1.info("User clicked on SignIn button");
		test.info("User clicked on SignIn button");
		
		// Step4: User lands on My Account web page.
		Assert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/");
		logger1.info("User landed on Home page after successful login");
		test.info("User landed on Home page after successful login");

	}

}
