package testRunner;

import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features/", plugin = { "json:target/cucumber-reports/cucumber.json",
		"pretty", "html:target/html-report/cucumber-html-reports.html",
		"junit:target/cucumber-reports/cucumber.xml" }, glue = {
				"StepDefination" }, tags = "@Sample123", monochrome = true)
public class TestRunner {

//@tags= {"@DeletePlace"}  
}