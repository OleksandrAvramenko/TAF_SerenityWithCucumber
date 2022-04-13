package packages;

import core.service.ConfigurationManager;
import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverSession;
import driver.DriverType;
import enums.Props;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class FunctionalTest {

    protected static DriverManager driverManager;

    @BeforeSuite
    public void setUp() {
        ConfigurationManager.loadProperties();
        initDriver();
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
}
