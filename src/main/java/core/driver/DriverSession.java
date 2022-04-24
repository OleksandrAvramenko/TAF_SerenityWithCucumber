package core.driver;

import core.service.ConfigurationManager;
import enums.Props;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        Long timeout = Long.valueOf(ConfigurationManager.getProperty(Props.EXPLICITLY_TIMEOUT));
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public static WebDriverWait getPageLoadTimeout() {
        Long timeout = Long.valueOf(ConfigurationManager.getProperty(Props.PAGE_LOAD_TIMEOUT));
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }
}
