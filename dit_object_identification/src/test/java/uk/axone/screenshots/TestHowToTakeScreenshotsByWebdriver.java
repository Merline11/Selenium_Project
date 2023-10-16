package uk.axone.screenshots;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestHowToTakeScreenshotsByWebdriver {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.co.uk/");
        Thread.sleep(5000);
    }

    @Test
    public void testHandlingScreenshot() throws InterruptedException, IOException {
        // 1. Take the screenshot and store it in the temporary file
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // 2. store the file into a desired location
       // System.out.println(System.getProperty("user.dir"));            // ANOTHER WAY
        System.out.println(SystemUtils.USER_DIR);
        FileUtils.copyFile(srcFile, new File(SystemUtils.USER_DIR +"/target/screenshots/BBC_Screenshot.jpg")); //C:\Users\Dell\IdeaProjects\dev_in_test_mar23\dit_object_identification\target\screenshots
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
