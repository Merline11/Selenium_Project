package uk.axone.testngadvanced;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 * @project dit_testng_advanced
 */
public class TestHowAssertionWorks {

    //assertTrue - verifies a condition is true
    //assertFalse - verifies a condition is false
    //assertSame - verifies that two instances refer to the same object
    //assertNotSame - verifies that two instances does NOT refer to the same object
    //assertEquals - verifies that two objects are equal
    //assertNull - object is null
    //assertNotNull - object is NOT null
    //assertNotNull - object is NOT null

    @Test
    public void testAssertEquals(){
        String expVal = "axone.uk";
        String actVal = "axone.uk123";

        System.out.println("Starting - line");
        Assert.assertEquals(actVal, expVal, "Equality mismatch. Both objects are unequal!!");
        System.out.println("Finishing - line");

    }

    @Test
    public void testAssertTrue(){
        Assert.assertTrue(7 > 5, "Condition has evaluated to FALSE");
    }


    @Test
    public void testAssertFalse(){
        Assert.assertFalse(7 > 5, "Condition has evaluated to TRUE");
    }


}
