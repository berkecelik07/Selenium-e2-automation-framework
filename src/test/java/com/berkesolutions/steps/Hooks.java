/**
 * Hooks class - Cucumber lifecycle management
 * 
 * This class contains Cucumber hooks for test setup and teardown
 * operations that run before and after each scenario.
 * 
 * @author Berke Solutions
 * @version 1.0
 */
package com.berkesolutions.steps;

import com.berkesolutions.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

	/**
	 * Executes before each scenario
	 * Initializes WebDriver and other test prerequisites
	 */
	@Before
	public void start() {
		System.out.println("========================================");
		System.out.println("TEST EXECUTION STARTED");
		System.out.println("========================================");
		setUp();
	}

	/**
	 * Executes after each scenario
	 * Takes screenshots and closes the browser
	 * 
	 * @param scenario - Cucumber Scenario object containing test metadata
	 */
	@After
	public void end(Scenario scenario) {
		System.out.println("========================================");
		System.out.println("TEST EXECUTION FINISHED");
		System.out.println("Scenario Name: " + scenario.getName());
		System.out.println("Scenario Status: " + (scenario.isFailed() ? "FAILED" : "PASSED"));
		System.out.println("========================================");

		// Capture screenshot based on test status
		byte[] picture;

		if (scenario.isFailed()) {
			// For failed tests: save screenshot with "failed/" prefix
			System.out.println("❌ Taking screenshot for failed scenario...");
			picture = takeScreenshot("failed/" + scenario.getName());
		} else {
			// For passed tests: save screenshot with "passed/" prefix
			System.out.println("✅ Taking screenshot for passed scenario...");
			picture = takeScreenshot("passed/" + scenario.getName());
		}

		// Attach screenshot to Cucumber report
		scenario.attach(picture, "image/png", scenario.getName());

		// Clean up and close browser
		tearDown();
	}

}
