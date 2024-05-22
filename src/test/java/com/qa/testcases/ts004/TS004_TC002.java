package com.qa.testcases.ts004;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
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

public class TS004_TC002 extends ReportUtil {

	private Logger logger1 = LogManager.getLogger(TS004_TC002.class);

	@Test(description = "Verify that the search textbox is empty and enabled by default with search icon disabled by default", groups = {
			"Regression", "Sanity" })
	public void TS004_TC002() throws Exception {

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
		
		/* Create object of XLUtil utility to read test data from TestData.xlsx. */
		// Get data of Sheet4
		Map<String, String> TestData_Sheet4 = XLUtils.getDataForTest("TS004_TC002", "Sheet4");

		/* Test steps */
		System.out.println("We rechieved till here");

		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		/* Step1: User logs into application through signIn page */
		driver.get(TestData_Sheet4.get("TestURL_SignInPage"));
		logger1.info("Launched Sign In page");
		test.info("Launched Sign In page");

		Thread.sleep(3000);

		// Step2: Enter invalid email address in emailID text-box.
		signpage.SetEmail(TestData_Sheet4.get("Username"));
		logger1.info("User enters email value in Email textbox");
		test.info("User enters email value in Email textbox");

		Thread.sleep(3000);

		// Step2: Enter password in Password text-box.
		signpage.SetPassword(TestData_Sheet4.get("Password"));
		logger1.info("User enters valid password value in Password textbox");
		test.info("User enters valid password value in Password textbox");

		Thread.sleep(3000);

		// Step3: User clicks on SignIn button.
		signpage.ClickSignInButton();
		logger1.info("User clicked on SignIn button");
		test.info("User clicked on SignIn button");

		Thread.sleep(3000);

		// User lands on My Account Page after successful login
		Assert.assertEquals(TestData_Sheet4.get("TestURL_MyAccountPage"), driver.getCurrentUrl());
		logger1.info("User lands on My Account page");
		test.info("User lands on My Account page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on MyAccount page
		Assert.assertEquals(myaccountpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on My Account page");
		test.info("Search textbox is displayed on My Account page");

		Thread.sleep(3000);
  
		
		/* New validation for TS004_TC002 */
		Assert.assertEquals(myaccountpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(myaccountpage.GetStateSearchIconSearchTextbox (), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");

		Thread.sleep(3000);

		// Step3: User navigates to MyWishList page.
		driver.navigate().to(TestData_Sheet4.get("TestURL_MyWishListPage"));
		logger1.info("User navigates to MyWishList page");
		test.info("User navigates to MyWishList page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on MyWishlist page
		Assert.assertEquals(mywishlistpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on My Wishlist page");
		test.info("Search textbox is displayed on My Wishlist page");

		/* New validation for TS004_TC002 */
		Assert.assertEquals(myaccountpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(myaccountpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");

		Thread.sleep(3000);

		// Step3: User navigates to Home page.
		driver.navigate().to(TestData_Sheet4.get("TestURL_HomePage"));
		logger1.info("User navigates to Home page");
		test.info("User navigates to Home page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Home page
		Assert.assertEquals(homepage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Home page");
		test.info("Search textbox is displayed on Home page");

		Thread.sleep(3000);

		/* New validation for TS004_TC002 */
		Assert.assertEquals(myaccountpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(myaccountpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");

		// Step3: User navigates to What's New page.
		driver.navigate().to(TestData_Sheet4.get("TestURL_WhatsNewPage"));
		logger1.info("User navigates to Whats New page");
		test.info("User navigates to Whats New page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on What's New page
		Assert.assertEquals(whatsnewpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on What's New page");
		test.info("Search textbox is displayed on What's New page");

		Thread.sleep(3000);

		/* New validation for TS004_TC002 */
		Assert.assertEquals(myaccountpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(myaccountpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");
		
		
		Thread.sleep(3000);

		// Step3: User navigates to Women page.
		driver.navigate().to(TestData_Sheet4.get("TestURL_WomenPage"));
		logger1.info("User navigates to Womens page");
		test.info("User navigates to Womens page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Women page
		Assert.assertEquals(womenpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Women page");
		test.info("Search textbox is displayed on Women page");

		Thread.sleep(3000);

		/* New validation for TS004_TC002 */
		Assert.assertEquals(myaccountpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(myaccountpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");

		Thread.sleep(3000);

		// Step3: User navigates to Men page.
		driver.navigate().to(TestData_Sheet4.get("TestURL_MenPage"));
		logger1.info("User navigates to Mens page");
		test.info("User navigates to Mens page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Mens page
		Assert.assertEquals(menpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Mens page");
		test.info("Search textbox is displayed on Mens page");

		Thread.sleep(3000);

		/* New validation for TS004_TC002 */
		Assert.assertEquals(myaccountpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(myaccountpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");
		
		Thread.sleep(3000);

		// Step3: User navigates to Gear page.
		driver.navigate().to(TestData_Sheet4.get("TestURL_GearPage"));
		logger1.info("User navigates to Gear page");
		test.info("User navigates to Gear page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Gear page
		Assert.assertEquals(gearpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Gear page");
		test.info("Search textbox is displayed on Gear page");

		Thread.sleep(3000);

		/* New validation for TS004_TC002 */
		Assert.assertEquals(myaccountpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(myaccountpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");
		

		Thread.sleep(3000);

		// Step3: User navigates to Trainings page.
		driver.navigate().to(TestData_Sheet4.get("TestURL_TrainingsPage"));
		logger1.info("User navigates to Trainings page");
		test.info("User navigates to Trainings page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Trainings page
		Assert.assertEquals(trainingpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Trainings page");
		test.info("Search textbox is displayed on Trainings page");

		Thread.sleep(3000);

		/* New validation for TS004_TC002 */
		Assert.assertEquals(myaccountpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(myaccountpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");

		Thread.sleep(3000);

		// Step3: User navigates to Sale page.
		driver.navigate().to(TestData_Sheet4.get("TestURL_SalePage"));
		logger1.info("User navigates to Sale page");
		test.info("User navigates to Sale page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Sale page
		Assert.assertEquals(salepage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Sale page");
		test.info("Search textbox is displayed on Sale page");

		Thread.sleep(3000);
		
		/* New validation for TS004_TC002 */
		Assert.assertEquals(myaccountpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(myaccountpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");
		
		
		Thread.sleep(3000);	
		
		
		/*
		 * User adds any element from What's New page in order to make traversal to cart
		 * possible
		 */

		// Navigate to What's New Page
		driver.navigate().to(TestData_Sheet4.get("TestURL_WhatsNewPage"));
		logger1.info("User navigates to What's New page");
		test.info("User navigates to What's New page");

		Thread.sleep(3000);

		// Hover cursor over element 1
		whatsnewpage.HoverOverElement1();
		logger1.info("User hovers over element 1");
		test.info("User hovers over element 1");

		Thread.sleep(3000);

		whatsnewpage.SelectSize1Element1();
		logger1.info("User selects size1 for element 1");
		test.info("User selects size1 for element 1");

		Thread.sleep(3000);

		whatsnewpage.SelectColor2Element1();
		logger1.info("User selects color 2 for element 1");
		test.info("User selects color 2 for element 1");

		Thread.sleep(3000);

		// Click AddtoCart for element 1
		whatsnewpage.ClickAddToCartElement1Button();
		logger1.info("User clicks on Add to cart button for element1");
		test.info("User clicks on Add to cart button for element1");

		Thread.sleep(3000);

		// User clicks on CartLink
		whatsnewpage.ClickCartLink();
		logger1.info("User clicks on Cart link");
		test.info("User clicks on Cart link");

		Thread.sleep(3000);

		// User click son View and Edit cart option.
		whatsnewpage.ClickViewAndEditCart();
		logger1.info("User clicks on View and Edit option");
		test.info("User clicks on View and Edit option");

		Thread.sleep(3000);

		// User navigates to Shopping cart page
		Assert.assertEquals(driver.getCurrentUrl(), TestData_Sheet4.get("TestURL_CheckoutCartPage"));
		logger1.info("User lands on shopping cart page");
		test.info("User lands on shopping cart page");

		Thread.sleep(3000);

		// User now checks presence of Search Text-box on Cart web page.
		shoppingcartpage.CheckPresenceSearchTextbox();
		logger1.info("Seach textbox exists on Shopping cart webpage");
		test.info("Seach textbox exists on Shopping cart webpage");

		/* New validation for TS004_TC002 */
		Assert.assertEquals(myaccountpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(myaccountpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");


	}

}
