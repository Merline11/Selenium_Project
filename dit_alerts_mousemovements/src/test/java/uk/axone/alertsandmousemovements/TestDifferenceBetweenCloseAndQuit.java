package uk.axone.alertsandmousemovements;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestDifferenceBetweenCloseAndQuit {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/jquery-download-progress-bar-demo.html");
        Thread.sleep(5000);
    }

    @Test
    public void testDifferenceBetweenCloseAndQuit() throws InterruptedException {
        driver.findElement(By.linkText("Others")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Shopping Cart")).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
