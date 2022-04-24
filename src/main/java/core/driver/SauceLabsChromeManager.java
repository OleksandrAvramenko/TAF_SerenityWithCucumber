package core.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;

import java.util.HashMap;
import java.util.Map;

public class SauceLabsChromeManager extends SauceLabsDriverManager {

    public SauceLabsChromeManager(final ITestContext context) {
        super(context);
    }

    @Override
    protected void createCapabilities() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("100");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("name", jobName);
        browserOptions.setCapability("sauce:options", sauceOptions);
        capabilities = browserOptions;
    }
}
