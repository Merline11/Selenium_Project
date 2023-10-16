package uk.axone.framework.pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.axone.framework.pageobjectmodel.base.BasePage;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Order History and details')]")
    WebElement lnkOrderHistory;

    @FindBy(xpath = "//span[contains(text(),'My personal information')]")
    WebElement lnkMyPersonalInfo;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public OrderHistoryPage navToOrderHistory() {
        lnkOrderHistory.click();
        return PageFactory.initElements(driver,OrderHistoryPage.class);
    }

    public MyPersonalInfoPage navToMyPersonalInfo() {
        lnkMyPersonalInfo.click();
        return PageFactory.initElements(driver,MyPersonalInfoPage.class);
    }
}
