package core.driver;

import exceptions.UnsupportedDriverException;

import java.util.Arrays;

public class DriverManagerFactory {

    private DriverManagerFactory() {
    }

    public static DriverManager getDriverManager(final DriverType type) {
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
            default:
                throw new UnsupportedDriverException(
                        String.format("You are trying to use unsupported browser: %s.\nSupported browsers: %s",
                                type.toString(), Arrays.asList(DriverType.values())));
        }
        return driverManager;
    }
}
