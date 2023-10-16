package uk.axone.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Question5 {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/basic-first-form-demo.html");
        Thread.sleep(2000);
    }

    @Test // customised XPath selector
    public void testHowToNavigateMultipleCheckBoxDemoPage() throws InterruptedException {
        /*driver.findElement(By.xpath("//a[contains(text(),'All Examples')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'All Examples')]")).click();
        Thread.sleep(2000);*/
        driver.findElement(By.xpath("//a[text()='Input Forms']")).click(); //div[@class='panel-body']//following-sibling::ul//li//a[text()='Input Forms']
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='panel-body']//following-sibling::ul//li//a[text()='Checkbox Demo']")).click();//not working -->//a[text()='Checkbox Demo']
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Multiple Checkbox Demo']")).click();
        Thread.sleep(2000);
        testHowToFetchAllTheValuesInCheckBox();
    }

    @Test
    public void testHowToFetchAllTheValuesInCheckBox () throws InterruptedException {
        // 1. to identify multiple checkbox
        List<WebElement> allCheckBoxes = driver.findElements(By.className("cb1-element"));

        allCheckBoxes.get(1).click();
        allCheckBoxes.get(3).click();

        /*// click all the checkboxes
        for (WebElement checkbox : allCheckBoxes) {
            checkbox.click();
            Thread.sleep(1000);
        }*/
        //fetch all the values of the checkboxes and print them. Also print whether they are checked or not
        for (WebElement checkbox : allCheckBoxes) {
            System.out.println("CheckBox : "+checkbox.getAttribute("value") +
                    ": is Selected? :" +checkbox.isSelected());
        }
        testCheckAllUncheckAllOperations();
    }


    @Test //another test to try “Check All” and “Uncheck All” operations and verify the results.
    public void testCheckAllUncheckAllOperations () throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='check1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='check1']")).click();
        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
