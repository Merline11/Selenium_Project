package uk.axone.objectidentification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHowObjectIdentificationWorks {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        Thread.sleep(5000);
    }

    @Test
    public void testObjectIdentificationWorks() throws InterruptedException {
        WebElement txtSearchQueryTop = driver.findElement(By.id("search_query_top"));
        Thread.sleep(5000);
        txtSearchQueryTop.sendKeys("Blouses");
        Thread.sleep(3000);
        txtSearchQueryTop.clear();
        Thread.sleep(3000);
        txtSearchQueryTop.sendKeys("Short Sleeves");
        Thread.sleep(3000);
        System.out.println("The typed text is "+txtSearchQueryTop.getAttribute("value"));
        Thread.sleep(3000);
        driver.findElement(By.name("submit_search")).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
