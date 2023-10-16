package uk.axone.Question2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDefn {

    @Given("I am on axone-tech.co.uk registration page")
    public void iAmOnAxoneTechCoUkRegistrationPage() {
        System.out.println("I am on axone-tech.co.uk registration page");
    }

    @When("I enter username {string}")
    public void iEnterUsername(String string) {
        System.out.println("I enter username " + string);
    }

    @And("I enter password {int}")
    public void iEnterPassword(Integer int1) {
        System.out.println("I enter password " + int1);
    }

    @And("I enter mobilenumber {int}")
    public void iEnterMobilenumber(Integer int1) {
        System.out.println("I enter mobilenumber " + int1);
    }

    @Then("registration should be {string}")
    public void registrationShouldBe(String string) {
        System.out.println("registration should be " + string);
    }

}
