package io.pragra.framework.test.conf;

import io.pragra.framework.conf.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ConfigTest {

    @Test
    public void testConfigRightProperty() throws IOException {
        Assert.assertEquals(Config.getProperty("browser.type"),"chrome");
    }


    @Test
    public void testConfigRightProperty2() throws IOException {
        Assert.assertTrue(Config.getProperty("firefox.driver").contains("geckodriver"));
    }


    @Test(expectedExceptions = RuntimeException.class)
    public void testConfigInvalidProperty() throws IOException {
        Config.getProperty("djhfba");
    }


}
