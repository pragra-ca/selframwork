package io.pragra.framework.test.conf;

import io.pragra.framework.drivermanager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DriverManagerTest {
    @Test
    public void testChrome() throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://pragra.io");
        Thread.sleep(10000);
        driver.quit();
    }
}
