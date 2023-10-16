package uk.axone.objectidentification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHowCSSWorks {
        WebDriver driver;

        @BeforeTest
        public void setUp() throws InterruptedException {
            driver = new ChromeDriver();
            driver.get("http://seleniumpractice.axone-tech.uk/index.php");
            Thread.sleep(5000);
        }

        @Test
        public void testObjectIdentificationWorks() throws InterruptedException {
            System.out.println("Src :"+driver.findElement(By.cssSelector(".logo.img-responsive")).getAttribute("src"));
            Thread.sleep(5000);
        }

        @AfterTest
        public void tearDown(){
            driver.quit();
        }

}
