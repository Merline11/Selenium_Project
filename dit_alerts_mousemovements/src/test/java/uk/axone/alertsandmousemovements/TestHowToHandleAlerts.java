package uk.axone.alertsandmousemovements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class TestHowToHandleAlerts {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/javascript-alert-box-demo.html");
        Thread.sleep(5000);
    }

    @Test
    public void testHandleAlerts1() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Click for Prompt Box')]")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(3000);
        alert.sendKeys("Axone Trainings");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
    }
    @Test
    public void testHandleAlerts2() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Click for Prompt Box')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // alertIsPresent returning driver.switchTo().alert()
        //Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(3000);
        alert.sendKeys("Axone Trainings");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
