package com.org.testrunner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\AlbertoVillaRomero\\eclipse-workspace\\CucumberHelloWorld\\src\\main\\java\\com\\org\\features",
		glue= {"com.org.steps"}
		//format = {"pretty", "html:test-outout"}
		)

public class TestRunner {

}
