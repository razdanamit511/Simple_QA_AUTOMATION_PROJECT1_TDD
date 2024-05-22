package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPaymentsPage {

	WebDriver driver;

	/* WebElement / Page objects */
	
	@FindBy(xpath = "//*[@id=\"search\"]")
	WebElement SearchTextbox;

	@FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[2]/button")
	WebElement SearchIconSearchTextBox;
	
	/* COnstructor */
	public CheckoutPaymentsPage(WebDriver driver) {
		// This initElements method will create all WebElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/* Action Methods */
	
	//Method 1
	public boolean CheckPresenceSearchTextbox() {
		boolean res = false;
		try {
			if (SearchTextbox.isDisplayed())
				res = true;
		} catch (Exception e) {

			System.out.println(e);
			res = false;
		} finally {
			return res;
		}

	}
}
