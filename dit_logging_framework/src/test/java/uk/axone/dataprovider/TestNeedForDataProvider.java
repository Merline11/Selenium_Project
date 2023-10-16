package uk.axone.dataprovider;

import org.testng.annotations.Test;

public class TestNeedForDataProvider {

    @Test
    public void testNeedForDataProvider() {

        /*String[] str = new String[4];
        str[0] = "abc";
        str[1] = 123;
        str[2] = 44.54444;
        str[3] = true;*/

        //string array holds collection of string objects
        //object array  holds collection of objects

        Object[] obj = new Object[4];
        obj[0] = "abc";
        obj[1] = 123;
        obj[2] = 44.54444;
        obj[3] = true;
    }
}
