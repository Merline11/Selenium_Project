package uk.axone.framework.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import uk.axone.framework.base.BaseTest;

import java.io.FileNotFoundException;

/**
 * 1. Launch the browser of user choice
 * 2. Navigate to application under test url
 * 3. click on sign-in link
 * 4. enter the email address
 * 5. enter the password
 * 6. click on the sign-in button
 * 7. verify sign-out link is enabled and click on it
 */
public class AxonePortalSimpleTest extends BaseTest {

    public AxonePortalSimpleTest() throws FileNotFoundException {
    }

    @Test
    public void myPracticePortalTest() throws InterruptedException {

        test = report.startTest("Axone First Test","Practice portal - First Test");

        logInfo("Launching the browser");
        launchBrowser();
        Thread.sleep(2000);

        logInfo("Navigating to the URL");
        navigateToURL();
        Thread.sleep(2000);

        logInfo("clicking on the sign_in link");
        clickWebElement("sign_in_lnk_className");
        Thread.sleep(2000);

        logInfo("entering email address");
        typeValuesInTextBox("email_address_txt_id","karthik@axone-tech.uk");
        Thread.sleep(2000);

        logInfo("entering password");
        typeValuesInTextBox("password_txt_name","password");
        Thread.sleep(2000);

        logInfo("clicking the sign-in button");
        clickWebElement("sign_in_btn_id");
        Thread.sleep(2000);

        logInfo("clicking the sign out button");
        clickWebElement("sign_out_lnk_linkText");
        Thread.sleep(2000);

        report.endTest(test);
        report.flush();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        getDriver().quit();
    }
}
