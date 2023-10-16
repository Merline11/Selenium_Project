package uk.axone.managingguiconrols;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHandlingLinkText {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.bbc.co.uk/");
        Thread.sleep(5000);
    }

    @Test
    public void testHandlingLinkText() throws InterruptedException {
        driver.findElement(By.linkText("News")).click();
        Thread.sleep(3000);
    }

    @Test
    public void testHandlingPartialLinkText() throws InterruptedException {
        driver.findElement(By.linkText("News")).click();
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Guns N Roses")).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
