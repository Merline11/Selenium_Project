package uk.axone.examples;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class  ExamplesStepDefn {

    @Given("there are {int} cucumbers")
    public void thereAreCucumbers(Integer int1) {

    }
    @When("I eat {int} cucumbers")
    public void iEatCucumbers(Integer int1) {

    }
    @Then("I should have {int} cucumbers")
    public void iShouldHaveCucumbers(Integer int1) {

    }

    @But("I should not have {int} cucumbers")
    public void iShouldNotHaveCucumbers(Integer int1) {

    }

    @Before(order = 0)
    public void beforeClass(){
        System.out.println("I am inside beforeClass method");
    }

    @Before(order = 1)
    public void beforeScenario(){
        System.out.println("I am inside beforeScenario method");
    }

    @Before(order = 2)
    public void beforeTest(){
        System.out.println("I am inside beforeTest method");
    }

    @After(order = 0)
    public void afterClass(){
        System.out.println("I am inside afterClass method");
    }

    @After(order = 1)
    public void afterScenario(){
        System.out.println("I am inside afterScenario method");
    }

    @After(order = 2)
    public void afterTest(){
        System.out.println("I am inside afterTest method");
    }



}
