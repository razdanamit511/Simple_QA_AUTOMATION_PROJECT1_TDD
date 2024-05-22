package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishlistPage {
	WebDriver driver;

	/* WebElements */
	WebElement ForgotPasswordSuccessMessage;

	@FindBy(xpath = "//*[@id=\"search\"]")
	WebElement SearchTextbox;

	
	@FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[2]/button")
	WebElement SearchIconSearchTextBox;
	
	/* Constructor to initialize web driver all web elements defined above */
	public MyWishlistPage(WebDriver driver) {
		// This initElements method will create all WebElements
        this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/* Action Methods */

	public boolean CheckPresenceSearchTextbox() {
		return SearchTextbox.isDisplayed();
	}
	
	public boolean GetDefaultValSearchTextbox() {
		return SearchTextbox.getAttribute("value").isEmpty();
	}

	public boolean GetStateSearchIconSearchTextbox() {
		return SearchIconSearchTextBox.isEnabled();
	}

	public void SetSearchTextbox(String str) {
		SearchTextbox.sendKeys(str);
	}
}
