package uk.axone.testng;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features= "src/test/resources/testng/testng.feature",
        glue = "uk.axone.testng",
        plugin = {
                "html:target/AxoneCucumberTestNGReport",
                "pretty",
                "summary"
        },
        snippets= CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false, // dryRun=true -> to check feature steps have corresponding step definitions
        //strict = false, // //strict = true ->if undefined and pending steps should be treated as errors
        monochrome = false

)
public class TestNGRunner extends AbstractTestNGCucumberTests { // bdd using test ng by extending AbstractTestNGCucumberTests
}
