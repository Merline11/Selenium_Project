package uk.axone.framework.pageobjectmodel.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestSimplePageFactory {

    @FindBy(xpath="//a[contains(text(),'Sign in')]")
    static WebElement lnkSignin;

    @FindBy(id="email")
    static WebElement txtEmail;

    @FindBy(id="passwd")
    static WebElement txtPassword;

    @FindBy(id="SubmitLogin")
    static WebElement btnSubmitLogin;

    @FindBy(linkText="Sign out")
    static WebElement lnkSignOut;

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        PageFactory.initElements(driver,TestSimplePageFactory.class);

        lnkSignin.click();
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

        txtEmail.sendKeys("karthik@axone-tech.uk");
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

        txtPassword.sendKeys("password");
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

        btnSubmitLogin.click();
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

        lnkSignOut.click();
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);

        driver.quit();
    }
}
