package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	WebDriver driver;

	/* WebElements */

	// Element 1
	@FindBy(xpath = "//*[@id='maincontent']/div[1]/h1/span")
	WebElement ForgotPasswordLabel;

	// Element 2
	@FindBy(xpath = "//*[@id='form-validate']/fieldset/div[1]")
	WebElement InfoMessage;

	// Element 3
	@FindBy(xpath = "//*[@id='form-validate']/fieldset/div[2]/label/span")
	WebElement EmailLabel;

	@FindBy(xpath = "//*[@id=\"email_address\"]")
	WebElement EmailTextbox;

	@FindBy(xpath = "//*[@id='form-validate']/div/div[1]/button")
	WebElement ResetMyPasswordButton;

	@FindBy(xpath = "//*[@id=\"email_address-error\"]")
	WebElement ErrorMessageEmail;
	

	
	/* Constructor */
	public ForgotPasswordPage(WebDriver driver) {
		// This initElements method will create all WebElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* Action Methods */

	// Method 1
	public String GetForgotPasswordLabel() {
		return ForgotPasswordLabel.getText();
	}

	// Method 2
	public String GetInfoMessageLabel() {
		return InfoMessage.getText();
	}

	// Method 3
	public String GetEmailLabel() {
		return InfoMessage.getText();
	}

	// Method 4
	public void SetEmailTextbox(String email) {
		EmailTextbox.sendKeys(email);
	}

	// Method 5
	public void ClickResetMyPasswordButton() {
		ResetMyPasswordButton.click();
	}

	// Method 6
	public boolean CheckPresenceForgotPasswordLabel() {
		return ForgotPasswordLabel.isDisplayed();
	}

	// Method 7
	public boolean CheckPresenceInfoMessage() {
		return InfoMessage.isDisplayed();
	}

	// Method 8
	public boolean CheckPresenceEmailLabel() {
		return EmailLabel.isDisplayed();
	}

	// Method 9
	public boolean CheckPresenceEmailTextbox() {
		return EmailTextbox.isDisplayed();
	}

	// Method 10
	public boolean CheckPresenceResetMyPasswordButton() {
		return ResetMyPasswordButton.isDisplayed();
	}
	
	public boolean CheckPresenceErrorMessage() {
		return ErrorMessageEmail.isDisplayed();
	}
	
	public String CheckErrorMessageValueEmailTextbox() {
		return ErrorMessageEmail.getText();
	}
	
}
