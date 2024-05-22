package com.qa.testcases.ts005;

import java.time.Duration;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

import dev.failsafe.Timeout;

public class TS005_TC001 extends ReportUtil {
	private Logger logger1 = LogManager.getLogger(TS005_TC001.class);

	@Test(description = "Ensure that the search textbox is present on below mentioned pages :-\r\n" + "HomePage\r\n"
			+ "Whats New page\r\n" + "Women Page\r\n" + "Men Page\r\n" + "Gear Page\r\n" + "Trainings Page\r\n"
			+ "Sale Page\r\n" + "SignIn page\r\n" + "Create An Account Page\r\n" + "Checkout Cart Page\r\n"
			+ "and Not on below mentioned page :-\r\n" + "Checkout's Shipping page\r\n"
			+ "Checkout's Payment page", groups = { "Smoke", "Regression" })
	public void TS005_TC001() throws Exception {

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
		CheckoutPaymentsPage checkoutpaymentpage=new CheckoutPaymentsPage(driver);
		

		/* Get test data using XLUtil utility */
		Map<String, String> TestData = XLUtils.getDataForTest("TS005_TC001", "Sheet5");

		/* Test steps */
		driver.manage().window().maximize();

		/* Step1: Check presence of Search Text-box on Home Page */
		driver.navigate().to(TestData.get("TestURL_HomePage"));

		Assert.assertEquals(homepage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is present on Home Page");
		test.info("Search textbox is present on Home Page");

		/* Step2: Check presence of Search Text-box on What's New Page */
		driver.navigate().to(TestData.get("TestURL_WhatsNewPage"));

		Assert.assertEquals(whatsnewpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is present on Whats New Page");
		test.info("Search textbox is present on Whats New Page");

		/* Step3: Check presence of Search Text-box on Women New Page */
		driver.navigate().to(TestData.get("TestURL_WomenPage"));

		Assert.assertEquals(womenpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is present on Women Page");
		test.info("Search textbox is present on Women Page");

		/* Step4: Check presence of Search Text-box on Men Page */
		driver.navigate().to(TestData.get("TestURL_MenPage"));

		Assert.assertEquals(menpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is present on Men Page");
		test.info("Search textbox is present on Men Page");

		/* Step5: Check presence of Search Text-box on Gear Page */
		driver.navigate().to(TestData.get("TestURL_GearPage"));

		Assert.assertEquals(gearpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is present on Gear Page");
		test.info("Search textbox is present on Gear Page");

		/* Step6: Check presence of Search Text-box on Training Page */
		driver.navigate().to(TestData.get("TestURL_TrainingsPage"));

		Assert.assertEquals(trainingpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is present on Trainings Page");
		test.info("Search textbox is present on Trainings Page");

		/* Step7: Check presence of Search Text-box on Sale Page */
		driver.navigate().to(TestData.get("TestURL_SalePage"));

		Assert.assertEquals(salepage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is present on Sale Page");
		test.info("Search textbox is present on Sale Page");

		/* Step8: Check presence of Search Text-box on Sale Page */
		driver.navigate().to(TestData.get("TestURL_SalePage"));

		Assert.assertEquals(salepage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is present on Sale Page");
		test.info("Search textbox is present on Sale Page");

		/* Step9: Check presence of Search Text-box on SignIn Page */
		driver.navigate().to(TestData.get("TestURL_SignInPage"));

		Assert.assertEquals(signpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is present on Sign In Page");
		test.info("Search textbox is present on Sign In Page");

		/* Step10: Check presence of Search Text-box on CreateAnAccount Page */
		driver.navigate().to(TestData.get("TestURL_CreateAnAccountPage"));

		Assert.assertEquals(createaccountpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is present on Create An Account Page");
		test.info("Search textbox is present on Create An Account Page");

		/*
		 * User adds any element from What's New page in order to make traversal to cart
		 * possible
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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

		// User navigates to Shopping cart page
		Assert.assertEquals(driver.getCurrentUrl(), TestData.get("TestURL_CheckoutCartPage"));
		logger1.info("User lands on shopping cart page");
		test.info("User lands on shopping cart page");

		/* Step11: Check presence of Search Text-box on Cart web page */
		Assert.assertEquals(shoppingcartpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Seach textbox exists on Shopping cart webpage");
		test.info("Seach textbox exists on Shopping cart webpage");

		/*
		 * Step12: Check presence of Search Text-box on : It should NOT be preset on
		 * Checkout's Shipping page
		 */
		driver.navigate().to(TestData.get("TestURL_CheckoutShippingPage"));

		Assert.assertEquals(checkoutshippingpage.CheckPresenceSearchTextbox(), false);
		logger1.info("Seach textbox do not exists on checkout's shipping webpage");
		test.info("Seach textbox do not exists on checkout's shipping webpage");
		
		/*
		 * Step13: Check presence of Search Text-box on Checkout's Payment page : It should  NOT be preset on
		 * Checkout's Payment page
		 */
		driver.navigate().to(TestData.get("TestURL_CheckoutReviewsAndPaymentsPage"));

		Assert.assertEquals(checkoutpaymentpage.CheckPresenceSearchTextbox(), false);
		logger1.info("Seach textbox do not exists on checkout's payments webpage");
		test.info("Seach textbox do not exists on checkout's payments webpage");
		

		
	}

}
