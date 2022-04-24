package core.driver;

import core.service.ConfigurationManager;
import enums.Props;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SauceLabsChromeManager extends DriverManager {

    @Override
    protected void createDriver() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("100");
        Map<String, Object> sauceOptions = new HashMap<>();
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = null;
        try {
            url = new URL(ConfigurationManager.getProperty(Props.SAUCELAB_DRIVER_URL));
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        this.driver = new RemoteWebDriver(url, browserOptions);
    }
}
