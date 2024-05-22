package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.qa.base.BaseTest;

public class SignInPage {

	WebDriver driver;
	
	/* WebElements */
	@FindBy(xpath = "//*[@id='login-form']/fieldset/div[2]/label/span")
	WebElement EmailLabel;

	@FindBy(xpath = "//*[@id='email']")
	WebElement EmailTextbox;

	@FindBy(xpath = "//*[@id='login-form']/fieldset/div[3]/label/span")
	WebElement PasswordLabel;

	@FindBy(xpath = "//*[@id='pass' and @name='login[password]']")
	WebElement PasswordTextbox;

	@FindBy(xpath = "//*[@id='send2']")
	WebElement SignInButton;

	@FindBy(xpath = "//*[@id='login-form']/fieldset/div[4]/div[2]/a")
	WebElement LogoutHyperLink;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
	WebElement ForgotPasswordSuccessMessage;
	
	@FindBy(xpath = "//*[@id=\"search\"]")
	WebElement SearchTextbox;

	@FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[2]/button")
	WebElement SearchIconSearchTextBox;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span")
	WebElement SearchResultsLabel;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div")
	WebElement NoSearchResultsMessage;
	
	
	/* Constructor to initialize webdriver all webelements defined above */
	public SignInPage(WebDriver driver) {
		// This initElements method will create all WebElements
        this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/* Action Methods */
	// Method1
	public String GetEmailLabel() {
		String LabelVal = EmailLabel.getText();
		return LabelVal;
	}

	// Method2
	public void SetEmail(String email) {
		EmailTextbox.sendKeys(email);
	}

	// Method3
	public String GetPasswordLabel() {
		String LabelVal = PasswordLabel.getText();
		return LabelVal;
	}

	// Method4
	public void SetPassword(String password) {
		PasswordTextbox.sendKeys(password);
	}

	// Method5
	public void ClickSignInButton() {
		SignInButton.click();
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
	public boolean CheckSignInButtonPresence() {
		return SignInButton.isDisplayed();
	}

	public boolean CheckLogoutHypelinkPresence() {
		// TODO Auto-generated method stub
		return LogoutHyperLink.isDisplayed();
	}

	public String GetForgotPasswordSuccessMessage() {
		return ForgotPasswordSuccessMessage.getText();
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
