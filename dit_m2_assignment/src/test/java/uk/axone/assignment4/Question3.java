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

public class Question3 {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/horizontal_slider");
        Thread.sleep(2000);
    }

    @Test
    public void testHandleSlider() throws InterruptedException {
        WebElement slider = driver.findElement(By.xpath("//div[@id='content']/div/div/input"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider,40,10).perform();

        Thread.sleep(2000);

        WebElement range = driver.findElement(By.id("range"));

        Assert.assertEquals("4",range.getText());

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
