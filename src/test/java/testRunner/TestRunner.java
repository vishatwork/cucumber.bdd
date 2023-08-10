package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/java/features/roverPositioning.feature"},
//		dryRun = true,
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		glue = {"stepDefinitions", "hooks"},
		plugin =  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
