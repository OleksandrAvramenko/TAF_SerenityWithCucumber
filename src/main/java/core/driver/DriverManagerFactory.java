package core.driver;

import exceptions.UnsupportedDriverException;
import org.testng.ITestContext;

import java.util.Arrays;

public class DriverManagerFactory {

    private DriverManagerFactory() {
    }

    public static DriverManager getDriverManager(final DriverType type, final ITestContext context) {
        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case CHROME_HEADLESS:
                driverManager = new ChromeHeadlessDriverManager();
                break;
            case REMOTE_CHROME:
                driverManager = new RemoteChromeDriverManager();
                break;
            case REMOTE_FIREFOX:
                driverManager = new RemoteFirefoxManager();
                break;
            case SAUCELABS_CHROME:
                driverManager = new SauceLabsChromeManager(context);
                break;
            case SAUCELABS_FIREFOX:
                driverManager = new SauceLabFirefoxManager(context);
                break;
            default:
                throw new UnsupportedDriverException(
                        String.format("You are trying to use unsupported browser: %s.\nSupported browsers: %s",
                                type.toString(), Arrays.asList(DriverType.values())));
        }
        return driverManager;
    }
}
