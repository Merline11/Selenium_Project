package uk.axone.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Question4 {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/basic-first-form-demo.html");
        Thread.sleep(2000);
    }

    @Test //customised css selector
    public void testHowToNavigateFormDemoPage() throws InterruptedException {
        /*driver.findElement(By.cssSelector(".panel-body>ul>li>i")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".panel-body>ul>li>i")).click();
        Thread.sleep(2000);*/
        driver.findElement(By.cssSelector(".panel-body>ul>li:last-of-type>ul>li:first-of-type")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".panel-body>ul>li:last-of-type>ul>li:first-of-type>ul>li:first-of-type>a")).click();
        Thread.sleep(2000);
        testValidateAdditionOperation();
    }

    @Test
    public void testValidateAdditionOperation () throws InterruptedException {
        driver.findElement(By.cssSelector("#sum1")).sendKeys("10");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#sum1")).getAttribute("value");
        driver.findElement(By.cssSelector("#sum2")).sendKeys("20");
        driver.findElement(By.cssSelector("#sum2")).getAttribute("value");
        driver.findElement(By.cssSelector("button[onclick*='total']")).click();
        String total = driver.findElement(By.cssSelector("span[id='displayvalue']")).getText();
        Thread.sleep(2000);
        Assert.assertEquals(30,Integer.parseInt(total));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
