package uk.axone.assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Question5 {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/bootstrap-download-progress-demo.html");
        Thread.sleep(2000);
    }

    @Test
    public void testSynchronizationOnDownloadProgress() throws InterruptedException {
        driver.findElement(By.id("cricle-btn")).click();
        Thread.sleep(2000);
        boolean result = waitUntilFullDownloadable(driver,100,driver.findElement(By.cssSelector(".percenttext")));
        Assert.assertTrue(result,"Test is passed");
    }

    public boolean waitUntilFullDownloadable(WebDriver driver,long waitTime,WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return wait.until(ExpectedConditions.textToBePresentInElement(webElement,"100%"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
