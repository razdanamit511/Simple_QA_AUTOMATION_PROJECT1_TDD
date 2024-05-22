package com.qa.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.BaseTest;

/* This file will act as parent for all other util files. */

/* this will have all utilities like Screenshot taker etc which can be used by any specific utility of class etc */

public class CommonUtils extends BaseTest{

	
	/* Method to capture ss */
	public static String CaptureSS() {
		/* Method for capturing screenshot */
		TakesScreenshot tc = (TakesScreenshot) driver;
		String base64SSVal = tc.getScreenshotAs(OutputType.BASE64);

		System.out.println("SS Saved successfully");
		return base64SSVal;
	}
}
