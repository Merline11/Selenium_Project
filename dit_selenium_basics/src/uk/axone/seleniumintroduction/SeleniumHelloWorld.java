package uk.axone.seleniumintroduction;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Karthik.Gandhinathan
 */
public class SeleniumHelloWorld {

    public static void main(String[] args) {
        //ChromeDriver driver = new ChromeDriver();
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.co.uk");
        driver.close();
    }

}
