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

public class TS002_TC002 extends ReportUtil {

	private static Logger logger1 = LogManager.getLogger(TS002_TC002.class);

	@Test(description = "Verify that user gets an error message as \"This is required\" under \"Email' textbox provided enters valid value in password textbox leaving email textbox as blank followed by click on Sign In button", groups = {
			"Smoke", "Sanity" })
	public void TS002_TC002() throws Exception {

		driver.manage().window().maximize();

		// Creation of Page class object for all pages that u need for execution.
		SignInPage signin = new SignInPage(driver);

		// Call XLUtil class method to fetch test data we need for execution.
		Map<String, String> TestData = XLUtils.getDataForTest("TS002_TC002", "Sheet2");

		
		Thread.sleep(3000);
		// Step1: Open Signin page
		driver.get(TestData.get("TestURL"));
		logger1.info("Launched Sign IN page");
		test.info("Launched Sign IN page");

		Thread.sleep(3000);
		
		// Step1:set value in Email text box
		signin.SetEmail(TestData.get("Username"));
		logger1.info("User do not enters username value");
		test.info("User do not enters username value");

		
		Thread.sleep(3000);
		// Step2: Set value in Password text box
		signin.SetPassword(TestData.get("Password"));
		logger1.info("User entered password value");
		test.info("User entered password value");

		Thread.sleep(3000);
		
		// Step3: Check presence of Email text box
		signin.ClickSignInButton();
		logger1.info("User clicked on signin button");
		test.info("User clicked on signin button");

		
		Thread.sleep(5000);
		
		Assert.assertEquals(true, driver.findElement(By.xpath("//*[@id='email-error']")).isDisplayed());
		test.info("error message got displayed for email textbox");
	}

}
