package packages;

import config.WebDriverConfig;
import core.service.ConfigurationManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@Getter
public class BaseTest {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        ConfigurationManager.loadProperties();
        driver = WebDriverConfig.getChromeDriver();
    }

    @AfterSuite
    public void quit() {
        driver.quit();
    }
}
