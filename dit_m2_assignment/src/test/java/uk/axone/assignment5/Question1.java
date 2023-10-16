package uk.axone.assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Question1 {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
        Thread.sleep(2000);
    }

    @Test
    public void testToPrintAllCompanyNamesAndTheirCurrentPrice(){
        List<WebElement> companyNamesList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
        List<WebElement> companyNamesPriceList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));

        System.out.println("List of Company Names and its Prices");
        System.out.println("Company Names--------------------Prices");
        for (int i = 0; i < companyNamesList.size(); i++) {
            System.out.println(companyNamesList.get(i).getText() +" " +companyNamesPriceList.get(i).getText());
        }

    }

    private int getRowWithCellText(String data) {
        return 0;
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
