package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutShippingPage {
	WebDriver driver;

	/* WebElement / Page objects */

	// Element 1: First Name Label
	@FindBy(xpath = "//*[@id=\"shipping\"]/div[1]")
	WebElement ShippingLabel;

	// Element 2: First Name Label
	@FindBy(xpath = "//*[@id=\"shipping-new-address-form\"]/div[1]/label/span")
	WebElement FirstNameLabel;

	// Element 2: First Name Text box
	@FindBy(xpath = "//*[@id=\"YQVKTPO\"]")
	WebElement FirstNameTextbox;

	// Element 3: Last Name Label
	@FindBy(xpath = "//*[@id=\"shipping-new-address-form\"]/div[2]/label/span")
	WebElement LastNameLabel;

	// Element 4: Last Name Text box
	@FindBy(xpath = "//*[@id=\"U8CJVI5\"]")
	WebElement LastNameTextbox;

	@FindBy(xpath = "//*[@id=\"shipping-new-address-form\"]/fieldset/legend/span")
	WebElement StreetAddress;

	@FindBy(xpath = "//*[@id=\"BP1Y7HP\"]")
	WebElement StreetAddressTextbox;

	@FindBy(xpath = "//*[@id=\"shipping-new-address-form\"]/div[4]/label/span")
	WebElement CityLabel;

	@FindBy(xpath = "//*[@id=\"MYY3D38\"]")
	WebElement CityTextbox;

	@FindBy(xpath = "//*[@id=\"shipping-new-address-form\"]/div[5]/label/span")
	WebElement StateProvinceLabel;

	@FindBy(xpath = "//*[@id=\"BYI9534\"]")
	WebElement StateProvinceDropdown;

	@FindBy(xpath = "//*[@id=\"shipping-new-address-form\"]/div[7]/label/span")
	WebElement ZipCodeLabel;

	@FindBy(xpath = "//*[@id=\"ND3UCW2\"]")
	WebElement ZipCodeTextbox;

	@FindBy(xpath = "//*[@id=\"shipping-new-address-form\"]/div[8]/label/span")
	WebElement CountryLabel;

	@FindBy(xpath = "//*[@id=\"IJPG38C\"]")
	WebElement CountryDropdown;

	@FindBy(xpath = "//*[@id=\"shipping-new-address-form\"]/div[9]/label/span")
	WebElement PhoneNumberLabel;

	@FindBy(xpath = "//*[@id=\"R7OLGWY\"]")
	WebElement PhoneNumberTextbox;

	@FindBy(xpath = "//*[@id=\"opc-shipping_method\"]/div/div[1]")
	WebElement ShippingMethodsLabel;

	@FindBy(xpath = "//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input")
	WebElement ShippingMethod1RadioButton;

	@FindBy(xpath = "//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[2]/td[1]/input")
	WebElement ShippingMethod2RadioButton;

	@FindBy(xpath = "//*[@id=\"customer-email-fieldset\"]/div/label/span")
	WebElement EmailLabel;

	@FindBy(xpath = "//*[@id=\"customer-email-fieldset\"]/div //*[@id=\"customer-email\"]")
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

	@FindBy(xpath = "//*[@id='search']")
	WebElement SearchTextbox;

	@FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[2]/button")
	WebElement SearchIconSearchTextBox;

	/* Constructor to initialize web driver all web elements defined above */
	public CheckoutShippingPage(WebDriver driver) {
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

	// Method 6
	public void ClickCreateAnAccountButton() {
		CreateAnAccountButton.click();
	}

	// Method 6
	public boolean CheckEmailTextboxPresence() {
		return EmailTextbox.isDisplayed();
	}

	// Method 7
	public boolean CheckPasswordTextboxPresence() {
		return PasswordTextbox.isDisplayed();
	}

	// Method 8
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

	public boolean GetDefaultValSearchTextbox() {
		return SearchTextbox.getAttribute("value").isEmpty();
	}

	public boolean GetStateSearchIconSearchTextbox() {
		return SearchIconSearchTextBox.isEnabled();
	}

	public void SetSearchTextbox(String str) {
		SearchTextbox.sendKeys(str);
	}

	public String GetShippingAddressLabel() {
		return ShippingLabel.getText();
	}

	public String GetEmailAddessLabel() {
		return EmailLabel.getText();
	}

	public void SetEmailAddessTextbox(String str) {
		EmailTextbox.sendKeys(str);
		;
	}

	public String GetStreetAddressLabel() {
		return StreetAddress.getText();
	}

	public void SetStreetAddressTextbox(String str) {
		StreetAddressTextbox.sendKeys(str);
	}

	public String GetCityLabel() {
		return CityLabel.getText();
	}

	public void SetCityTextbox(String str) {
		CityTextbox.sendKeys(str);
	}

	public String GetStateProvinceLabel() {
		return StateProvinceLabel.getText();
	}

	public void SetStateProvinceDropdown(String str) {
		Select options = new Select(StateProvinceDropdown);
		options.selectByValue(str);
	}

	public String GetZipCodeLabel() {
		return ZipCodeLabel.getText();
	}

	public void SetZipCodeTextbox(String str) {
		ZipCodeTextbox.sendKeys(str);
	}

	public String GetCountryLabel() {
		return CountryLabel.getText();
	}

	public void SetCountryDropdown(String str) {
		Select options = new Select(CountryDropdown);
		options.selectByValue(str);
	}

	public String GetPhoneNumberLabel() {
		return PhoneNumberLabel.getText();
	}

	public void SetGetPhoneNumberTextbox(String str) {
		PhoneNumberTextbox.sendKeys(str);
	}

	public void GetShippingMethodsLabel() {
		ShippingMethodsLabel.getText();
	}

	public void SetShippingMethods(int option) {

		if (option == 1) {
			ShippingMethod1RadioButton.click();
		} else if (option == 2) {
			ShippingMethod2RadioButton.click();
		} else {
			System.out.println("Invalid option for Shipping Methods.");
		}
	}

}
