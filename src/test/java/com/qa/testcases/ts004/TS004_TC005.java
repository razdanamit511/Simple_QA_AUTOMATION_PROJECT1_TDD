package com.qa.testcases.ts004;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.ForgotPasswordPage;
import com.qa.pages.GearPage;
import com.qa.pages.HomePage;
import com.qa.pages.MenPage;
import com.qa.pages.MyAccountPage;
import com.qa.pages.MyWishlistPage;
import com.qa.pages.SalePage;
import com.qa.pages.ShoppingCartPage;
import com.qa.pages.SignInPage;
import com.qa.pages.TrainingsPage;
import com.qa.pages.WhatsNewPage;
import com.qa.pages.WomenPage;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS004_TC005 extends ReportUtil{

	private Logger logger1 = LogManager.getLogger(TS004_TC005.class);

	@Test(description = "Verify that user gets an error message as part of result outcome as follows provided user enters any inappropriate search keyword\r\n"
			+ "\r\n"
			+ "Error message: \"Your search returned no results.\"", groups = { "Smoke", "Sanity" })
	public void TS004_TC005() throws Exception {
		
		/* Create objects of pages you need for execution */
		ForgotPasswordPage forgotpassword = new ForgotPasswordPage(driver);
		SignInPage signpage = new SignInPage(driver);
		MyAccountPage myaccountpage = new MyAccountPage(driver);
		MyWishlistPage mywishlistpage = new MyWishlistPage(driver);
		HomePage homepage = new HomePage(driver);
		WhatsNewPage whatsnewpage = new WhatsNewPage(driver);
		WomenPage womenpage = new WomenPage(driver);
		MenPage menpage = new MenPage(driver);
		GearPage gearpage = new GearPage(driver);
		TrainingsPage trainingpage = new TrainingsPage(driver);
		SalePage salepage = new SalePage(driver);
		ShoppingCartPage shoppingcartpage = new ShoppingCartPage(driver);

		Thread.sleep(3000);

		/* Get test data using XLUtil utility */
		Map<String, String> TestData = XLUtils.getDataForTest("TS004_TC005", "Sheet4");

		/* Test steps */
		driver.manage().window().maximize();

		Thread.sleep(3000);

		/* Step1: User logs into application through signIn page */
		driver.get(TestData.get("TestURL_SignInPage"));
		logger1.info("Launched Sign In page");
		test.info("Launched Sign In page");

		Thread.sleep(3000);

		// Step2: Enter invalid email address in emailID text-box.
		signpage.SetEmail(TestData.get("Username"));
		logger1.info("User enters email value in Email textbox");
		test.info("User enters email value in Email textbox");

		Thread.sleep(3000);

		// Step2: Enter password in Password text-box.
		signpage.SetPassword(TestData.get("Password"));
		logger1.info("User enters valid password value in Password textbox");
		test.info("User enters valid password value in Password textbox");

		Thread.sleep(3000);

		// Step3: User clicks on SignIn button.
		signpage.ClickSignInButton();
		logger1.info("User clicked on SignIn button");
		test.info("User clicked on SignIn button");

		Thread.sleep(3000);

		// User lands on My Account Page after successful login
		Assert.assertEquals(TestData.get("TestURL_MyAccountPage"), driver.getCurrentUrl());
		logger1.info("User lands on My Account page");
		test.info("User lands on My Account page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on MyAccount page
		Assert.assertEquals(myaccountpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on My Account page");
		test.info("Search textbox is displayed on My Account page");

		Thread.sleep(3000);

		myaccountpage.SetSearchTextbox(TestData.get("SearchKeywordInvalid"));
		logger1.info("User enters invalid special char string in Search textbox on My Account page");
		test.info("User enters invalid special char string in Search textbox on My Account page");

		Thread.sleep(3000);


		
	}
	
}
