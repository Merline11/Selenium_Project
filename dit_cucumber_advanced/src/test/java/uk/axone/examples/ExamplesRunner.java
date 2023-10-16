package uk.axone.examples;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features= "src/test/resources/examples/examples.feature",
        glue = "uk.axone.examples",
        plugin = {
                "html:target/AxoneCucumberExamplesReport",
                "pretty",
                "summary"
        },
        snippets= CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false, // dryRun=true -> to check feature steps have corresponding step definitions
        //strict = false, // //strict = true ->if undefined and pending steps should be treated as errors
        monochrome = false,
        //tags= "@billing and not @E2ETest"
        //tags= "@billing and not @RegressionTest"
        tags= "@RegressionTest and @E2ETest"

)
public class ExamplesRunner extends AbstractTestNGCucumberTests { // bdd using test ng by extending AbstractTestNGCucumberTests
}
