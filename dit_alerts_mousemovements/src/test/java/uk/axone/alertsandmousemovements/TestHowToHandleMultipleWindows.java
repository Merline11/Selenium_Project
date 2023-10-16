package uk.axone.alertsandmousemovements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TestHowToHandleMultipleWindows {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/jquery-download-progress-bar-demo.html");
        Thread.sleep(5000);
    }

    @Test
    public void testDifferenceBetweenCloseAndQuit() throws InterruptedException {
        driver.findElement(By.linkText("Others")).click();
        driver.findElement(By.linkText("Shopping Cart")).click();
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows.size());
        Thread.sleep(3000);
        Iterator<String> itr = windows.iterator();
        String firstWindow = itr.next();
        String secondWindow = itr.next();
        System.out.println(firstWindow + "---" + secondWindow);

        System.out.println("-firstWindow--" );
        driver.switchTo().window(firstWindow);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        System.out.println("-secondWindow--" );
        driver.switchTo().window(secondWindow);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
