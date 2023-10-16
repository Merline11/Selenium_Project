package uk.axone.framework.pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {

    public WebDriver driver;

    @FindBy(linkText="Sign out")
    static WebElement lnkSignOut;

    public TopMenuPage(WebDriver driver){
        this.driver=driver;
    }

    public LoginPage doLogOut(){
        lnkSignOut.click();
        return PageFactory.initElements(driver,LoginPage.class);
    }

}
