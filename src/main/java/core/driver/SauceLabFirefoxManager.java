package core.driver;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;

import java.util.HashMap;
import java.util.Map;

public class SauceLabFirefoxManager extends SauceLabsDriverManager {

    public SauceLabFirefoxManager(final ITestContext context) {
        super(context);
    }

    @Override
    protected void createCapabilities() {
        FirefoxOptions browserOptions = new FirefoxOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("screenResolution", "1920x1200");
        sauceOptions.put("name", jobName);
        browserOptions.setCapability("sauce:options", sauceOptions);
        capabilities = browserOptions;
    }
}
