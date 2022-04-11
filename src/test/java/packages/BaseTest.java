package packages;

import core.service.ConfigurationManager;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        ConfigurationManager.loadProperties();
    }
}
