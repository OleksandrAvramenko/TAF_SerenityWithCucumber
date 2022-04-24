package core.driver;

import core.service.ConfigurationManager;
import enums.Props;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteFirefoxManager extends DriverManager {
    @Override
    protected void createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(DriverType.REMOTE_FIREFOX.getBrowser());

        URL url = null;
        try {
            url = new URL(ConfigurationManager.getProperty(Props.REMOTE_DRIVER_URL));
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        this.driver = new RemoteWebDriver(url, capabilities);
    }
}
