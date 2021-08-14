package io.pragra.framework.drivermanager;

import io.pragra.framework.conf.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

/**
 * Add logger and extend driver manager to support other browsers
 */
public class DriverManager {
    private static DriverManager manager;
    private WebDriver driver;

    private DriverManager() throws IOException {
        setUpDriver();
        if ( Config.getProperty("browser.type").equals(BrowserConstants.CHROME)) {
            driver = new ChromeDriver();
        }else if (Config.getProperty("browser.type").equals(BrowserConstants.FIREFOX)){
            driver = new FirefoxDriver();
        }else {
            driver = new ChromeDriver();
        }
    }

    public static synchronized WebDriver getDriver(){
            if( manager == null ){
                try {
                    manager = new DriverManager();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return manager.driver;
    }


    public void setUpDriver(){
        /*
            Define all setting
         */

        try {
            System.setProperty(BrowserConstants.CHROME_KEY, Config.getProperty("chrome.driver"));
            System.setProperty(BrowserConstants.FIREFOX_KEY, Config.getProperty("firefox.driver"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
