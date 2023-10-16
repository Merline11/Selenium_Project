package uk.axone.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class Question6 {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/basic-first-form-demo.html");
        Thread.sleep(2000);
    }

    @Test //customised XPath selector
    public void testHowToHandleRadioButtons() throws InterruptedException {
        /*driver.findElement(By.xpath("//a[contains(text(),'All Examples')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'All Examples')]")).click();
        Thread.sleep(2000);*/
        driver.findElement(By.xpath("//a[text()='Input Forms']")).click(); //div[@class='panel-body']//following-sibling::ul//li//a[text()='Input Forms']
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='panel-body']//following-sibling::ul//li//a[text()='Radio Buttons Demo']")).click();//not working -->//a[text()='Checkbox Demo']
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Group Radio Buttons Demo']")).click();
        Thread.sleep(2000);
        testHowToFetchAllTheValuesInRadioButton();
    }

    @Test
    public void testHowToFetchAllTheValuesInRadioButton() throws InterruptedException {
        // 1. to identify the radio buttons
        List<WebElement> allAgeGroupRadioButtons = driver.findElements(By.name("ageGroup"));
        // 2. to click specific radio button
       // System.out.println(allAgeGroupRadioButtons.get(0).isSelected());
        allAgeGroupRadioButtons.get(0).click();

        for (WebElement ageGroupRadio : allAgeGroupRadioButtons) {
            System.out.println("Age Group Radio :" + ageGroupRadio.getAttribute("value") + ": is Selected? :" + ageGroupRadio.isSelected());
        }
        testToValidateGetValuesLogic();
    }

    @Test //another test to validate “Get Values” logic.
    public void testToValidateGetValuesLogic () throws InterruptedException {
        driver.findElement(By.xpath("//button[starts-with(@onClick,'getValues')]")).click();
        Thread.sleep(1000);
        List<WebElement> allAgeGroupRadioButtons = driver.findElements(By.name("ageGroup"));
        String value = null;
        for (WebElement ageGroupRadio : allAgeGroupRadioButtons) {
            if (ageGroupRadio.isSelected()) {
                value = ageGroupRadio.getAttribute("value");
            }
        }
        Assert.assertEquals("0 - 5",value);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
