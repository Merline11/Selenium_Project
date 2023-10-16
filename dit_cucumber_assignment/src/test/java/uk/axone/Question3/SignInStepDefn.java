package uk.axone.Question3;

import com.google.common.util.concurrent.Uninterruptibles;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SignInStepDefn {

    WebDriver driver;

    @Given("a browser is launched")
    public void aBrowserIsLaunched() {
        driver = new ChromeDriver();
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @And("Registration and creating an account")
    public void registrationAndCreatingAnAccount() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        driver.findElement(By.id("email_create")).sendKeys("merline9@gmail.com");
        driver.findElement(By.id("SubmitCreate")).click();
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Merline");
        driver.findElement(By.id("customer_lastname")).sendKeys("Jayaraj");
        driver.findElement(By.id("passwd")).sendKeys("12345");
        driver.findElement(By.id("submitAccount")).click();
        driver.findElement(By.linkText("Sign out")).click();
        Thread.sleep(2000);
    }

    @And("user is on the homepage")
    public void user_is_on_the_homepage() {
        System.out.println("user is on the homepage");
    }

    @When("user clicks Sign-in link")
    public void userClicksSignInLink() {
        System.out.println("user navigates to signin page");
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
    }

    @And("user enters login credentials")
    public void user_enters_login_credentials() {
        System.out.println("user enters login credentials");
        driver.findElement(By.id("email")).sendKeys("merline9@gmail.com");
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

        driver.findElement(By.id("passwd")).sendKeys("12345");
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

        driver.findElement(By.id("SubmitLogin")).click();
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
    }

    @Then("user should see name appears in Top menu")
    public void userShouldSeeNameAppearsInTopMenu() {
        System.out.println("user is logged in successfully");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")).getText(), "Merline Jayaraj");
    }

    @When("user clicks Logout")
    public void userClicksLogout() {
        System.out.println("user is logged out successfully");
        driver.findElement(By.linkText("Sign out")).click();
    }
    @Then("user should see Sign-in link")
    public void userShouldSeeSignInLink() {
        System.out.println("user able to see Sign in link");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).getText(), "Sign in");
    }
}
