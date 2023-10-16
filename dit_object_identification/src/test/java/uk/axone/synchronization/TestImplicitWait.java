package uk.axone.synchronization;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestImplicitWait {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.co.uk/");
        //to handle implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(5000);
    }

    @Test
    public void testImplicitWait() {
        driver.findElement(By.id(""));
        driver.findElements(By.id(""));

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
