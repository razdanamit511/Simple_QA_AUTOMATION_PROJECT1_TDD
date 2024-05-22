package com.qa.testcases.ts004;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class TS004_TC004 extends ReportUtil {

	private Logger logger1 = LogManager.getLogger(TS004_TC004.class);

	@Test(description = "Verify that user is able to get products as part of searched results based on the keyword been entered by user in search textbox followed by click on search icon and a label as follows :-\r\n"
			+ "\r\n" + "\"Search results for: '<entered keyword>'\"", groups = { "Functional", "Sanity" })
	public void TS004_TC004() throws Exception {

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
		Map<String, String> TestData = XLUtils.getDataForTest("TS004_TC004", "Sheet4");

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

		myaccountpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
		logger1.info("User enters valid search keyword in Search textbox on My Account page");
		test.info("User enters valid search keyword in Search textbox on My Account page");

		Thread.sleep(3000);

		myaccountpage.ClickSearchIconSearchTextbox();
		logger1.info("User clicked on Search icon");
		test.info("User clicked on Search icon");

		Thread.sleep(3000);

		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='maincontent']/div[1]/h1/span")).isDisplayed(), true);
		logger1.info("Search results label got displayed");
		test.info("Search results label got displayed");

		Thread.sleep(3000);

		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).isDisplayed(),
				true);
		logger1.info("Search results label got displayed");
		test.info("Search results label got displayed");

		int numElements = 0;
		List<WebElement> listElements = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements.size(); i++) {

			System.out.println("Link text :" + listElements.get(i).getText());
			if (listElements.get(i).getText().endsWith("Jacket")) {
				numElements=numElements+1;
			}
		}

		Assert.assertEquals(numElements, 12);
		logger1.info("Elements dispalyed with Jacket in their names");
		test.info("Elements dispalyed with Jacket in their names");

	}

}

