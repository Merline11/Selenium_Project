package uk.axone.assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Question1 {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        System.out.println("Tile of the webpage 1 : "+driver.getTitle());
        Thread.sleep(2000);
    }

    @Test
    public void testHandleTheURLInNewWindow() throws InterruptedException {
        // Opens a new window and switches to new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://seleniumpractice.axone-tech.uk/index.php?controller=prices-drop");
        System.out.println("Tile of the webpage 2 : "+driver.getTitle());
        Thread.sleep(2000);
    }
    @Test
    public void testHandleTheURLInNewTab() throws InterruptedException {
        // Opens a new tab and switches to new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://seleniumpractice.axone-tech.uk/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email_create")).sendKeys("Selenium4@axone.uk");
        driver.findElement(By.id("SubmitCreate")).click();


        Set<String> windows = driver.getWindowHandles();
        System.out.println("No of windows open : " + windows.size());
        Iterator<String> itr = windows.iterator();
        String firstWindow = itr.next();
        String secondWindow = itr.next();
        driver.switchTo().window(secondWindow);
        Thread.sleep(2000);
        driver.findElement(By.id("search_query_top")).sendKeys("shirt");
        Thread.sleep(2000);
        driver.findElement(By.name("submit_search")).click();
        Thread.sleep(2000);  // check: what title need to be print?
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
