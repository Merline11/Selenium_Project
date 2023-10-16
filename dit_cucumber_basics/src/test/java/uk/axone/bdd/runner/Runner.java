package uk.axone.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/UserLogin.feature",
        glue = {"uk.axone.bdd.stepdefinitions"},
        plugin = {"html: AxoneTestResults.html"},
        publish = true
)
public class Runner {
}
