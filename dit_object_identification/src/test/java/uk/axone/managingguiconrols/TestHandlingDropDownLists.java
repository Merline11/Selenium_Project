package uk.axone.managingguiconrols;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestHandlingDropDownLists {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/basic-select-dropdown-demo.html");
        Thread.sleep(5000);
    }

    @Test
    public void testDDL1() throws InterruptedException {
        // 1. to identify DDL
        WebElement ddl = driver.findElement(By.id("select-demo"));
        ddl.sendKeys("Thursday");
        Thread.sleep(3000);

    }

    @Test
    public void testDDL2() throws InterruptedException {
        // 1. to identify DDL
        WebElement ddl = driver.findElement(By.id("select-demo"));
        // 2. to select the dropdown list
        Select select = new Select(ddl);
        select.selectByVisibleText("Saturday");
        Thread.sleep(3000);
        List<WebElement> allDropDownOptions = select.getOptions();

        for (WebElement option : allDropDownOptions) {
            if(option.isEnabled()){ // if we comment it, we will get all option include "please select"
                System.out.println(option.getText());
            }
        }
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
