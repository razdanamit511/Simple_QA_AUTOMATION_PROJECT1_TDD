package com.qa.testcases.ts004;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

public class TS004_TC003 extends ReportUtil{

	private Logger logger1=LogManager.getLogger(TS004_TC003.class);
	
	@Test(description = "Verify that search icon with search textbox gets enabled as soon as user enters any string/char in search textbox", groups = {"Regression","Functional","Smoke","Sanity"})
	public void TS004_TC003() throws Exception{
		
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
		Map<String, String> TestData=XLUtils.getDataForTest("TS004_TC003", "Sheet4");
		
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

		/* New validation for TS004_TC002 */
		Assert.assertEquals(myaccountpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(myaccountpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");
		
		myaccountpage.SetSearchTextbox("Demo");
		logger1.info("Entered any demo string in search textbox");
		test.info("Entered any demo string in search textbox");
		
		Assert.assertEquals(myaccountpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled for the user");
		test.info("Search icon of search textbox is now enabled for the user");
		

		Thread.sleep(3000);

		// Step3: User navigates to MyWishList page.
		driver.navigate().to(TestData.get("TestURL_MyWishListPage"));
		logger1.info("User navigates to MyWishList page");
		test.info("User navigates to MyWishList page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on MyWishlist page
		Assert.assertEquals(mywishlistpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on My Wishlist page");
		test.info("Search textbox is displayed on My Wishlist page");

		/* New validation for TS004_TC002 */
		Assert.assertEquals(mywishlistpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(mywishlistpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");
		
		mywishlistpage.SetSearchTextbox("Demo");
		logger1.info("Entered any demo string in search textbox");
		test.info("Entered any demo string in search textbox");
		
		Assert.assertEquals(mywishlistpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled for the user");
		test.info("Search icon of search textbox is now enabled for the user");

		Thread.sleep(3000);

		// Step3: User navigates to Home page.
		driver.navigate().to(TestData.get("TestURL_HomePage"));
		logger1.info("User navigates to Home page");
		test.info("User navigates to Home page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Home page
		Assert.assertEquals(homepage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Home page");
		test.info("Search textbox is displayed on Home page");

		Thread.sleep(3000);

		/* New validation for TS004_TC002 */
		Assert.assertEquals(homepage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(homepage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");
		
		homepage.SetSearchTextbox("Demo");
		logger1.info("Entered any demo string in search textbox");
		test.info("Entered any demo string in search textbox");
		
		Assert.assertEquals(homepage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled for the user");
		test.info("Search icon of search textbox is now enabled for the user");
		
		
		
		

		// Step3: User navigates to What's New page.
		driver.navigate().to(TestData.get("TestURL_WhatsNewPage"));
		logger1.info("User navigates to Whats New page");
		test.info("User navigates to Whats New page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on What's New page
		Assert.assertEquals(whatsnewpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on What's New page");
		test.info("Search textbox is displayed on What's New page");

		Thread.sleep(3000);

		/* New validation for TS004_TC002 */
		Assert.assertEquals(whatsnewpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(whatsnewpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");
		
		whatsnewpage.SetSearchTextbox("Demo");
		logger1.info("Entered any demo string in search textbox");
		test.info("Entered any demo string in search textbox");
		
		Assert.assertEquals(whatsnewpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled for the user");
		test.info("Search icon of search textbox is now enabled for the user");
		
		
		
		Thread.sleep(3000);

		// Step3: User navigates to Women page.
		driver.navigate().to(TestData.get("TestURL_WomenPage"));
		logger1.info("User navigates to Womens page");
		test.info("User navigates to Womens page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Women page
		Assert.assertEquals(womenpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Women page");
		test.info("Search textbox is displayed on Women page");

		Thread.sleep(3000);

		/* New validation for TS004_TC002 */
		/* New validation for TS004_TC002 */
		Assert.assertEquals(womenpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(womenpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");
		
		womenpage.SetSearchTextbox("Demo");
		logger1.info("Entered any demo string in search textbox");
		test.info("Entered any demo string in search textbox");
		
		Assert.assertEquals(womenpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled for the user");
		test.info("Search icon of search textbox is now enabled for the user");

		Thread.sleep(3000);

		// Step3: User navigates to Men page.
		driver.navigate().to(TestData.get("TestURL_MenPage"));
		logger1.info("User navigates to Mens page");
		test.info("User navigates to Mens page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Mens page
		Assert.assertEquals(menpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Mens page");
		test.info("Search textbox is displayed on Mens page");

		Thread.sleep(3000);

		/* New validation for TS004_TC002 */
		/* New validation for TS004_TC002 */
		Assert.assertEquals(menpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(menpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");
		
		menpage.SetSearchTextbox("Demo");
		logger1.info("Entered any demo string in search textbox");
		test.info("Entered any demo string in search textbox");
		
		Assert.assertEquals(menpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled for the user");
		test.info("Search icon of search textbox is now enabled for the user");
		
		Thread.sleep(3000);

		// Step3: User navigates to Gear page.
		driver.navigate().to(TestData.get("TestURL_GearPage"));
		logger1.info("User navigates to Gear page");
		test.info("User navigates to Gear page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Gear page
		Assert.assertEquals(gearpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Gear page");
		test.info("Search textbox is displayed on Gear page");

		Thread.sleep(3000);

		/* New validation for TS004_TC002 */
		Assert.assertEquals(gearpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(gearpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");
		
		gearpage.SetSearchTextbox("Demo");
		logger1.info("Entered any demo string in search textbox");
		test.info("Entered any demo string in search textbox");
		
		Assert.assertEquals(gearpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled for the user");
		test.info("Search icon of search textbox is now enabled for the user");
		

		Thread.sleep(3000);

		// Step3: User navigates to Trainings page.
		driver.navigate().to(TestData.get("TestURL_TrainingsPage"));
		logger1.info("User navigates to Trainings page");
		test.info("User navigates to Trainings page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Trainings page
		Assert.assertEquals(trainingpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Trainings page");
		test.info("Search textbox is displayed on Trainings page");

		Thread.sleep(3000);

		/* New validation for TS004_TC002 */
		Assert.assertEquals(trainingpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(trainingpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");
		
		trainingpage.SetSearchTextbox("Demo");
		logger1.info("Entered any demo string in search textbox");
		test.info("Entered any demo string in search textbox");
		
		Assert.assertEquals(trainingpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled for the user");
		test.info("Search icon of search textbox is now enabled for the user");
		

		Thread.sleep(3000);

		// Step3: User navigates to Sale page.
		driver.navigate().to(TestData.get("TestURL_SalePage"));
		logger1.info("User navigates to Sale page");
		test.info("User navigates to Sale page");

		Thread.sleep(3000);

		// Step3: Check presence of Search text-box on Sale page
		Assert.assertEquals(salepage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Sale page");
		test.info("Search textbox is displayed on Sale page");

		Thread.sleep(3000);
		
		/* New validation for TS004_TC002 */
		Assert.assertEquals(salepage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		Assert.assertEquals(salepage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");
		
		salepage.SetSearchTextbox("Demo");
		logger1.info("Entered any demo string in search textbox");
		test.info("Entered any demo string in search textbox");
		
		Assert.assertEquals(salepage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled for the user");
		test.info("Search icon of search textbox is now enabled for the user");
		
		
		Thread.sleep(3000);	
		
		
		/*
		 * User adds any element from What's New page in order to make traversal to cart
		 * possible
		 */

		// Navigate to What's New Page
		driver.navigate().to(TestData.get("TestURL_WhatsNewPage"));
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
		Assert.assertEquals(driver.getCurrentUrl(), TestData.get("TestURL_CheckoutCartPage"));
		logger1.info("User lands on shopping cart page");
		test.info("User lands on shopping cart page");

		Thread.sleep(3000);

		// User now checks presence of Search Text-box on Cart web page.
		shoppingcartpage.CheckPresenceSearchTextbox();
		logger1.info("Seach textbox exists on Shopping cart webpage");
		test.info("Seach textbox exists on Shopping cart webpage");
		Thread.sleep(3000);
		
		/* New validation for TS004_TC002 */
		Assert.assertEquals(shoppingcartpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");
		Thread.sleep(3000);
		Assert.assertEquals(shoppingcartpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");
		Thread.sleep(3000);
		shoppingcartpage.SetSearchTextbox("Demo");
		logger1.info("Entered any demo string in search textbox");
		test.info("Entered any demo string in search textbox");
		Thread.sleep(3000);
		Assert.assertEquals(shoppingcartpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled for the user");
		test.info("Search icon of search textbox is now enabled for the user");

	}
	
}
