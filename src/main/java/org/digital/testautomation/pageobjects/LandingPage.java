package org.digital.testautomation.pageobjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.digital.testautomation.manager.BrowserManager;
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

public class LandingPage extends BrowserManager{
	
	protected WebDriver driver;
	protected JavascriptExecutor jsx;
	protected WebDriverWait wait;
	LandingPage landingPage;
	private static final Logger logger = LogManager.getLogger(LandingPage.class);
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	//Initialising the Page Objects
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		jsx = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	//Page Object
	
	@FindBy (xpath = "//*[@id='mktg_Cookie_button']")
	private WebElement cookie;
	
	@FindBy (xpath = "//h1")
	private WebElement landingPage_header;
	
	@FindBy (xpath = "//*[@class='navbar-right hidden-xs']//*[text()='Register']")
	private WebElement registration_link;
	
	@FindBy (xpath = "//*[@class='navbar-right hidden-xs']//*[text()='Login']")
	private WebElement login_link;
	
	//Page Methods
	
	public String verify_Landing_Page_Is_Displayed() {
		logger.info("Verify Landing Page is Displayed");
		wait.until(ExpectedConditions.visibilityOf(landingPage_header));
		return landingPage_header.getText();
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
	
	public void click_On_Login_Link() {
		logger.info("User click on the Login Link");
		wait.until(ExpectedConditions.visibilityOf(registration_link));
		jsx.executeScript("arguments[0].click();",registration_link);
	}
	
	public void triggerAlert(String alertMessage){
		jsx.executeScript("alert('"+alertMessage+"');");
	}
	
}
