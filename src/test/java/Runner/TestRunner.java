package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src//test//java//Features//FakeStoreAPIValidation.feature",
plugin="json:target/jsonReports/FakeStoreReports.json",glue= {"StepDefinations"})
public class TestRunner {
	
}
