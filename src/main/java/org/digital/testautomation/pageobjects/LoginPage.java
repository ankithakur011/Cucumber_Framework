package org.digital.testautomation.pageobjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.digital.testautomation.manager.BrowserManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author ANKIT THAKUR
 * This class will contain all the objects and method of Login page of the application
 */

public class LoginPage extends BrowserManager{
	
	WebDriver driver;
	public JavascriptExecutor jsx;
	public WebDriverWait wait;
	private static final Logger logger = LogManager.getLogger(LandingPage.class);
	
	//Initialising the Page Objects
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		jsx = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	//Page Objects
	
	@FindBy (xpath = "//h3[text()='Login']")
	private WebElement login_Header;
	
	@FindBy (xpath = "//button[text()='Login'][1]")
	private WebElement login_Button;
	
	//Page Methods
	
	public boolean verify_Login_Page_Is_Displayed() {
		logger.info("Verify Login Page is Displayed");
		return login_Header.getText().equals("Login");
	}
	
	public void click_on_Login_button() {
		logger.info("Click on Login button");
		wait.until(ExpectedConditions.visibilityOf(login_Button));
		((JavascriptExecutor) jsx).executeScript("arguments[0].click();",login_Button);
	}
	
}
