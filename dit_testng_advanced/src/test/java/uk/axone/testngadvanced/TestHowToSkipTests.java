package uk.axone.testngadvanced;

import org.testng.SkipException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * 1. using @Ignore annotation. This can be added at class, package, or at method levels.
 * 2. using enabled=false at the method level.
 *
 * @author Karthik.Gandhinathan
 * @project dit_testng_advanced
 */
public class TestHowToSkipTests {

    @Test
    public void doLoginTest(){
        System.out.println("Login Test");
    }

    @Test
    public void logoutTest(){
        System.out.println("Logout Test");
    }

    //@Ignore
    //@Test(enabled = false)
    @Test
    public void verifyHomePageTest(){
        System.out.println("Home Page Test");

        //if(!dataIsAvailable())
        throw new SkipException("Test Data is not available. Please try again later!! ");

    }

    @Test
    public void landingPageTest(){
        System.out.println("Landing Page Test");
    }

}
