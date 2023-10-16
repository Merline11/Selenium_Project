package uk.axone.screenshots;

import org.apache.commons.lang3.SystemUtils;
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

public class TestEntirePageScreenshotUsingAshot {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.co.uk/");
        Thread.sleep(5000);
    }

    @Test
    public void testFullPageScreenshotByFirefox() {
        // 1. Take page screenshot
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);

        // 2. to store it in different location
        try {
            ImageIO.write(screenshot.getImage(),"PNG", new File(SystemUtils.USER_DIR+"/target/screenshots/BBC_EntirePageScreenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
