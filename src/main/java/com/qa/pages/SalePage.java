package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalePage {

	WebDriver driver;

	/* WebElements */
	@FindBy(xpath = "//*[@id=\"search\"]")
	WebElement SearchTextbox;

	
	@FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[2]/button")
	WebElement SearchIconSearchTextBox;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span")
	WebElement SearchResultsLabel;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div")
	WebElement NoSearchResultsMessage;
	
	
	/* Constructor to initialize web driver all web-elements defined above */
	public SalePage(WebDriver driver) {
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
	
	public void ClickSearchIconTextbox() {
		SearchIconSearchTextBox.click();
	}

	public String GetSearchResultsLabel() {
		// TODO Auto-generated method stub
		return SearchResultsLabel.getText();
	}

	public String GetNoSearchResultsMessage() {
		// TODO Auto-generated method stub
		return NoSearchResultsMessage.getText();
	}
}
