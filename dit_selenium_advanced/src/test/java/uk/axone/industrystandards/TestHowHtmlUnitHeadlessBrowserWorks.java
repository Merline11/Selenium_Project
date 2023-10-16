package uk.axone.industrystandards;

import org.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

import java.io.File;

public class TestHowHtmlUnitHeadlessBrowserWorks {

    @Test
    public void testHtmlUnitHeadlessBrowser() throws InterruptedException {

        //WebDriver driver = new HtmlUnitDriver(); // no javascript support
        WebDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX); // browser with no javascript support
        // WebDriver driver = new HtmlUnitDriver(true); // javascript enabled
        // WebDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX,true); // browser with javascript enabled

        driver.get("https://www.bbc.co.uk");
        System.out.println("Current URL:"+ driver.getCurrentUrl());
        System.out.println("Title is:" + driver.getTitle());
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void testChromeHeadLessBrowser() throws InterruptedException {

        //Launch chrome headless options
        ChromeOptions chromeOptions = new ChromeOptions();
        //set headless options
        chromeOptions.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.bbc.co.uk");
        System.out.println("Current URL:"+ driver.getCurrentUrl());
        System.out.println("Title is:" + driver.getTitle());
        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void testFirefoxHeadLessBrowser() throws InterruptedException {
        //Launch firefox headless options
        FirefoxOptions firefoxOptions = new FirefoxOptions()
                .setHeadless(true);

        WebDriver driver = new FirefoxDriver(firefoxOptions);

        driver.get("https://www.bbc.co.uk");
        System.out.println("Current URL:"+ driver.getCurrentUrl());
        System.out.println("Title is:" + driver.getTitle());
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void testEdgeHeadLessBrowser() throws InterruptedException {
        //Launch chrome headless options
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless=new");

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.get("https://www.bbc.co.uk");
        System.out.println("Current URL:"+ driver.getCurrentUrl());
        System.out.println("Title is:" + driver.getTitle());
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void testSafariHeadLessBrowser() throws InterruptedException {
        //Launch safari headless options
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setUseTechnologyPreview(true);

        WebDriver driver = new SafariDriver(safariOptions);

        driver.get("https://www.bbc.co.uk");
        System.out.println("Current URL:"+ driver.getCurrentUrl());
        System.out.println("Title is:" + driver.getTitle());
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void testInternetExplorerHeadLessBrowser() throws InterruptedException {
        //Launch Internet Explorer headless options
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions().requireWindowFocus();
        internetExplorerOptions.ignoreZoomSettings(); //Ignoring the Zoom level setting
        internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains(); //Ignoring the Security domains settings
        internetExplorerOptions.disableNativeEvents(); //Disabling the NATIVE_EVENTS capability to ensure the typing speed with 64bit driver

        WebDriver driver = new InternetExplorerDriver(internetExplorerOptions);

        driver.get("https://www.bbc.co.uk");
        System.out.println("Current URL:"+ driver.getCurrentUrl());
        System.out.println("Title is:" + driver.getTitle());
        Thread.sleep(5000);
        driver.quit();
    }
}
