package uk.axone.framework.pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.axone.framework.pageobjectmodel.base.BasePage;

public class HomePage extends BasePage {

    @FindBy(xpath="//a[contains(text(),'Sign in')]")
    WebElement lnkSignin;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage navigateToLoginPage(){
        lnkSignin.click();
        return PageFactory.initElements(driver,LoginPage.class);
    }
}
