package core.driver;

import core.service.ConfigurationManager;
import enums.Props;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SauceLabFirefoxManager extends DriverManager {

    @Override
    protected void createDriver() {
        FirefoxOptions browserOptions = new FirefoxOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("screenResolution", "1920x1200");
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
