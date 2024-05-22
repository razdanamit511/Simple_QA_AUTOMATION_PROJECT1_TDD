package com.qa.testcases.ts005;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class TS005_TC005 extends ReportUtil{

	private Logger logger1 = LogManager.getLogger(TS005_TC005.class);
	
	@Test(description = "Verify that user gets an error message as part of result outcome as follows provided user enters any inappropriate search keyword\r\n"
			+ "\r\n"
			+ "Error message: \"Your search returned no results.\"", groups = {"Functional","Sanity"})
	public void TS005_TC005() throws Exception {
		
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
		Map<String, String> TestData = XLUtils.getDataForTest("TS005_TC005", "Sheet5");

		/* Test steps */
		driver.manage().window().maximize();


		/*                    Step1: Validation for Home page               */

		// 1. User opens to HomePage page.
		driver.get(TestData.get("TestURL_HomePage"));
		logger1.info("User opens to Home Page page");
		test.info("User opens to Home Page page");

		// 2. Validate presence of SearchTextbox on HomePage
		Assert.assertEquals(homepage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Home page");
		test.info("Search textbox is displayed on Home page");

		// 3. Validate that user enters any string in Search text-box
		homepage.SetSearchTextbox(TestData.get("SearchKeywordInvalid"));
		logger1.info("User enters invalid value in search textbox");
		test.info("User enters invalid value in search textbox");


		//Explicit wait to wait for Button getting enabled post entering data into Search text-box
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 4. Validate Search Icon is enabled after entering any string in search
		// text-box
		Assert.assertEquals(homepage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		homepage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		Assert.assertEquals(homepage.GetNoSearchResultsMessage(), "Your search returned no results.");
		logger1.info("No search results message displayed on Home Page");
		test.info("No search results message displayed on Home Page");
		
		
		
		/*                    Step2: Validation for What's New page               */

		// 1. User opens to What's New page.
		driver.navigate().to(TestData.get("TestURL_WhatsNewPage"));
		logger1.info("User opens to  What's New Page page");
		test.info("User opens to  What's New Page page");

		// 2. Validate presence of SearchTextbox on HomePage
		Assert.assertEquals(whatsnewpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Home page");
		test.info("Search textbox is displayed on Home page");

		// 3. Validate that user enters any string in Search text-box
		whatsnewpage.SetSearchTextbox(TestData.get("SearchKeywordInvalid"));
		logger1.info("User enters invalid value in search textbox");
		test.info("User enters invalid value in search textbox");


		//Explicit wait to wait for Button getting enabled post entering data into Search text-box
			
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 4. Validate Search Icon is enabled after entering any string in search
		// text-box
		Assert.assertEquals(whatsnewpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		whatsnewpage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		Assert.assertEquals(whatsnewpage.GetNoSearchResultsMessage(), "Your search returned no results.");
		logger1.info("No search results message displayed on What's New Page");
		test.info("No search results message displayed on What's New Page");
	
		
		
		
		/*                    Step2: Validation for Women page               */

		// 1. User opens to Women New page.
		driver.navigate().to(TestData.get("TestURL_WomenPage"));
		logger1.info("User opens to Women page");
		test.info("User opens to Women page");

		// 2. Validate presence of SearchTextbox on Women page
		Assert.assertEquals(womenpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on womenpage page");
		test.info("Search textbox is displayed on womenpage page");

		// 3. Validate that user enters any string in Search text-box
		womenpage.SetSearchTextbox(TestData.get("SearchKeywordInvalid"));
		logger1.info("User enters invalid value in search textbox");
		test.info("User enters invalid value in search textbox");


		//Explicit wait to wait for Button getting enabled post entering data into Search text-box
			
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 4. Validate Search Icon is enabled after entering any string in search
		// text-box
		Assert.assertEquals(womenpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		womenpage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		Assert.assertEquals(womenpage.GetNoSearchResultsMessage(), "Your search returned no results.");
		logger1.info("No search results message displayed on Women Page");
		test.info("No search results message displayed on Women Page");
		
		
		/*                    Step2: Validation for Men page               */

		// 1. User opens to Men page.
		driver.navigate().to(TestData.get("TestURL_MenPage"));
		logger1.info("User opens to Men page");
		test.info("User opens to Men page");

		// 2. Validate presence of SearchTextbox on Men page
		Assert.assertEquals(menpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on menpage page");
		test.info("Search textbox is displayed on menpage page");

		// 3. Validate that user enters any string in Search text-box
		menpage.SetSearchTextbox(TestData.get("SearchKeywordInvalid"));
		logger1.info("User enters invalid value in search textbox");
		test.info("User enters invalid value in search textbox");


		//Explicit wait to wait for Button getting enabled post entering data into Search text-box
			
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 4. Validate Search Icon is enabled after entering any string in search
		// text-box
		Assert.assertEquals(menpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		menpage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		Assert.assertEquals(menpage.GetNoSearchResultsMessage(), "Your search returned no results.");
		logger1.info("No search results message displayed on Men Page");
		test.info("No search results message displayed on Men Page");
		
		
		/*                    Step2: Validation for Gear page               */

		// 1. User opens to Gear page.
		driver.navigate().to(TestData.get("TestURL_GearPage"));
		logger1.info("User opens to Gear page");
		test.info("User opens to Gear page");

		// 2. Validate presence of SearchTextbox on Gear page
		Assert.assertEquals(menpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Gear page");
		test.info("Search textbox is displayed on Gear page");

		// 3. Validate that user enters any string in Search text-box
		gearpage.SetSearchTextbox(TestData.get("SearchKeywordInvalid"));
		logger1.info("User enters invalid value in search textbox");
		test.info("User enters invalid value in search textbox");


		//Explicit wait to wait for Button getting enabled post entering data into Search text-box
			
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 4. Validate Search Icon is enabled after entering any string in search
		// text-box
		Assert.assertEquals(gearpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		gearpage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		Assert.assertEquals(gearpage.GetNoSearchResultsMessage(), "Your search returned no results.");
		logger1.info("No search results message displayed on Gear Page");
		test.info("No search results message displayed on Gear Page");
		
		
		
		
		
		/*                    Step2: Validation for Training page               */

		// 1. User opens to Training page.
		driver.navigate().to(TestData.get("TestURL_TrainingsPage"));
		logger1.info("User opens to Training page");
		test.info("User opens to Training page");

		// 2. Validate presence of SearchTextbox on Training page
		Assert.assertEquals(trainingpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Training page");
		test.info("Search textbox is displayed on Training page");

		// 3. Validate that user enters any string in Search text-box
		trainingpage.SetSearchTextbox(TestData.get("SearchKeywordInvalid"));
		logger1.info("User enters invalid value in search textbox");
		test.info("User enters invalid value in search textbox");


		//Explicit wait to wait for Button getting enabled post entering data into Search text-box
			
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 4. Validate Search Icon is enabled after entering any string in search
		// text-box
		Assert.assertEquals(trainingpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		trainingpage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		Assert.assertEquals(trainingpage.GetNoSearchResultsMessage(), "Your search returned no results.");
		logger1.info("No search results message displayed on Training Page");
		test.info("No search results message displayed on Training Page");
		
		
		
		
		
		/*                    Step2: Validation for Sale page               */

		// 1. User opens to Sale page.
		driver.navigate().to(TestData.get("TestURL_SalePage"));
		logger1.info("User opens to Sale page");
		test.info("User opens to Sale page");

		// 2. Validate presence of SearchTextbox on Sale page
		Assert.assertEquals(salepage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Sale page");
		test.info("Search textbox is displayed on Sale page");

		// 3. Validate that user enters any string in Search text-box
		salepage.SetSearchTextbox(TestData.get("SearchKeywordInvalid"));
		logger1.info("User enters invalid value in search textbox");
		test.info("User enters invalid value in search textbox");


		//Explicit wait to wait for Button getting enabled post entering data into Search text-box
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 4. Validate Search Icon is enabled after entering any string in search
		// text-box
		Assert.assertEquals(salepage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		salepage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		Assert.assertEquals(salepage.GetNoSearchResultsMessage(), "Your search returned no results.");
		logger1.info("No search results message displayed on Sale Page");
		test.info("No search results message displayed on Sale Page");
		
		
		
		
		/*                    Step2: Validation for CreateAnAccount page               */

		// 1. User opens to Sale page.
		driver.navigate().to(TestData.get("TestURL_CreateAnAccountPage"));
		logger1.info("User opens to Create An Account page");
		test.info("User opens to Create An Account page");

		// 2. Validate presence of SearchTextbox on Create An Account page
		Assert.assertEquals(createaccountpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Create An Account page");
		test.info("Search textbox is displayed on Create An Account page");

		// 3. Validate that user enters any string in Search text-box
		createaccountpage.SetSearchTextbox(TestData.get("SearchKeywordInvalid"));
		logger1.info("User enters invalid value in search textbox");
		test.info("User enters invalid value in search textbox");


		//Explicit wait to wait for Button getting enabled post entering data into Search text-box
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 4. Validate Search Icon is enabled after entering any string in search
		// text-box
		Assert.assertEquals(createaccountpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		createaccountpage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		Assert.assertEquals(createaccountpage.GetNoSearchResultsMessage(), "Your search returned no results.");
		logger1.info("No search results message displayed on Create An Account Page");
		test.info("No search results message displayed on Create An Account Page");
		
		
		
		/*                    Step2: Validation for SignIn page               */

		// 1. User opens to Sale page.
		driver.navigate().to(TestData.get("TestURL_SignInPage"));
		logger1.info("User opens to SignIn page");
		test.info("User opens to SignIn page");

		// 2. Validate presence of SearchTextbox on Create An Account page
		Assert.assertEquals(signpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on SignIn page");
		test.info("Search textbox is displayed on SignIn page");

		// 3. Validate that user enters any string in Search text-box
		signpage.SetSearchTextbox(TestData.get("SearchKeywordInvalid"));
		logger1.info("User enters invalid value in search textbox");
		test.info("User enters invalid value in search textbox");


		//Explicit wait to wait for Button getting enabled post entering data into Search text-box
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 4. Validate Search Icon is enabled after entering any string in search
		// text-box
		Assert.assertEquals(signpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		signpage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		Assert.assertEquals(signpage.GetNoSearchResultsMessage(), "Your search returned no results.");
		logger1.info("No search results message displayed on SignIn Page");
		test.info("No search results message displayed on SignIn Page");
	}
	
}
