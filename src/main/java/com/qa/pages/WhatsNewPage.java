package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhatsNewPage {

	WebDriver driver;

	/* WebElements */
	@FindBy(xpath = "//*[@id=\"search\"]")
	WebElement SearchTextbox;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[1]/div/div")
	WebElement Element1;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[1]/div/div/div[2]/div[1]/div //*[@id=\"option-label-size-143-item-175\"]")
	WebElement Size1Element1;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[1]/div/div/div[2]/div[2]/div //*[@id=\"option-label-color-93-item-50\"]")
	WebElement Color2Element1;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[1]/div/div/div[3]/div/div[1]/form/button")
	WebElement AddToCartButtonElement1;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[1]/div/div/div[3]/div/div[1]/form/button")
	WebElement AddToCartElement1Button1;// To be used for TS005

	@FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
	WebElement CartLink;

	@FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a")
	WebElement ViewAndEditCart;

	@FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[2]/button")
	WebElement SearchIconSearchTextBox;

	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span")
	WebElement SearchResultsLabel;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div")
	WebElement NoSearchResultsMessage;
	
	
	/* Constructor to initialize webdriver all webelements defined above */
	public WhatsNewPage(WebDriver driver) {
		// This initElements method will create all WebElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* Action Methods */

	// Method 1
	public boolean CheckPresenceSearchTextbox() {
		return SearchTextbox.isDisplayed();
	}

	// Method 2
	public void HoverOverElement1() {

		// Instantiating Actions class
		Actions actions = new Actions(driver);

		// Hovering on main menu
		actions.moveToElement(Element1).perform();

	}

	// Method 3
	public void SelectSize1Element1() {

		if (Size1Element1.isDisplayed())
			Size1Element1.click();
		else
			System.out.println("Size if not displayed.");
	}

	// Method 4
	public void SelectColor2Element1() {

		if (Color2Element1.isDisplayed())
			Color2Element1.click();
		else
			System.out.println("Color is not displayed");
	}

	// Method 5
	public void ClickAddToCartElement1Button() {
		AddToCartButtonElement1.click();
	}

	public void ClickCartLink() {
		CartLink.click();
	}

	public void ClickViewAndEditCart() {
		ViewAndEditCart.click();
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

	public void ClickAddToCartButton1Element1() {
		// TODO Auto-generated method stub
		AddToCartElement1Button1.click();
	}

	public String GetSearchResultsLabel() {
		return SearchResultsLabel.getText();
	}

	public void ClickSearchIconTextbox() {
		SearchIconSearchTextBox.click();
	}

	public String GetNoSearchResultsMessage() {
		// TODO Auto-generated method stub
		return NoSearchResultsMessage.getText();
	}
}
