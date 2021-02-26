package org.digital.testautomation.pageobjects;

import org.openqa.selenium.By;
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
 * This class will contain all the objects and method of Registration page of the application
 */

public class RegistrationPage {
	
	WebDriver driver;
	public JavascriptExecutor jsx;
	public WebDriverWait wait;
	protected static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegistrationPage.class);
	
	//Initializing the Page Objects
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		jsx = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	//Page Objects
	
	@FindBy (xpath = "//*[@id='userRegistrationContainer']//h1']")
	private WebElement registration_Header;
	
	@FindBy (xpath = "//*[@id='logonId']")
	private WebElement registration_username;
	
	@FindBy (xpath = "//*[@id='logonPassword']")
	private WebElement registration_password;
	
	@FindBy (xpath = "//*[@id='firstName']")
	private WebElement registration_fullname;
	
	@FindBy (xpath = "//*[@id='email1']")
	private WebElement registration_email;
	
	@FindBy (xpath = "//*[@id='rememberMe']")
	private WebElement remember_Me;
	
	@FindBy (xpath = "//*[@id='registerValidate']")
	private WebElement register_Button;
	
	@FindBy (xpath = "//*[@class='userFirstNameLoggedInn']")
	private WebElement username;
	
	//Page Methods
	
	public boolean verify_Registration_Page_Is_Displayed() {
		logger.info("Verify Registration Page is Displayed");
		return registration_Header.getText().equals("Register");
	}
	
	public void enter_Credentials(String username, String password) {
		logger.info("User enter credentials");
		registration_username.sendKeys(username);
		registration_password.sendKeys(password);	
	}
		 
	public void enter_FullName(String fullname) {
		logger.info("User enter Full name: "+fullname); 
		registration_fullname.sendKeys(fullname);
	}
	
	public void enter_Email(String emailaddress) {
		logger.info("User enter email: "+emailaddress);
		registration_email.sendKeys(emailaddress);
	}
	
	public boolean verify_Remember_Me_is_selected() {
		logger.info("Verify whether remember is selected");
		return driver.findElement((By) remember_Me).isSelected();
	}
	
	public void click_on_Remember_Me_checkbox() {
		logger.info("Click on Remember Me checkbox");
		wait.until(ExpectedConditions.visibilityOf(remember_Me));
		((JavascriptExecutor) jsx).executeScript("arguments[0].click();",remember_Me);
	}
	
	public void click_on_Register_button() {
		logger.info("Click on Register button");
		wait.until(ExpectedConditions.visibilityOf(register_Button));
		((JavascriptExecutor) jsx).executeScript("arguments[0].click();",register_Button);
	}
	
	public String verify_username_after_registration() {
		logger.info("Verify User name is displayed");
		wait.until(ExpectedConditions.visibilityOf(username));
		return username.getText();
	}
	
}
