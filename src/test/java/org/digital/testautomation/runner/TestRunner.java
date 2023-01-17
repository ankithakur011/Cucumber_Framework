package org.digital.testautomation.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * 
 * @author ANKIT THAKUR
 * This is the JUnit runner class for the project
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        
		features = { "src/test/resources/Features" },
		glue = {"org.digital.testautomation.stepDefinition"} ,
		plugin = {
				"pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"html:target/cucumber-reports/CucumberTestReport.xml",
				},
        monochrome = true,
        tags = "@Tag",
        dryRun = false
        
	)

public class TestRunner {


}
