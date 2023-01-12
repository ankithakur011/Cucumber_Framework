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
        
        plugin = {"json:target/cucumber.json","html:target/HtmlReports","pretty"}, 
        features = "Feature",
        monochrome = true,
        glue = {"org.digital.testautomation.stepDefinition"} ,
        tags = "@Tag", 
        dryRun = false )

public class TestRunner {


}
