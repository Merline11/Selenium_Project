package uk.axone.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {

    @DataProvider(name = "createData")
    public static Object[][] testSupplyCreateData() {

        Object[][] obj = new Object[2][4];

        obj[0][0] = "Merline";
        obj[0][1] = 328999.00;
        obj[0][2] = true;
        obj[0][3] = 32;

        obj[1][0] = "Aaron";
        obj[1][1] = 425556.00;
        obj[1][2] = false;
        obj[1][3] = 3;

        return obj;
    }
}
