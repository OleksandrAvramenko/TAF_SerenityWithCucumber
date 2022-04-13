package packages;

import core.service.ConfigurationManager;
import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverSession;
import driver.DriverType;
import enums.Props;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import static enums.Props.IMPLICITLY_TIMEOUT;

public class FunctionalTest {

    private static DriverManager driverManager;

    @BeforeSuite
    public void setUp() {
        ConfigurationManager.loadProperties();
        initDriver();
        configDriver();
    }

    @AfterSuite
    public void quit() {
        driverManager.quitDriver();
    }

    @AfterTest
    public void cleanUp() {
        driverManager.getDriver().manage().deleteAllCookies();
    }

    private void initDriver() {
        DriverType driverType = DriverType.valueOf(ConfigurationManager.getProperty(Props.BROWSER));
        driverManager = DriverManagerFactory.getDriverManager(driverType);
        DriverSession.setDriver(driverManager.getDriver());
    }

    private void configDriver() {
        Long implicitlyTimeout = Long.valueOf(ConfigurationManager.getProperty(IMPLICITLY_TIMEOUT));
        driverManager.getDriver().manage().timeouts().implicitlyWait(implicitlyTimeout, TimeUnit.SECONDS);
        driverManager.getDriver().manage().window().maximize();
    }
}
