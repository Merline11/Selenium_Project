package uk.axone.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Question3 {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.zoho.eu/");
    }

    @Test
    public void testHowToFetchTypedValueOfEmailAddress1() throws InterruptedException {
      driver.findElement(By.xpath("//a[@class='login']")).click();
      driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("merline@gmail.com");
      System.out.println("The above typed value of the email address :"+driver.findElement(By.xpath("//input[@id='login_id']")).getAttribute("value"));
    }

    @Test
    public void testHowToFetchTypedValueOfEmailAddress2() throws InterruptedException {
        driver.findElement(By.cssSelector(".login")).click();
        driver.findElement(By.cssSelector("#login_id")).sendKeys("merline@gmail.com");
        System.out.println("The above typed value of the email address :"+driver.findElement(By.cssSelector("#login_id")).getAttribute("value"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
