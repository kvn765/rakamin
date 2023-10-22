package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"pretty"})
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/homework", // Location of your feature files
        glue = "homework.cucumber.stepdefs"       // Package where your step definitions are located
)

public class run {
}
