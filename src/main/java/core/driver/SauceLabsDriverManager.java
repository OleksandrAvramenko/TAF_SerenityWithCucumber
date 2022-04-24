package core.driver;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import core.service.ConfigurationManager;
import enums.Props;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class SauceLabsDriverManager extends DriverManager implements SauceOnDemandAuthenticationProvider {

    protected static final SauceOnDemandAuthentication AUTHENTICATION =
            new SauceOnDemandAuthentication(ConfigurationManager.getProperty(Props.SAUCELABS_USERNAME),
                    ConfigurationManager.getProperty(Props.SAUCELABS_ACCESSKEY));

    protected Capabilities capabilities;
    protected String jobName;

    protected SauceLabsDriverManager(final ITestContext context) {
        jobName = context.getName();
    }

    @Override
    protected void createDriver() {
        createCapabilities();
        URL url = null;
        try {
            url = new URL(ConfigurationManager.getProperty(Props.SAUCELABS_DRIVER_URL));
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        this.driver = new RemoteWebDriver(url, capabilities);
    }

    @Override
    public SauceOnDemandAuthentication getAuthentication() {
        return AUTHENTICATION;
    }

    protected abstract void createCapabilities();
}
