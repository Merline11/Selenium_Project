package uk.axone.bdd.stepdefinitions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UserLoginStepDefn {

    WebDriver driver = new ChromeDriver();


    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        System.out.println("user is on the homepage");
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @When("user navigates to signin page")
    public void user_navigates_to_signin_page() {
        System.out.println("user navigates to signin page");
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
    }
    @And("user enters login credentials")
    public void user_enters_login_credentials() {
        System.out.println("user enters login credentials");
        driver.findElement(By.id("email")).sendKeys("karthik@axone-tech.uk");
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

        driver.findElement(By.id("passwd")).sendKeys("password");
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

        driver.findElement(By.id("SubmitLogin")).click();
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
    }
    @Then("user is logged in successfully")
    public void user_is_logged_in_successfully() {
        System.out.println("user is logged in successfully");
        Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'My account')]")).getText(),"MY ACCOUNT");
    }
}
