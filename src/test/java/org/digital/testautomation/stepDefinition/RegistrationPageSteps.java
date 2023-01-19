package org.digital.testautomation.stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.digital.testautomation.manager.BrowserManager;
import org.digital.testautomation.pageobjects.RegistrationPage;
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

public class RegistrationPageSteps extends BrowserManager{
	
	WebDriver driver = BrowserManager.getDriver();
	RegistrationPage registrationPage = new RegistrationPage(driver);
	private static final Logger logger = LogManager.getLogger(RegistrationPageSteps.class);
	
	@Then("^verify title of the Registration page$")
	public void user_verify_title_of_the_page() throws Throwable {
		Boolean title = registrationPage.verify_Registration_Page_Is_Displayed(); 
		Assert.assertTrue("Registration page is not displayed", title);
		logger.info("Registration page is displayed");
	}
	
	@And("^user enter \"([^\"]*)\" and \"([^\"]*)\" on the page$")
	public void user_enter_username_and_password_on_the_registration_page(String username, String password) throws Throwable {
		registrationPage = new RegistrationPage(driver);
		registrationPage.enter_Credentials(username, password);
		logger.info("User has successfully entered username and password details");
	}
	
	@And("^user enters \"([^\"]*)\" and \"([^\"]*)\" on the page$")
	public void user_enter_further_details_on_the_registration_page(String fullname, String email) throws Throwable {
		registrationPage.enter_FullName(fullname);
		registrationPage.enter_Email(email);
		logger.info("User has successfully entered fullname and email details");
	}
	
	@And("^user verify whether Remember is already selected$")
	public void user_verify_whether_Remember_is_already_selected() throws Throwable {
	    Boolean isChecked = registrationPage.verify_Remember_Me_is_selected(); 
	    Assert.assertTrue("Remember Me is not selected", isChecked);
	    logger.info("Remember Me is already selected");
	}
	
	@And("^user click on the Register button$")
	public void user_click_on_the_button() throws Throwable {
		registrationPage.click_on_Register_button();
		logger.info("User has successfully clicked on Register button");
	}
	
	@And("^user verify whether Remember is not selected$")
	public void user_verify_whether_Remember_is_not_selected() throws Throwable {
	    Boolean isChecked = registrationPage.verify_Remember_Me_is_selected(); 
	    Assert.assertFalse("Remember Me is already selected", isChecked);
	    logger.info("Remember Me is not selected");
	}
	
	@And("^user click on the checkbox Remember Me$")
	public void user_click_on_the_checkbox() throws Throwable {
		registrationPage.click_on_Remember_Me_checkbox();
		logger.info("User has successfully clicked on Remember Me checkbox");
	}
	
	@Then("^verify user is successfully logged$")
	public void verify_user_is_successfully_logged() throws Throwable {
		String username =  registrationPage.verify_username_after_registration();
		Assert.assertTrue("User name is incorrect",username.equalsIgnoreCase("Ankit"));
		logger.info("User has successfully logged In");
	}
	
}
