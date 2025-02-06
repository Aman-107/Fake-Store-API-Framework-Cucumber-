package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src//test//java//Features//FakeStoreAPIValidation.feature",
glue= {"StepDefinations"})
public class TestRunner {
	
}
