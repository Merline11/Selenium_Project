package uk.axone.assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
        driver.get("http://uitest.automationtester.uk/bootstrap-dual-list-box-demo.html");
        Thread.sleep(2000);
    }

    @Test
    public void testHandleSlider() throws InterruptedException {
        driver.findElement(By.name("SearchDualList")).sendKeys("bootstrap");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[starts-with(text(),'bootstrap')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[2]")).click();

        WebElement to = driver.findElement(By.xpath("//li[starts-with(text(),'bootstrap')]"));
        Assert.assertEquals(to.getText(),"bootstrap-duallist");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
