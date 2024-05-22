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

public class TS001_TC005 extends ReportUtil{

	private static Logger logger1=LogManager.getLogger(TS001_TC005.class);
	
	@Test(description = "Verify that the password is in encrypted form when entered", groups = {"Functional", "Smoke" })
	public void TS001_TC005() throws Exception {
		
		driver.manage().window().maximize();

		Thread.sleep(Duration.ofMillis(2000));
		
		// Create object of page classes that are in use of current test execution.
		CreateAnAccountPage CreateAccount=new CreateAnAccountPage(driver);
		
		//Create object of XLUtil class to read test data from testdata.xlsx.
		Map<String, String> TestData=XLUtils.getDataForTest("TS001_TC005", "Sheet1");
		
		/* Test steps */
		
		//Step1
		driver.get(TestData.get("TestURL"));
		logger1.info("Launched Create An Account page");
		test.info("Launched Create An Account page");
		
		Thread.sleep(3000);
		
		CreateAccount.SetPasswordTextbox(TestData.get("Password"));
		logger1.info("Entered password in Password textbox");
		test.info("Entered any string in Password testbox");
		
		Thread.sleep(3000);
		
		//Entered text into text-box goes into "value" attribute of that textbox.
		System.out.println(driver.findElement(By.xpath("//*[@id='password']")).getAttribute("value"));
		
		//Step2: Check value entered is entered in encrypted form i.e. ******* form.
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='password']")).getAttribute("type").equals("password"),true);
		logger1.info("Entered password in Password textbox is in encrypted form i.e. masked form");
		test.info("Entered password in Password textbox is in encrypted form i.e. masked form");
		
	}
	
	
}
