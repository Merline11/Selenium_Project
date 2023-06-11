package uk.axone.seleniumadvanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Karthik.Gandhinathan
 * @project dit_testng_advanced
 */
public class TestDynamicLaunchingOfApplication {

    WebDriver driver;
    String browserType;
    String applicationUrl;

    @Test
    public void testDynamicLaunchingOfApplication(){

        //String browserType = "Chrome";
        String propPath = System.getProperty("user.dir")+"/src/test/resources/application.properties";

        //create an empty property list
        Properties prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(propPath);
            prop.load(fis);
            browserType = prop.getProperty("browserType");
            applicationUrl = prop.getProperty("url");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (browserType.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Invalid browser type specified");
        }

        driver.get(applicationUrl);
        driver.close();


    }
}
