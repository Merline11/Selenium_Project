package uk.axone.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class Question7 {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/basic-first-form-demo.html");
        Thread.sleep(2000);
    }

    @Test //customised css selector
    public void testHowToNavigateMultiSelectDDL() throws InterruptedException {
        driver.findElement(By.cssSelector(".panel-body>ul>li>i")).click(); // why this not working ->a[contains*='All Examples']
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".panel-body>ul>li>i")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".panel-body>ul>li:last-of-type>ul>li:first-of-type")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".panel-body>ul>li:last-of-type>ul>li:first-of-type>ul>li:nth-of-type(4)>a")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div.panel.panel-default:nth-child(4)>div.panel-heading")).click();
        Thread.sleep(2000);
        testHowToValidateMultiSelectDDL();
    }

    @Test //customised css selector
    public void testHowToValidateMultiSelectDDL() throws InterruptedException {
        // 1. to identify DDL
        WebElement ddl = driver.findElement(By.cssSelector("#multi-select"));
        // 2. to select the dropdown list
        Select select = new Select(ddl);
        System.out.println( "Is it a multi select dropdown?:" + select.isMultiple());
        Thread.sleep(2000);
        if(select.isMultiple()){

            //selecting by values
            select.selectByValue("California");
            Thread.sleep(2000);
            select.selectByValue("Pennsylvania");
            Thread.sleep(2000);

           /* //Selecting multiple values by index / visible text
            select.selectByIndex(0); select.selectByIndex(6);

            //Or selecting by visible text
            select.selectByVisibleText("California"); select.selectByVisibleText("Pennsylvania");*/
        }
        Thread.sleep(2000);
        System.out.println("---------------------------------------");
        testToVerifyFirstSelectedLogic(select);

    }

    @Test
    public void testToVerifyFirstSelectedLogic(Select select) throws InterruptedException {

        WebElement firstSelectOption = select.getFirstSelectedOption();
        String actualValue = firstSelectOption.getText();
        driver.findElement(By.cssSelector("#printMe")).click();
        Thread.sleep(2000);
        String textInUI = driver.findElement(By.cssSelector("div.panel-body > p.getall-selected:nth-child(8)")).getText();
        String[] parts = textInUI.split(":");
        System.out.println(parts[1].trim());
        //assertEquals(actualValue,parts[1].trim());
        System.out.println("---------------------------------------");
        testToVerifyGetAllSelectedLogic(select);

    }

    @Test
    public void testToVerifyGetAllSelectedLogic(Select select) throws InterruptedException {

        select.selectByValue("Texas");
        Thread.sleep(2000);
        select.selectByValue("New York");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#printAll")).click();
        Thread.sleep(2000);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        String actualValue = "";
        for (WebElement option : selectedOptions) {
            actualValue += option.getText()+ ",";
        }
        System.out.println("------------------------------------------");
        String textInUI = driver.findElement(By.cssSelector("div.panel-body > p.getall-selected:nth-child(8)")).getText();
        String[] parts = textInUI.split(":");
        System.out.println(parts[1].trim());
        assertEquals(actualValue.replaceAll(",$",""),parts[1].trim());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
