package uk.axone.managingguiconrols;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestHandlingPortionOfWebPage {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://shopping.rediff.com/?sc_cid=ushome_icon");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test
    public void testPortionOfWebPage1() throws InterruptedException {
        WebElement popularCategory = driver.findElement(By.id("popular_cat"));
        List<WebElement> popularCategoryList = popularCategory.findElements(By.tagName("a"));
        //xpath from chropath - //*[@id="popular_cat"]/h3[1]/a
        String element1 = "//div[@id='popular_cat']/h3[";
        String element2 = "]/a";

        for(int i = 1; i < popularCategoryList.size(); i++){
            System.out.println(driver.findElement(By.xpath(element1+ i + element2)).getText());
        }

        Thread.sleep(3000);
    }

    @Test //for each loop prints Brands as well.we can't restrict it since it is foreach loop.so we can achieve it in
    //traditional loop by limiting conditions as  i< list.size() not as i<=list.size which in return Brands.Bcz
    // Brands coming under same ID(popular_cat)
    public void testPortionOfWebPage2() throws InterruptedException {
        WebElement popularCategory = driver.findElement(By.id("popular_cat"));
        List<WebElement> popularCategoryList = popularCategory.findElements(By.tagName("a"));

        for (WebElement category : popularCategoryList) {
            System.out.println(category.getText());
        }

        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
