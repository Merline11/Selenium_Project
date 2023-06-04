package uk.axone.testngadvanced;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * @author Karthik.Gandhinathan
 * @project dit_testng_advanced
 */
public class TestHowSoftAssertWorks {

    @Test
    public void testSoftAssert(){
        SoftAssert softassert = new SoftAssert();

        int expectedValue = 123;
        int actualValue = 456;

        System.out.println("Starting - line");
        softassert.assertEquals(actualValue, expectedValue, "Objects unequal");//line throws an error
        softassert.assertTrue(2 > 3, "condition evaluated to false");//line throws an error
        softassert.assertTrue(true, "condition evaluated to false");//line do NOT throw an error
        softassert.assertFalse(true, "condition evaluated to True");//line throws an error
        System.out.println("Finish - line");

        softassert.assertAll();

    }
}
