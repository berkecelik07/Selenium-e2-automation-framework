package com.berkesolutions.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		// we can specify which feature/features to run
		features = "src/test/resources/features/",

		// we can specify where the codes for the features are
		glue = "com.berkesolutions.steps",

		// if true, it does not run the java functionality in the steps. Only checks the
		// feature files
		// and if all the steps there are implemented.
		dryRun = false,

		monochrome = true,

		tags = "@Login",
		
		plugin = {
					// Prints the run Gherkin scenario(s) steps to the console
					"pretty", 
					
					// Creates and saves a basic html report in the target folder 
					"html:target/cucumber-default-report.html",
					
					// Stores all the executed steps in a json file
					"json:target/cucumber.json"
				
					}
		
		)

public class TestRunner {

}
