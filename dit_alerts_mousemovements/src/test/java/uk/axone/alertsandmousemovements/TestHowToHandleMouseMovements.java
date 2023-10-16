package uk.axone.alertsandmousemovements;

import org.openqa.selenium.Alert;
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

public class TestHowToHandleMouseMovements {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.americangolf.co.uk/");
        Thread.sleep(5000);
    }

    @Test
    public void testHandleMouseMovements() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Accept']")).click();
        Thread.sleep(3000);
        WebElement golfClubsMenu = driver.findElement(By.partialLinkText("GOLF CLUBS")); // giving it in capital letter
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(golfClubsMenu).perform();

        WebElement irons = driver.findElement(By.xpath("//div[@id='CLUBS_1']/ul/li[1]/ul/li[3]/a/span")); //click iron
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(irons)).click();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
