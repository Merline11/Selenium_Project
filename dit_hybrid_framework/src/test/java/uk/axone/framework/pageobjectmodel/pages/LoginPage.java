package uk.axone.framework.pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.axone.framework.pageobjectmodel.base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id=LoginPageConstants.TXT_EMAIL_ADDRESS)
    WebElement txtEmail;

    @FindBy(id=LoginPageConstants.TXT_PASSWORD)
    WebElement txtPassword;

    @FindBy(id=LoginPageConstants.BTN_SUBMIT_LOGIN)
    WebElement btnSubmitLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLogin(String userName, String Password) {
        txtEmail.sendKeys(userName);
        txtPassword.sendKeys(Password);
        btnSubmitLogin.click();
        return PageFactory.initElements(driver,MyAccountPage.class);
    }
}
