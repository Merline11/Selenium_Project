package uk.axone;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features= "src/test/resources/feature",
        glue = "uk.axone",
        plugin = {
                "html:target/ITTesterReport",
                "pretty",
                "summary"
        },
        snippets= CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false, // dryRun=true -> to check feature steps have corresponding step definitions
        //strict = false, // //strict = true ->if undefined and pending steps should be treated as errors
        monochrome = false
        //tags= "@billing and not @E2ETest"
        //tags= "@billing and not @RegressionTest"
       // tags= "not @SmokeTest"

)
public class ITTesterRunner extends AbstractTestNGCucumberTests {
}
