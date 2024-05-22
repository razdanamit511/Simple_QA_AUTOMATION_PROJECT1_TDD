package com.qa.testcases.ts005;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

public class TS005_TC004 extends ReportUtil {

	private Logger logger1 = LogManager.getLogger(TS005_TC004.class);

	@Test(description = "Verify that user is able to get products as part of searched results based on the keyword been entered by user in search textbox followed by click on search icon and a label as follows :-\r\n"
			+ "\r\n" + "\"Search results for: '<entered keyword>'\"", groups = { "Regression", "Sanity" })
	public void TS005_TC004() throws Exception {

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
		Map<String, String> TestData = XLUtils.getDataForTest("TS005_TC004", "Sheet5");

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

		// 3. Validate that user enters any string in Search textbox
		homepage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
		logger1.info("User enters any value in search textbox");
		test.info("User enters any value in search textbox");


		//Explicit wait to wait for Button getting enabled post entering data into Search textbox
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

		// 6. User got searched results label having searched string as part of the
		// same.
		Assert.assertTrue(homepage.GetSearchResultsLabel().contains(TestData.get("SearchKeywordValid")));
		logger1.info("Search results label got displayed having searched string as part of resultant string");
		test.info("Search results label got displayed having searched string as part of resultant string");

		int numElements = 0;
		List<WebElement> listElements = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements.size(); i++) {

			System.out.println("Link text :" + listElements.get(i).getText());
			if (listElements.get(i).getText().endsWith(TestData.get("SearchKeywordValid"))) {
				numElements = numElements + 1;
			}
		}

		Assert.assertEquals(numElements, 12);
		logger1.info("Elements dispalyed with Jacket in their names");
		test.info("Elements dispalyed with Jacket in their names");

		
		
		

		/*                     Step2: Validation for What'sNew page      		 */
		// 1. User navigates to What's New page.
		driver.navigate().to(TestData.get("TestURL_WhatsNewPage"));
		logger1.info("User opens to What's New Page page");
		test.info("User opens to What's New Page page");

		// 2. Validate presence of SearchTextbox on What's New page
		Assert.assertEquals(whatsnewpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on What's New page");
		test.info("Search textbox is displayed on What's New page");

		// 3. Validate that user enters any string in Search textbox
		whatsnewpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
		logger1.info("User enters any value in search textbox");
		test.info("User enters any value in search textbox");

		// Explicit wait to wait for Button getting enabled post entering data into Search text-box
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 6. Validate Search Icon is enabled after entering any string in search text-box
		Assert.assertEquals(whatsnewpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		homepage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		
		// 6. User got searched results label having searched string as part of the same.
		Assert.assertTrue(whatsnewpage.GetSearchResultsLabel().contains(TestData.get("SearchKeywordValid")));
		logger1.info("Search results label got displayed having searched string as part of resultant string");
		test.info("Search results label got displayed having searched string as part of resultant string");

		int numElements1 = 0;
		List<WebElement> listElements1 = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements1.size(); i++) {

			System.out.println("Link text :" + listElements1.get(i).getText());
			if (listElements1.get(i).getText().endsWith(TestData.get("SearchKeywordValid"))) {
				numElements1 = numElements1 + 1;
			}
		}

		Assert.assertEquals(numElements1, 12);
		logger1.info("Elements dispalyed with Jacket in their names");
		test.info("Elements dispalyed with Jacket in their names");


		

		/*                     Step3: Validation for Women page      		 */
		// 1. User navigates to What's New page.
		driver.navigate().to(TestData.get("TestURL_WomenPage"));
		logger1.info("User opens to Women's Page page");
		test.info("User opens to Women's Page page");

		// 2. Validate presence of SearchTextbox on What's New page
		Assert.assertEquals(womenpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Women's page");
		test.info("Search textbox is displayed on Women's page");

		// 3. Validate that user enters any string in Search textbox
		womenpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
		logger1.info("User enters any value in search textbox");
		test.info("User enters any value in search textbox");

		// Explicit wait to wait for Button getting enabled post entering data into Search text-box
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 6. Validate Search Icon is enabled after entering any string in search text-box
		Assert.assertEquals(womenpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		womenpage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		
		// 6. User got searched results label having searched string as part of the same.
		Assert.assertTrue(womenpage.GetSearchResultsLabel().contains(TestData.get("SearchKeywordValid")));
		logger1.info("Search results label got displayed having searched string as part of resultant string");
		test.info("Search results label got displayed having searched string as part of resultant string");

		int numElements3 = 0;
		List<WebElement> listElements3 = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements3.size(); i++) {

			System.out.println("Link text :" + listElements3.get(i).getText());
			if (listElements3.get(i).getText().endsWith(TestData.get("SearchKeywordValid"))) {
				numElements3 = numElements3 + 1;
			}
		}

		Assert.assertEquals(numElements3, 12);
		logger1.info("Elements dispalyed with Jacket in their names");
		test.info("Elements dispalyed with Jacket in their names");
	
		
		
		
		
		
		/*                     Step3: Validation for Men page      		 */
		// 1. User navigates to What's New page.
		driver.navigate().to(TestData.get("TestURL_MenPage"));
		logger1.info("User opens to Men's Page page");
		test.info("User opens to Men's Page page");

		// 2. Validate presence of SearchTextbox on Men's New page
		Assert.assertEquals(menpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Men's page");
		test.info("Search textbox is displayed on Men's page");

		// 3. Validate that user enters any string in Search textbox
		menpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
		logger1.info("User enters any value in search textbox");
		test.info("User enters any value in search textbox");

		// Explicit wait to wait for Button getting enabled post entering data into Search text-box
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 6. Validate Search Icon is enabled after entering any string in search text-box
		Assert.assertEquals(menpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		menpage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		
		// 6. User got searched results label having searched string as part of the same.
		Assert.assertTrue(menpage.GetSearchResultsLabel().contains(TestData.get("SearchKeywordValid")));
		logger1.info("Search results label got displayed having searched string as part of resultant string");
		test.info("Search results label got displayed having searched string as part of resultant string");

		int numElements4 = 0;
		List<WebElement> listElements4 = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements4.size(); i++) {

			System.out.println("Link text :" + listElements4.get(i).getText());
			if (listElements4.get(i).getText().endsWith(TestData.get("SearchKeywordValid"))) {
				numElements4 = numElements4 + 1;
			}
		}

		Assert.assertEquals(numElements4, 12);
		logger1.info("Elements dispalyed with Jacket in their names");
		test.info("Elements dispalyed with Jacket in their names");
	
	
		
		
		/*                     Step4: Validation for GearPage page      		 */
		// 1. User navigates to GearPage  page.
		driver.navigate().to(TestData.get("TestURL_GearPage"));
		logger1.info("User opens to Gear's Page page");
		test.info("User opens to Gear's Page page");

		// 2. Validate presence of SearchTextbox on Gear's New page
		Assert.assertEquals(gearpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Gear's page");
		test.info("Search textbox is displayed on Gear's page");

		// 3. Validate that user enters any string in Search textbox
		gearpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
		logger1.info("User enters any value in search textbox");
		test.info("User enters any value in search textbox");

		// Explicit wait to wait for Button getting enabled post entering data into Search text-box
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 6. Validate Search Icon is enabled after entering any string in search text-box
		Assert.assertEquals(gearpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		gearpage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		
		// 6. User got searched results label having searched string as part of the same.
		Assert.assertTrue(gearpage.GetSearchResultsLabel().contains(TestData.get("SearchKeywordValid")));
		logger1.info("Search results label got displayed having searched string as part of resultant string");
		test.info("Search results label got displayed having searched string as part of resultant string");

		int numElements5 = 0;
		List<WebElement> listElements5 = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements5.size(); i++) {

			System.out.println("Link text :" + listElements5.get(i).getText());
			if (listElements5.get(i).getText().endsWith(TestData.get("SearchKeywordValid"))) {
				numElements5 = numElements5 + 1;
			}
		}

		Assert.assertEquals(numElements5, 12);
		logger1.info("Elements dispalyed with Jacket in their names");
		test.info("Elements dispalyed with Jacket in their names");
	
		
		
		
		
		/*                     Step5: Validation for Training page      		 */
		// 1. User navigates to Training  page.
		driver.navigate().to(TestData.get("TestURL_TrainingsPage"));
		logger1.info("User opens to Training Page page");
		test.info("User opens to Training Page page");

		// 2. Validate presence of SearchTextbox on Training New page
		Assert.assertEquals(trainingpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Training page");
		test.info("Search textbox is displayed on Training page");

		// 3. Validate that user enters any string in Search textbox
		trainingpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
		logger1.info("User enters any value in search textbox");
		test.info("User enters any value in search textbox");

		// Explicit wait to wait for Button getting enabled post entering data into Search text-box
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 6. Validate Search Icon is enabled after entering any string in search text-box
		Assert.assertEquals(trainingpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		trainingpage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		
		// 6. User got searched results label having searched string as part of the same.
		Assert.assertTrue(trainingpage.GetSearchResultsLabel().contains(TestData.get("SearchKeywordValid")));
		logger1.info("Search results label got displayed having searched string as part of resultant string");
		test.info("Search results label got displayed having searched string as part of resultant string");

		int numElements6 = 0;
		List<WebElement> listElements6 = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements6.size(); i++) {

			System.out.println("Link text :" + listElements6.get(i).getText());
			if (listElements6.get(i).getText().endsWith(TestData.get("SearchKeywordValid"))) {
				numElements6 = numElements6 + 1;
			}
		}

		Assert.assertEquals(numElements6, 12);
		logger1.info("Elements dispalyed with Jacket in their names");
		test.info("Elements dispalyed with Jacket in their names");
	
		
		
		
		
		
		
		
		
		/*                     Step5: Validation for Sale page      		 */
		// 1. User navigates to Sale  page.
		driver.navigate().to(TestData.get("TestURL_SalePage"));
		logger1.info("User opens to Sale Page page");
		test.info("User opens to Sale Page page");

		// 2. Validate presence of SearchTextbox on Sale New page
		Assert.assertEquals(salepage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Sale page");
		test.info("Search textbox is displayed on Sale page");

		// 3. Validate that user enters any string in Search textbox
		salepage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
		logger1.info("User enters any value in search textbox");
		test.info("User enters any value in search textbox");

		// Explicit wait to wait for Button getting enabled post entering data into Search text-box
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 6. Validate Search Icon is enabled after entering any string in search text-box
		Assert.assertEquals(salepage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		salepage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		
		// 6. User got searched results label having searched string as part of the same.
		Assert.assertTrue(salepage.GetSearchResultsLabel().contains(TestData.get("SearchKeywordValid")));
		logger1.info("Search results label got displayed having searched string as part of resultant string");
		test.info("Search results label got displayed having searched string as part of resultant string");

		int numElements7 = 0;
		List<WebElement> listElements7 = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements7.size(); i++) {

			System.out.println("Link text :" + listElements7.get(i).getText());
			if (listElements7.get(i).getText().endsWith(TestData.get("SearchKeywordValid"))) {
				numElements7 = numElements7 + 1;
			}
		}

		Assert.assertEquals(numElements7, 12);
		logger1.info("Elements dispalyed with Jacket in their names");
		test.info("Elements dispalyed with Jacket in their names");
	
		
		
		
		
		
		
		/*                     Step5: Validation for CreateAnAccountPage page      		 */
		// 1. User navigates to Sale  page.
		driver.navigate().to(TestData.get("TestURL_CreateAnAccountPage"));
		logger1.info("User opens to Create an account Page page");
		test.info("User opens to Create an account Page page");

		// 2. Validate presence of SearchTextbox on Create an account New page
		Assert.assertEquals(createaccountpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on Create an account page");
		test.info("Search textbox is displayed on Create an account page");

		// 3. Validate that user enters any string in Search textbox
		createaccountpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
		logger1.info("User enters any value in search textbox");
		test.info("User enters any value in search textbox");

		// Explicit wait to wait for Button getting enabled post entering data into Search text-box
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 6. Validate Search Icon is enabled after entering any string in search text-box
		Assert.assertEquals(createaccountpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		createaccountpage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		
		// 6. User got searched results label having searched string as part of the same.
		Assert.assertTrue(createaccountpage.GetSearchResultsLabel().contains(TestData.get("SearchKeywordValid")));
		logger1.info("Search results label got displayed having searched string as part of resultant string");
		test.info("Search results label got displayed having searched string as part of resultant string");

		int numElements8 = 0;
		List<WebElement> listElements8 = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements8.size(); i++) {

			System.out.println("Link text :" + listElements8.get(i).getText());
			if (listElements8.get(i).getText().endsWith(TestData.get("SearchKeywordValid"))) {
				numElements8 = numElements8 + 1;
			}
		}

		Assert.assertEquals(numElements8, 12);
		logger1.info("Elements dispalyed with Jacket in their names");
		test.info("Elements dispalyed with Jacket in their names");
		
		
		
		
		

		/*                     Step5: Validation for Sign In Page page      		 */
		// 1. User navigates to Sign In page.
		driver.navigate().to(TestData.get("TestURL_SignInPage"));
		logger1.info("User opens to SignIn Page page");
		test.info("User opens to SignIn Page page");

		// 2. Validate presence of SearchTextbox on SignIn New page
		Assert.assertEquals(signpage.CheckPresenceSearchTextbox(), true);
		logger1.info("Search textbox is displayed on SignIn page");
		test.info("Search textbox is displayed on SignIn page");

		// 3. Validate that user enters any string in Search text-box
		signpage.SetSearchTextbox(TestData.get("SearchKeywordValid"));
		logger1.info("User enters any value in search textbox");
		test.info("User enters any value in search textbox");

		// Explicit wait to wait for Button getting enabled post entering data into Search text-box
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")));

		// 6. Validate Search Icon is enabled after entering any string in search text-box
		Assert.assertEquals(signpage.GetStateSearchIconSearchTextbox(), true);
		logger1.info("Search icon of search textbox is now enabled");
		test.info("Search icon of search textbox is now enabled");

		// 5. User clicks on SearchIcon in Search Text-box.
		signpage.ClickSearchIconTextbox();
		logger1.info("User clicks on Search icon");
		test.info("User clicks on Search icon");

		
		
		// 6. User got searched results label having searched string as part of the same.
		Assert.assertTrue(signpage.GetSearchResultsLabel().contains(TestData.get("SearchKeywordValid")));
		logger1.info("Search results label got displayed having searched string as part of resultant string");
		test.info("Search results label got displayed having searched string as part of resultant string");

		int numElements9 = 0;
		List<WebElement> listElements9 = driver.findElements(By.tagName("a"));
		for (int i = 0; i < listElements9.size(); i++) {

			System.out.println("Link text :" + listElements9.get(i).getText());
			if (listElements9.get(i).getText().endsWith(TestData.get("SearchKeywordValid"))) {
				numElements9 = numElements9 + 1;
			}
		}

		Assert.assertEquals(numElements9, 12);
		logger1.info("Elements dispalyed with Jacket in their names");
		test.info("Elements dispalyed with Jacket in their names");
	}
}
