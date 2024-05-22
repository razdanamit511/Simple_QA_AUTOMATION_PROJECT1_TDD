package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage {

	WebDriver driver;

	/* WebElement / Page objects */

	// Element 1: First Name Label
	@FindBy(xpath = "//*[@id='form-validate']/fieldset[1]/div[1]/label/span")
	WebElement FirstNameLabel;

	// Element 2: First Name Text box
	@FindBy(xpath = "//*[@id='firstname']")
	WebElement FirstNameTextbox;

	// Element 3: Last Name Label
	@FindBy(xpath = "//*[@id='form-validate']/fieldset[1]/div[2]/label/span")
	WebElement LastNameLabel;

	// Element 4: Last Name Text box
	@FindBy(xpath = "//*[@id='lastname']")
	WebElement LastNameTextbox;

	@FindBy(xpath = "//*[@id='form-validate']/fieldset[2]/div[1]/label/span")
	WebElement EmailLabel;

	@FindBy(xpath = "//*[@id='email_address']")
	WebElement EmailTextbox;

	@FindBy(xpath = "//*[@id='form-validate']/fieldset[2]/div[2]/label/span")
	WebElement PasswordLabel;

	@FindBy(xpath = "//*[@id='password']")
	WebElement PasswordTextbox;

	@FindBy(xpath = "//*[@id='form-validate']/fieldset[2]/div[3]/label/span")
	WebElement ConfirmPasswordLabel;

	@FindBy(xpath = "//*[@id='password-confirmation']")
	WebElement ConfirmPasswordTextbox;

	@FindBy(xpath = "//*[@id='form-validate']/div/div[1]/button")
	WebElement CreateAnAccountButton;

	@FindBy(xpath = "//*[@id='password-error']")
	WebElement PasswordWarningPlaceholder;
	
	@FindBy(xpath = "//*[@id='email_address-error']")
	WebElement MandatoryEmailMessage;
	
	@FindBy(xpath = "//*[@id='password-error']")
	WebElement MandatoryPasswordMessage;
	
	@FindBy(xpath = "//*[@id=\"firstname-error\"]")
	WebElement MandatoryFirstNameMessage;
	
	@FindBy(xpath = "//*[@id=\"lastname-error\"]")
	WebElement MandatoryLastNameMessage;
	
	@FindBy(xpath = "//*[@id=\"password-confirmation-error\"]")
	WebElement MandatoryConfirmPassMessage;


	@FindBy(xpath = "//*[@id=\"search\"]")
	WebElement SearchTextbox;


	@FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[2]/button")
	WebElement SearchIconSearchTextBox;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span")
	WebElement SearchResultsLabel;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div")
	WebElement NoSearchResultsMessage;
	
	
	/* Constructor to initialize web driver all web-elements defined above */
	public CreateAnAccountPage(WebDriver driver) {
		// This initElements method will create all WebElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* Action Methods */

	// Method 1
	public String GetEmailLabel() {

		return EmailLabel.getText();

	}

	// Method 2
	public String GetPasswordLabel() {

		return PasswordLabel.getText();

	}	
	
	public String GetEmailTextbox() {

		return EmailTextbox.getText();

	}	
	
	
	// Method 3
	public String GetFirstNameLabel() {

		return FirstNameLabel.getText();

	}

	// Method 4
	public String GetLastNameLabel() {

		return LastNameLabel.getText();

	}

	// Method 5
	public String GetConfirmPasswordLabel() {
		return ConfirmPasswordLabel.getText();
	}
	

	// Method 5
	public String GetPasswordWarningPlaceholder() {
		return PasswordWarningPlaceholder.getText();
	}

	
	public void SetFirstNameTextbox(String FirstName) {
		
		FirstNameTextbox.sendKeys(FirstName);
		
	}
	
	public void SetLastNameTextbox(String LastName) {
		LastNameTextbox.sendKeys(LastName);
	}
	
	
	public void SetEmailTextbox(String Email) {
		
		EmailTextbox.sendKeys(Email);
		
	}
	
	public void SetPasswordTextbox(String Password) {
		PasswordTextbox.sendKeys(Password);
	}
	
	public void SetConfirmPasswordTextbox(String ConfirmPassword) {
		ConfirmPasswordTextbox.sendKeys(ConfirmPassword);
	}
	
	//Method 6
	public void ClickCreateAnAccountButton() {
		CreateAnAccountButton.click();
	}
	
	
	//Method 6
	public boolean CheckEmailTextboxPresence() {
		return EmailTextbox.isDisplayed();
	}
	
	//Method 7
	public boolean CheckPasswordTextboxPresence() {
		return PasswordTextbox.isDisplayed();
	}
	
	//Method 8
	public boolean CheckCreateAnAccountButtonPresence() {
		return CreateAnAccountButton.isDisplayed();
	}
	
	public boolean CheckPresenceOfMandatoryErrorEmail() {
		return MandatoryEmailMessage.isDisplayed();
	}
	
	public boolean CheckPresenceOfMandatoryErrorPassword() {
		return MandatoryPasswordMessage.isDisplayed();
	}
	
	
	public boolean CheckPresenceOfMandatoryErrorFirstName() {
		return MandatoryFirstNameMessage.isDisplayed();
	}
	
	public boolean CheckPresenceOfMandatoryErrorLastName() {
		return MandatoryLastNameMessage.isDisplayed();
	}
	
	
	public boolean CheckPresenceOfMandatoryErrorConfirmPass() {
		return MandatoryConfirmPassMessage.isDisplayed();
	}
	
	
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
