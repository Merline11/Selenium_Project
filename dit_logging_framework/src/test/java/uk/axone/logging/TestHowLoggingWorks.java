package uk.axone.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestHowLoggingWorks {

    protected static final Logger LOG = LogManager.getLogger();

    @Test
    public void testLogging(){
        LOG.debug("Hello World! This is a DEBUG message");
        LOG.info("Hello World! This is an INFO message");
        LOG.warn("Hello World! This is a WARNING message");
        LOG.error("Hello World! This is an ERROR message");
        LOG.fatal("Hello World! This is a FATAL message");

    }
}
