package uk.axone.Question1;

import io.cucumber.java.en.*;

public class ITTesterStepDefn {

   /* @Given("I am a (.+) tester")
    public void iAmATester(String testerType) {
        System.out.println("I am a " + testerType + " tester");
    }*/

    @Given("I am a {string} tester")
    public void iAmATester(String string) {
        System.out.println("I am a " + string + " tester");
    }

    @When("I {string} my tasks")
    public void iMyTasks(String string) {
        System.out.println("I " + string + " my tasks");
    }

    @And("find {string} bugs")
    public void findBugs(String string) {
        System.out.println("find " + string + " bugs");
    }

    @Then("My Manager {string} me")
    public void myManagerMe(String string) {
        System.out.println("My Manager " + string + " me");
    }

    @But("Developer {string} me")
    public void developerMe(String string) {
        System.out.println("Developer " + string + " me");
    }

    /*@And("I verify the (.+)")
    public void iVerifyTheResult(String outcome) {
        if(outcome.equals("pass")){

        } else if (outcome.equals("fail")) {

        }
    }*/
}
