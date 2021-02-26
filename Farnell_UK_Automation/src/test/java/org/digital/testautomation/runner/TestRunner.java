package org.digital.testautomation.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * 
 * @author ANKIT THAKUR
 * This is the JUnit runner class for the project
 */

@RunWith(Cucumber.class)
@CucumberOptions( plugin = {"json:target/cucumber.json","html:target/HtmlReports","pretty"}, features = "Feature", monochrome = true,
				glue = {"org.digital.testautomation.stepDefinition"} ,tags = {"@Registration", "@Test_Id_01"}, dryRun = false )

public class TestRunner {


}
