package uk.axone.testngadvanced;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 * @project dit_testng_advanced
 */
public class TestHowToParameterize {

    @Parameters({"first-name", "last-name", "city", "dob"})
    @Test
    public void testParameterize(String fName, String lName, String aCity, String aDOB){
        System.out.println(
                "First name: "+fName+
                ", Last Name: "+lName+
                ", born at: "+aCity+
                ", Date of birth: "+aDOB);
    }

    @Parameters({"browser"})
    @Test
    public void test2(String bName){
        System.out.println("My test browser is: " + bName);
    }
}
