package com.qa.testcases.ts005;

import java.time.Duration;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.CheckoutPaymentsPage;
import com.qa.pages.CheckoutShippingPage;
import com.qa.pages.CreateAnAccountPage;
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

public class TS005_TC003 extends ReportUtil {

	private Logger logger1 = LogManager.getLogger(TS005_TC003.class);

	@Test(description = "Verify that search icon with search textbox gets enabled as soon as user enters any string/char in search textbox",groups = {"Functional","Regression"})
	public void TS005_TC003() throws Exception {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // This will make WebDriver to wait 20
		// seconds for every script/element driver
		// interacts with before throwing
		// NoSuchElementFound exception.

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
		CreateAnAccountPage createaccountpage = new CreateAnAccountPage(driver);
		CheckoutShippingPage checkoutshippingpage = new CheckoutShippingPage(driver);
		CheckoutPaymentsPage checkoutpaymentpage = new CheckoutPaymentsPage(driver);

		/* Create object of XLUtil utility to read test data from TestData.xlsx. */
		// Get data of Sheet4
		Map<String, String> TestData = XLUtils.getDataForTest("TS005_TC003", "Sheet5");

		/* Test steps */
		driver.manage().window().maximize();

		/* Step1: Validation for Home page */

		// 1. User opens to HomePage page.
		driver.get(TestData.get("TestURL_HomePage"));
		logger1.info("User opens to Home Page page");
		test.info("User opens to Home Page page");

		// 2. Validate presence of SearchTextbox on HomePage
		Assert.assertEquals(homepage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Home page");
		test.info("Search textbox is displayed on Home page");

		// 3. Validate SearchTextbox is empty by default on HomePage
		Assert.assertEquals(homepage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default");
		test.info("Search textbox is empty by default");

		// 4. Validate Search Icon is disabled by default on HomePage
		Assert.assertEquals(homepage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default");
		test.info("Search icon of search textbox is disabled by default");

		// 5. Validate that user enters any string in Search textbox
		homepage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
		logger1.info("User enters any value in search textbox");
		test.info("User enters any value in search textbox");

//Explicit wait to wait for Button getting enabled post entering data into Search textbox
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		
		// 5. Validate Search Icon is enabled after entering any string in serach
		// textbox
		Assert.assertEquals(homepage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		
		
		
		
		/* Step2: Validation for What'sNew page */
		// 1. User navigates to What's New page.
		driver.get(TestData.get("TestURL_WhatsNewPage"));
		logger1.info("User opens to What's New Page page");
		test.info("User opens to What's New Page page");

		// 2. Validate presence of SearchTextbox on What's New page
		Assert.assertEquals(whatsnewpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on What's New page");
		test.info("Search textbox is displayed on What's New page");

		// 3. Validate SearchTextbox is empty by default on whatsnewpage
		Assert.assertEquals(whatsnewpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default on What's New page");
		test.info("Search textbox is empty by default on What's New page");

		// 4. Validate Search Icon is disabled by default on whatsnewpage
		Assert.assertEquals(whatsnewpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default on What's New page");
		test.info("Search icon of search textbox is disabled by default on What's New page");

//5. Validate that user enters any string in Search textbox
		whatsnewpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
		logger1.info("User enters any value in search textbox");
		test.info("User enters any value in search textbox");

		//Explicit wait to wait for Button getting enabled post entering data into Search textbox
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

				
		
// 5. Validate Search Icon is enabled after entering any string in serach textbox
		Assert.assertEquals(whatsnewpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		
		
		

		/* Step3: Validation for Women's page */
		// 1. User navigates to Women's page.
		driver.navigate().to(TestData.get("TestURL_WomenPage"));
		logger1.info("User opens to Women's Page page");
		test.info("User opens to Women's Page page");

		// 2. Validate presence of SearchTextbox on Women's page
		Assert.assertEquals(womenpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Women's page");
		test.info("Search textbox is displayed on Women's page");

		// 3. Validate SearchTextbox is empty by default on Women's page
		Assert.assertEquals(womenpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default on Women's page");
		test.info("Search textbox is empty by default on Women's page");

		
		
		// 4. Validate Search Icon is disabled by default on Women's page
		Assert.assertEquals(womenpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default on Women's page");
		test.info("Search icon of search textbox is disabled by default on Women's page");

		
		//5. Validate that user enters any string in Search textbox
		womenpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
				logger1.info("User enters any value in search textbox");
				test.info("User enters any value in search textbox");

				//Explicit wait to wait for Button getting enabled post entering data into Search textbox
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

				
				
				
		// 6. Validate Search Icon is enabled after entering any string in search textbox
				Assert.assertEquals(womenpage.GetStateSearchIconSearchTextbox(), true);
				logger1.info("Search icon of search textbox is now enabled");
				test.info("Search icon of search textbox is now enabled");
		
		
	
		
		/* Step4: Validation for Men's page */
		// 1. User navigates to Men's page.
		driver.navigate().to(TestData.get("TestURL_MenPage"));
		logger1.info("User opens to Men's Page page");
		test.info("User opens to Men's Page page");

		// 2. Validate presence of SearchTextbox on Men's page
		Assert.assertEquals(menpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Men's page");
		test.info("Search textbox is displayed on Men's page");

		// 3. Validate SearchTextbox is empty by default on Men's page
		Assert.assertEquals(menpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default on Men's page");
		test.info("Search textbox is empty by default on Men's page");

		// 4. Validate Search Icon is disabled by default on Men's page
		Assert.assertEquals(menpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default on Men's page");
		test.info("Search icon of search textbox is disabled by default on Men's page");

		
		//5. Validate that user enters any string in Search textbox
		menpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
				logger1.info("User enters any value in search textbox");
				test.info("User enters any value in search textbox");
				//Explicit wait to wait for Button getting enabled post entering data into Search textbox
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

				
		// 6. Validate Search Icon is enabled after entering any string in search textbox
				Assert.assertEquals(menpage.GetStateSearchIconSearchTextbox(), true);
				logger1.info("Search icon of search textbox is now enabled");
				test.info("Search icon of search textbox is now enabled");
		
				
				
				

		/* Step5: Validation for Gear's page */
// 1. User navigates to Gear's page.
		driver.navigate().to(TestData.get("TestURL_GearPage"));
		logger1.info("User opens to Gear's Page page");
		test.info("User opens to Gear's Page page");

// 2. Validate presence of SearchTextbox on Gear's page
		Assert.assertEquals(gearpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Gear's page");
		test.info("Search textbox is displayed on Gear's page");

// 3. Validate SearchTextbox is empty by default on Gear's page
		Assert.assertEquals(gearpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default on Gear's page");
		test.info("Search textbox is empty by default on Gear's page");

// 4. Validate Search Icon is disabled by default on Gear's page
		Assert.assertEquals(gearpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default on Gear's page");
		test.info("Search icon of search textbox is disabled by default on Gear's page");

		//5. Validate that user enters any string in Search textbox
		gearpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
				logger1.info("User enters any value in search textbox");
				test.info("User enters any value in search textbox");

				//Explicit wait to wait for Button getting enabled post entering data into Search textbox
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

				
				
				
				//6. Validate Search Icon is enabled after entering any string in search textbox
				Assert.assertEquals(gearpage.GetStateSearchIconSearchTextbox(), true);
				logger1.info("Search icon of search textbox is now enabled");
				test.info("Search icon of search textbox is now enabled");
		
		
		
		
		
		
		
		
		
		
		/* Step5: Validation for Training's page */
//1. User navigates to Training's page.
		driver.navigate().to(TestData.get("TestURL_TrainingsPage"));
		logger1.info("User opens to Training's Page page");
		test.info("User opens to Training's Page page");

//2. Validate presence of SearchTextbox on Training's page
		Assert.assertEquals(trainingpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Training's page");
		test.info("Search textbox is displayed on Training's page");

//3. Validate SearchTextbox is empty by default on Training's page
		Assert.assertEquals(trainingpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default on Training's page");
		test.info("Search textbox is empty by default on Training's page");

//4. Validate Search Icon is disabled by default on Training's page
		Assert.assertEquals(trainingpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default on Training's page");
		test.info("Search icon of search textbox is disabled by default on Training's page");


		//5. Validate that user enters any string in Search textbox
		trainingpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
				logger1.info("User enters any value in search textbox");
				test.info("User enters any value in search textbox");

				//Explicit wait to wait for Button getting enabled post entering data into Search textbox
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

				
				
				
		// 6. Validate Search Icon is enabled after entering any string in search textbox
				Assert.assertEquals(trainingpage.GetStateSearchIconSearchTextbox(), true);
				logger1.info("Search icon of search textbox is now enabled");
				test.info("Search icon of search textbox is now enabled");
				

		
		
		/* Step5: Validation for Sale's page */
//1. User navigates to Sale's page.
		driver.navigate().to(TestData.get("TestURL_SalePage"));
		logger1.info("User opens to Sale's Page page");
		test.info("User opens to Sale's Page page");

//2. Validate presence of SearchTextbox on Sale's page
		Assert.assertEquals(salepage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Sale's page");
		test.info("Search textbox is displayed on Sale's page");

//3. Validate SearchTextbox is empty by default on Sale's page
		Assert.assertEquals(salepage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default on Sale's page");
		test.info("Search textbox is empty by default on Sale's page");

//4. Validate Search Icon is disabled by default on Sale's page
		Assert.assertEquals(salepage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default on Sale's page");
		test.info("Search icon of search textbox is disabled by default on Sale's page");


		//5. Validate that user enters any string in Search textbox
		salepage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
				logger1.info("User enters any value in search textbox");
				test.info("User enters any value in search textbox");

				
				//Explicit wait to wait for Button getting enabled post entering data into Search textbox
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

							
		// 6. Validate Search Icon is enabled after entering any string in search textbox
				Assert.assertEquals(salepage.GetStateSearchIconSearchTextbox(), true);
				logger1.info("Search icon of search textbox is now enabled");
				test.info("Search icon of search textbox is now enabled");
				
		
		
		
		
		/* Step5: Validation for SignIn page */
//1. User navigates to SignIn page.
		driver.navigate().to(TestData.get("TestURL_SignInPage"));
		logger1.info("User opens to SignIn Page page");
		test.info("User opens to SignIn Page page");

//2. Validate presence of SearchTextbox on SignIn page
		Assert.assertEquals(signpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on SignIn page");
		test.info("Search textbox is displayed on SignIn page");

//3. Validate SearchTextbox is empty by default on SignIn page
		Assert.assertEquals(signpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default on SignIn page");
		test.info("Search textbox is empty by default on SignIn page");

//4. Validate Search Icon is disabled by default on SignIn page
		Assert.assertEquals(signpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default on SignIn page");
		test.info("Search icon of search textbox is disabled by default on SignIn page");

		//5. Validate that user enters any string in Search textbox
		signpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
				logger1.info("User enters any value in search textbox");
				test.info("User enters any value in search textbox");

				//Explicit wait to wait for Button getting enabled post entering data into Search textbox
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

				
				
		// 6. Validate Search Icon is enabled after entering any string in search textbox
				Assert.assertEquals(signpage.GetStateSearchIconSearchTextbox(), true);
				logger1.info("Search icon of search textbox is now enabled");
				test.info("Search icon of search textbox is now enabled");
				
		
		
		
		
		/* Step6: Validation for Create An Account page */
//1. User navigates to Create An Account page.
		driver.navigate().to(TestData.get("TestURL_CreateAnAccountPage"));
		logger1.info("User opens to Create An Account Page page");
		test.info("User opens to Create An Account Page page");

//2. Validate presence of SearchTextbox on Create An Account page
		Assert.assertEquals(createaccountpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Create An Account page");
		test.info("Search textbox is displayed on Create An Account page");

//3. Validate SearchTextbox is empty by default on Create An Account page
		Assert.assertEquals(createaccountpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default on Create An Account page");
		test.info("Search textbox is empty by default on Create An Account page");

//4. Validate Search Icon is disabled by default on Create An Account page
		Assert.assertEquals(createaccountpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default on Create An Account page");
		test.info("Search icon of search textbox is disabled by default on Create An Account page");


		//5. Validate that user enters any string in Search textbox
		createaccountpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
				logger1.info("User enters any value in search textbox");
				test.info("User enters any value in search textbox");

				
				//Explicit wait to wait for Button getting enabled post entering data into Search textbox
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

				
				
		// 6. Validate Search Icon is enabled after entering any string in search textbox
				Assert.assertEquals(createaccountpage.GetStateSearchIconSearchTextbox(), true);
				logger1.info("Search icon of search textbox is now enabled");
				test.info("Search icon of search textbox is now enabled");
		
		
		

		
		
		/*
		 * Pre-requiste for Moving onto Cart webpage : User adds any element from What's
		 * New page in order to make traversal to cart possible
		 */

// Navigate to What's New Page
		driver.navigate().to(TestData.get("TestURL_WhatsNewPage"));
		logger1.info("User navigates to What's New page");
		test.info("User navigates to What's New page");

// Hover cursor over element 1
		whatsnewpage.HoverOverElement1();
		logger1.info("User hovers over element 1");
		test.info("User hovers over element 1");

//	whatsnewpage.SelectSize1Element1();
//logger1.info("User selected size for element1");
//test.info("User selected size for element1");

//whatsnewpage.SelectColor2Element1();
//	logger1.info("User selected color for element1");
//test.info("User selected color for element1");

// Click AddtoCart for element 1
		whatsnewpage.ClickAddToCartButton1Element1();
		logger1.info("User clicks on Add to cart button for element1");
		test.info("User clicks on Add to cart button for element1");

// here application takes a specific amount of time to add element to Cart and
// the same to reflect ... so we might have to use Explicit wait here.
// explicit wait - to wait for the Counter to reflect count on Cart icon

// User click son View and Edit cart option.
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]")));

// User clicks on CartLink
		whatsnewpage.ClickCartLink();
		logger1.info("User clicks on Cart link");
		test.info("User clicks on Cart link");

// click on the compose button as soon as the "ViewAndEdit" button is visible
		whatsnewpage.ClickViewAndEditCart();
		logger1.info("User clicks on View and Edit option");
		test.info("User clicks on View and Edit option");

		/* Step7: Validation for Checkout's Cart page */
//1. User navigates to Shopping cart page
		Assert.assertEquals(driver.getCurrentUrl(), TestData.get("TestURL_CheckoutCartPage"));
		logger1.info("User lands on shopping cart page");
		test.info("User lands on shopping cart page");

		/* 2. Check presence of Search Text-box on Cart web page */
		Assert.assertEquals(shoppingcartpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Seach textbox exists on Shopping cart webpage");
		test.info("Seach textbox exists on Shopping cart webpage");

//3. Validate SearchTextbox is empty by default on Create An Account page
		Assert.assertEquals(shoppingcartpage.GetDefaultValSearchTextbox(), true);
		logger1.info("Search textbox is empty by default on Shopping cart page");
		test.info("Search textbox is empty by default on Shopping cart page");

//4. Validate Search Icon is disabled by default on Create An Account page
		Assert.assertEquals(shoppingcartpage.GetStateSearchIconSearchTextbox(), false);
		logger1.info("Search icon of search textbox is disabled by default on Shopping cart page");
		test.info("Search icon of search textbox is disabled by default on Shopping cart page");



		//5. Validate that user enters any string in Search textbox
		shoppingcartpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
				logger1.info("User enters any value in search textbox");
				test.info("User enters any value in search textbox");

				//Explicit wait to wait for Button getting enabled post entering data into Search textbox
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

				
				
				
		// 6. Validate Search Icon is enabled after entering any string in search textbox
				Assert.assertEquals(shoppingcartpage.GetStateSearchIconSearchTextbox(), true);
				logger1.info("Search icon of search textbox is now enabled");
				test.info("Search icon of search textbox is now enabled");
		
	}

}
