package uk.axone.seleniumadvanced;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class
TestSimpleBrowserLaunch {

    @Test
    public void testSelenium(){
//        System.out.println("Operation System Version: "+System.getProperty("os.version"));
//        System.out.println("Current User name: "+System.getProperty("user.name"));
        System.out.println("User working directory: "+System.getProperty("user.dir"));
        //System.setProperty("webdriver.chrome.driver", "/Users/karthik/Documents/software/drivers/chromedriver");
//        ChromeDriver cd = new ChromeDriver();
//        cd.get("http://amazon.co.uk/");
    }
}
