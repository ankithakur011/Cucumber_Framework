package org.digital.testautomation.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author ANKIT THAKUR
 * This class will contain all the objects and method of landing page of the application
 */

public class LandingPage {
	
	protected WebDriver driver;
	protected JavascriptExecutor jsx;
	protected WebDriverWait wait;
	protected static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LandingPage.class);
	
	//Initializing the Page Objects
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		jsx = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	//Page Object
	
	@FindBy (xpath = "//*[@id='mktg_Cookie_button']")
	private WebElement cookie;
	
	@FindBy (xpath = "//*[text()='Register']")
	private WebElement registration_link;
	
	//Page Methods
	
	public String verify_Landing_Page_Is_Displayed() {
		logger.info("Verify Landing Page is Displayed");
		return driver.getTitle();
	}
	
	public void accept_Cookie() {
		logger.info("Accept Browser Cookies");
		Actions action = new Actions(driver);
		action.moveToElement(cookie).build().perform();
		cookie.click();
	}
	
	public void click_On_Register_Link() {
		logger.info("User click on the Register Link");
		wait.until(ExpectedConditions.visibilityOf(registration_link));
		jsx.executeScript("arguments[0].click();",registration_link);
	}
	
	public void triggerAlert(String alertMessage){
		jsx.executeScript("alert('"+alertMessage+"');");
	}
	
}
