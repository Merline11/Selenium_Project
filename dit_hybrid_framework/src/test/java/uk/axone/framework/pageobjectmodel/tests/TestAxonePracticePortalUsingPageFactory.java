package uk.axone.framework.pageobjectmodel.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import uk.axone.framework.pageobjectmodel.pages.*;

import java.time.Duration;

public class TestAxonePracticePortalUsingPageFactory {

    public WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testPracticePortal(){
        LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
        HomePage homePage = launchPage.launchAUTAndNavToHomePage("http://seleniumpractice.axone-tech.uk/index.php");
        LoginPage loginPage = homePage.navigateToLoginPage();
        MyAccountPage myAccountPage = loginPage.doLogin("karthik@axone-tech.uk","password");
        OrderHistoryPage orderHistoryPage = myAccountPage.navToOrderHistory();
        orderHistoryPage.topMenuPage.doLogOut();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
