package uk.axone.managingguiconrols;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestHowToHandleRadioButtons {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://uitest.automationtester.uk/basic-radiobutton-demo.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test
    public void testHowToHandleRadioButtons() {
        // 1. to identify the radio buttons
        List<WebElement> allRadioButtons = driver.findElements(By.name("optradio"));
        // 2. to click specific radio button
        System.out.println(allRadioButtons.get(0).isSelected());
        allRadioButtons.get(0).click();

        for (WebElement radio : allRadioButtons) {
            System.out.println("Radio :" + radio.getAttribute("value") + ": is Selected? :" + radio.isSelected());
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
