package uk.axone.synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestExplicitWait {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //to handle implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://uitest.automationtester.uk/jquery-download-progress-bar-demo.html");
        Thread.sleep(5000);
    }

    @Test
    public void testExplicitWait() {
        driver.findElement(By.id("downloadButton")).click();
        waitUntilElementIsClickable(driver,10,By.xpath("//button[contains(text(),'Close')]")).click();
    }

    public WebElement waitUntilElementIsClickable(WebDriver driver, long waitTime, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
