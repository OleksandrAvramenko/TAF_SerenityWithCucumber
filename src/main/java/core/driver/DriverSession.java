package core.driver;

import core.service.ConfigurationManager;
import enums.Props;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverSession {

    private static WebDriver driver;

    private DriverSession() {
    }

    public static void setDriver(final WebDriver webDriver) {
        driver = webDriver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getDriverWait() {
        return new WebDriverWait(driver, Long.valueOf(ConfigurationManager.getProperty(Props.EXPLICITLY_TIMEOUT)));
    }

    public static WebDriverWait getPageLoadTimeout() {
        return new WebDriverWait(driver, Long.valueOf(ConfigurationManager.getProperty(Props.PAGE_LOAD_TIMEOUT)));
    }
}
