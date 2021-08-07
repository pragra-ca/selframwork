import io.pragra.framework.conf.Config;

import java.io.IOException;

public class TestRun {
    public static void main(String[] args) throws IOException {
        System.out.println(Config.getProperty("chrome.driver"));
    }
}
