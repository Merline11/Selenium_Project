package uk.axone.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Question2 {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.co.uk/");
    }

    @Test
    public void testHowToFetchAllTheHREFsForTheLinkTexts() throws InterruptedException {
        List<WebElement> homePageLinks = driver.findElements(By.cssSelector("span[class*='NavItemHoverState']"));
        System.out.println("---------Link texts available in the home page top Menu----------");
        for (WebElement linkText : homePageLinks) {
            System.out.println(linkText.getText());
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
