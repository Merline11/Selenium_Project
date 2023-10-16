package uk.axone.assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Question2 {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.americangolf.co.uk/");
        Thread.sleep(2000);
    }

    @Test
    public void testHandleMouseMovements() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Accept']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='EGn_M-close']")).click();
        Thread.sleep(1000);
        WebElement golfClubsMenu = driver.findElement(By.partialLinkText("GOLF CLUBS"));
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(golfClubsMenu).perform();

        WebElement irons = driver.findElement(By.xpath("//div[@id='CLUBS_1']/ul/li[1]/ul/li[9]/a/span"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(irons)).click();
        Thread.sleep(3000);

        WebElement priceRangeFiler = driver.findElement(By.xpath("//div[@id='secondary']/div[1]/div[5]/div/div/div[1]/div/div/div[1]/div"));
        actions.dragAndDropBy(priceRangeFiler, 50, 0).perform();
        Thread.sleep(3000);

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
