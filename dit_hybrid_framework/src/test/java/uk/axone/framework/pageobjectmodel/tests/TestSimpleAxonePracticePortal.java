package uk.axone.framework.pageobjectmodel.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestSimpleAxonePracticePortal {

    @Test
    public void testSimpleAxonePrcatice() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

        driver.findElement(By.id("email")).sendKeys("karthik@axone-tech.uk");
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

        driver.findElement(By.id("passwd")).sendKeys("password");
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

        driver.findElement(By.id("SubmitLogin")).click();
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

        driver.findElement(By.linkText("Sign out")).click();
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

        driver.quit();
    }

}
