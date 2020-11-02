package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = false, plugin = { "html:target/cucumber-html-report", "json:target/cucumber.json",
        "pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
        "junit:target/cucumber-results.xml" }, features = "src/test/resources/features", glue = { "stepDefinitions" })
public class TestRunner {

}
