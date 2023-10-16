package uk.axone.alertsandmousemovements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestHowToHandleWebTables {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.londonstockexchange.com/indices/ftse-100/constituents/table");
        Thread.sleep(5000);
    }

    @Test
    public void testWebTables() throws InterruptedException {
        List<WebElement> listOfStockNames = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
        List<WebElement> listOfStockPrices = driver.findElements(By.xpath("//table/tbody/tr/td[5]"));

        for (int i = 0; i < listOfStockNames.size(); i++) {
            System.out.println("Stock Name : "+listOfStockNames.get(i).getText() +"--Stock Prices-- " +listOfStockPrices.get(i).getText());
        }
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
