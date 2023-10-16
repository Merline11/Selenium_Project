package uk.axone.framework.tests;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import uk.axone.framework.base.BaseTest;

import java.io.FileNotFoundException;

public class AxonePortalSecondTest extends BaseTest {

    public AxonePortalSecondTest() throws FileNotFoundException {
    }

    @Test
    public void myPracticePortalSecondTest() throws InterruptedException {
        test = report.startTest("Axone Second Test", "Practice portal - Second Test");

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
        typeValuesInTextBox("email_address_txt_id", "karthik@axone-tech.uk");
        Thread.sleep(2000);

        logInfo("entering password");
        typeValuesInTextBox("password_txt_name", "password");
        Thread.sleep(2000);

        logInfo("clicking the sign-in button");
        clickWebElement("sign_in_btn_id");
        Thread.sleep(2000);

        logInfo("clicking the sign out button");
        clickWebElement("sign_out_lnk_linkText");
        Thread.sleep(2000);

        logFail("Failing the test - test purpose");

        report.endTest(test);
        report.flush();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        getDriver().quit();
    }
}
