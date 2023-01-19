package org.digital.testautomation.stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.digital.testautomation.manager.BrowserManager;
import org.digital.testautomation.pageobjects.LandingPage;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * 
 * @author ANKIT THAKUR
 * This class will contain the step definition of the cucumber steps
 */

public class LandingPageSteps extends BrowserManager{
	
	WebDriver driver = BrowserManager.getDriver();
	LandingPage landingPage = new LandingPage(driver);
	private static final Logger logger = LogManager.getLogger(LandingPageSteps.class);
	
	@Given("^user launches browser in \"([^\"]*)\"$")
	public void user_launches_browser_in(String browserName) throws Throwable {
		BrowserManager.setBrowser(browserName);
		logger.info("Browser is launched");
	}
	
	@And("^user accepts cookie policy$")
	public void user_accepts_cookie_policy() throws Throwable {
		landingPage = new LandingPage(driver);
		landingPage.accept_Cookie();
		logger.info("User has successfully accepted Browser Cookies");
	}
	
	@And("^user verify landing page is displayed$")
	public void verify_Landing_Page_Is_Displayed() throws Throwable {
		String PageTitle = landingPage.verify_Landing_Page_Is_Displayed();
		System.out.println("Landing page title is: "+PageTitle);
		logger.info("Landing page is displayed");
	}
	
	@And("^user click on the Register link$")
	public void user_click_on_the_register_link() throws Throwable {
		landingPage.click_On_Register_Link();
		logger.info("User has successfully clicked on Register Link");
	}
	
	@And("^user click on the Login link$")
	public void user_click_on_the_login_link() throws Throwable {
		landingPage.click_On_Login_Link();
		logger.info("User has successfully clicked on Login Link");
	}
	
}
