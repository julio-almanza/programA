package com.fourthsource.cucumberhelloworld.testrunner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "../CucumberHelloWorld/src/main/java/com/fourthsource/cucumberhelloworld/features",
		glue= {"com.fourthsource.cucumberhelloworld.steps"}
		//format = {"pretty", "html:test-outout"}
		)

public class TestRunner {

}
