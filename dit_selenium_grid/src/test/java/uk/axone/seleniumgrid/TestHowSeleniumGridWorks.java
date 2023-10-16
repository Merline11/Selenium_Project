package uk.axone.seleniumgrid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestHowSeleniumGridWorks {

    @Test
    public void testGridWorks() throws MalformedURLException, InterruptedException {
        URL remoteAddress = new URL(" http://192.168.1.100:4444/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);

        WebDriver driver = new RemoteWebDriver(remoteAddress,capabilities);
        driver.get("https://www.amazon.co.uk/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.quit();
    }
}
