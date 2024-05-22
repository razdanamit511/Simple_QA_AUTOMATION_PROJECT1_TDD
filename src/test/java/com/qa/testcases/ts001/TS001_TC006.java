package com.qa.testcases.ts001;

import java.time.Duration;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.CreateAnAccountPage;
import com.qa.util.ReportUtil;
import com.qa.util.XLUtils;

public class TS001_TC006 extends ReportUtil{

private static Logger logger1=LogManager.getLogger(TS001_TC006.class);
	
	@Test(description = "Verify that clicking on submit button after entering all the mandatory fields, submits the data to the server and an email is triggerd to teh email id being used at the time of registration", groups = {"Smoke", "Sanity" })
	public void TS001_TC006() throws Exception {
		
		driver.manage().window().maximize();

		Thread.sleep(Duration.ofMillis(2000));
		
		// Create object of page classes that are in use of current test execution.
		CreateAnAccountPage CreateAccount=new CreateAnAccountPage(driver);
		
		//Create object of XLUtil class to read test data from testdata.xlsx.
		Map<String, String> TestData=XLUtils.getDataForTest("TS001_TC006", "Sheet1");
		
		/* Test steps */
		
		Thread.sleep(3000);
		
		//Step1
		driver.get(TestData.get("TestURL"));
		logger1.info("Launched Create An Account page");
		test.info("Launched Create An Account page");
		
		Thread.sleep(3000);
	
		CreateAccount.SetFirstNameTextbox(TestData.get("FirstName"));
		logger1.info("Entered firstname in First Name textbox");
		test.info("Entered firstname in First Name textbox");
		
		Thread.sleep(3000);
		
		CreateAccount.SetLastNameTextbox(TestData.get("LastName"));
		logger1.info("Entered last name in Last Name textbox");
		test.info("Entered last name in Last Name textbox");
		
		Thread.sleep(3000);
		
		CreateAccount.SetEmailTextbox(TestData.get("Username"));
		logger1.info("Entered email in Email textbox");
		test.info("Entered email in Email textbox");
		
		Thread.sleep(3000);
		
		CreateAccount.SetPasswordTextbox(TestData.get("Password"));
		logger1.info("Entered password in Password textbox");
		test.info("Entered any string in Password testbox");
		
		Thread.sleep(3000);
		
		CreateAccount.SetConfirmPasswordTextbox(TestData.get("Confirm_Password"));
		logger1.info("Entered confirm pass in Confirm password textbox");
		test.info("Entered confirm pass in Confirm password textbox");
		
		Thread.sleep(3000);
		
		CreateAccount.ClickCreateAnAccountButton();
		logger1.info("Clicked on Create an Account button");
		test.info("Clicked on Create an Account button");
		
		Thread.sleep(3000);
		
		//Step2: Check value entered is entered in encrypted form i.e. ******* form.
		Assert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/customer/account/");
		logger1.info("User landed on My Account page after successful login");
		test.info("User landed on My Account after successful login");
		
	}
	
}
