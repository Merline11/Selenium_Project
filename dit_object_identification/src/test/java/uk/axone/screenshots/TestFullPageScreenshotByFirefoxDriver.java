package uk.axone.screenshots;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestFullPageScreenshotByFirefoxDriver {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.co.uk/");
        Thread.sleep(5000);
    }

    @Test
    public void testFullPageScreenshotByFirefox() throws InterruptedException, IOException {
        // 1. Take the screenshot and store it in the temporary file
        File srcFile = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
        // 2. store the file into a desired location
        // System.out.println(System.getProperty("user.dir"));            // ANOTHER WAY
        System.out.println(SystemUtils.USER_DIR);
        FileUtils.copyFile(srcFile, new File(SystemUtils.USER_DIR +"/target/screenshots/BBC_FullPageScreenshot.jpg"));
        Thread.sleep(3000);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
