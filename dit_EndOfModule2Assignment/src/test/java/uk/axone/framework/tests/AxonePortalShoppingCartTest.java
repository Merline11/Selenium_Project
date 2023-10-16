package uk.axone.framework.tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import uk.axone.framework.base.BaseTest;
import uk.axone.framework.shoppingCart.OrderProductInAxone;

import java.io.FileNotFoundException;

/**
 * Pre-requisites:
 * 1. Navigate to Axone shopping portal: http://seleniumpractice.axonetech.uk/index.php
 * 2. Using your email address, create an account.
 * 3. Make sure you create address for your account.
 *
 * Test steps:
 * 1. Click the “New Products” menu in the footer menu.
 * 2. Click the “Blouse” section.
 * 3. Choose the “White Colour” and click “Add to Cart”.
 * 4. Verify the ‘Product is successfully added to the cart’.
 * 5. Click on ‘Proceed to checkout’ in the pop-up page.
 * 6. Verify the details in ‘Shopping-cart summary’ page.
 * 7. Click on ‘Proceed to checkout’ and verify the ‘Address’ page is pre-populated with your address.
 * 8. Proceed ahead to the next step and verify ‘Shipping details’ page is populated.Agree to Ts&Cs and proceed ahead.
 * 9. Proceed ahead to ‘Payment’ page and choose ‘Pay by check’ and choose ‘Pound’.
 * 10. Click on ‘I confirm my order’.
 * 11. Verify ‘Order Confirmation’ page appears and note down the Order reference.
 * 12. Click on ‘Verify Order history’ link in the confirmation page.
 * 13. Verify ‘Order History’ page shows up the order reference you noted in the previous step.
 */
public class AxonePortalShoppingCartTest extends BaseTest {

    public AxonePortalShoppingCartTest() throws FileNotFoundException {
    }

    @Test
    public void shoppingCartTest() throws InterruptedException {

        test = report.startTest("Axone Shopping Cart Test","Practice portal - First Test");

        launchBrowser();
        Thread.sleep(2000);

        navigateToURL();
        Thread.sleep(2000);

        createAccount();
        Thread.sleep(2000);

        clickWebElement("new_products_lnk_xpath");
        Thread.sleep(2000);

        clickWebElement("blouses_section_lnk_xpath");
        Thread.sleep(2000);

        clickWebElement("white_colour_lnk_id");
        Thread.sleep(2000);

        clickWebElement("add_to_cart_btn_name");
        Thread.sleep(2000);

        Assert.assertEquals(identifyElement("product_success_msg_txt_xpath").getText(),"Product successfully added to your shopping cart");
        Thread.sleep(2000);

        clickWebElement("proceed_btn_xpath");
        Thread.sleep(2000);

        Assert.assertEquals(identifyElement("blouse_in_proceed_page_lnk_xpath").getText(),"Blouse");
        Thread.sleep(2000);

        clickWebElement("proceed_to_checkout_btn_xpath");
        Thread.sleep(2000);

        Assert.assertEquals(identifyElement("address_firstname_txt_id").getText(),"Merline");
        Thread.sleep(2000);
        Assert.assertEquals(identifyElement("address_lastname_txt_id").getText(),"Jayaraj");
        Thread.sleep(2000);

        typeValuesInTextBox("address_first-line_txt_id","123, First Street");
        Thread.sleep(2000);

        typeValuesInTextBox("address_city_txt_id","123, First Street");
        Thread.sleep(2000);

        Select stateDDL = new Select(identifyElement("address_state_select_id"));
        stateDDL.selectByVisibleText("California");

        typeValuesInTextBox("address_postcode_txt_id","12345");
        Thread.sleep(2000);

        typeValuesInTextBox("address_phone_txt_id","123456789");
        Thread.sleep(2000);

        clickWebElement("submitAddress_btn_id");
        Thread.sleep(2000);

        report.endTest(test);
        report.flush();

    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        getDriver().quit();
    }
}
