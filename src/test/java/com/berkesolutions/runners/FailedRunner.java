package com.berkesolutions.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "@target/failed.txt",
		glue = "com.berkesolutions.steps" 
		
		/*
		plugin = {
					"rerun:target/failed.txt"
				}
		*/
		)

public class FailedRunner {

}
