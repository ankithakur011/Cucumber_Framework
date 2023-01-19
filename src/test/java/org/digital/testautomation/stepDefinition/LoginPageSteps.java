package org.digital.testautomation.stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.digital.testautomation.manager.BrowserManager;
import org.digital.testautomation.pageobjects.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * 
 * @author ANKIT THAKUR
 * This class will contain the step definition of the cucumber steps
 */

public class LoginPageSteps extends BrowserManager{
	
	WebDriver driver = BrowserManager.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	private static final Logger logger = LogManager.getLogger(LoginPageSteps.class);
	
	@Then("^verify title of the Login page$")
	public void user_verify_title_of_the_login_page() throws Throwable {
		Assert.assertTrue("Login page is not displayed", loginPage.verify_Login_Page_Is_Displayed());
		logger.info("Login page is displayed");
	}
	
	@And("^user click on the Login button$")
	public void user_click_on_the_Login_button() throws Throwable {
		loginPage.click_on_Login_button();
		logger.info("User has successfully clicked on Login button");
	}
	
}
