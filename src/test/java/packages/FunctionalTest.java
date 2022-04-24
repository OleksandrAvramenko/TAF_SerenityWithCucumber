package packages;

import core.allure.AllureListener;
import core.service.ConfigurationManager;
import core.driver.DriverManager;
import core.driver.DriverManagerFactory;
import core.driver.DriverSession;
import core.driver.DriverType;
import enums.Props;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

import static enums.Props.IMPLICITLY_TIMEOUT;

@Listeners(AllureListener.class)
public class FunctionalTest {

    private static DriverManager driverManager;

    @BeforeSuite
    public void setUp(final ITestContext context) {
        ConfigurationManager.loadProperties();
        initDriver(context);
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

    private void initDriver(final ITestContext context) {
        DriverType driverType = DriverType.valueOf(ConfigurationManager.getProperty(Props.BROWSER));
        driverManager = DriverManagerFactory.getDriverManager(driverType, context);
        DriverSession.setDriver(driverManager.getDriver());
    }

    private void configDriver() {
        Long implicitlyTimeout = Long.valueOf(ConfigurationManager.getProperty(IMPLICITLY_TIMEOUT));
        driverManager.getDriver().manage().timeouts().implicitlyWait(implicitlyTimeout, TimeUnit.SECONDS);
        driverManager.getDriver().manage().window().maximize();
    }
}
