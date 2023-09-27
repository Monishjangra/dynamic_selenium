package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/featureFiles"},
        glue = {"placeOrder"},
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","html:target/report.html"},
        tags = "not @ignore"
)
public class TestRunner {
	
}