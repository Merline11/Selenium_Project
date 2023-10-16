package uk.axone.dataprovider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {

    protected static final Logger LOG = LogManager.getLogger();

    @DataProvider(name = "loginData")
    public Object[][] testSupplyLoginData() {

        Object[][] obj = new Object[2][4];

        obj[0][0] = "AxoneUser1";
        obj[0][1] = 45.5996666;
        obj[0][2] = true;
        obj[0][3] = 32;

        obj[1][0] = "AxoneUser2";
        obj[1][1] = 8523.566333;
        obj[1][2] = false;
        obj[1][3] = 43;

        return obj;
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String param1, double param2, boolean param3, int param4){
        LOG.info("Axone User Name : "+ param1 +
                ", they earn testing salary : "+param2 +
                ", are they maintaining good coding skiils ? : "+param3 +
                ", their age : "+param4);

    }

    @Test(dataProvider = "createData", dataProviderClass = DataProviderClass.class)
    public void testCreate(String param1, double param2, boolean param3, int param4){
        LOG.info("User Name : "+ param1 +
                            ", they earn salary : "+param2 +
                            ", are they maintaining good lifestyle ? : "+param3 +
                            ", their age : "+param4);
    }
}
