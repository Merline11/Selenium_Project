package uk.axone.framework.pageobjectmodel.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import uk.axone.framework.pageobjectmodel.pages.TopMenuPage;

public class BasePage {

    public WebDriver driver;

    //Aggregation
    //BasePage HAS-A TopMenuPage
    public TopMenuPage topMenuPage;

    public BasePage(WebDriver driver){
        this.driver=driver;
        topMenuPage = PageFactory.initElements(driver,TopMenuPage.class);
    }


}
