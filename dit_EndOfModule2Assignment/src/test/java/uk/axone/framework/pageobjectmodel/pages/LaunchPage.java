package uk.axone.framework.pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import uk.axone.framework.pageobjectmodel.base.BasePage;

public class LaunchPage extends BasePage {

    public LaunchPage(WebDriver driver) {
        super(driver);
    }

    public HomePage launchAUTAndNavToHomePage(final String url) {
        driver.get(url);
        return PageFactory.initElements(driver,HomePage.class);
    }
}
