package packages;

import core.service.ConfigurationManager;
import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.annotations.BeforeStories;

public class AcceptanceTestSuite extends SerenityStories {

    @BeforeStories
    public void setUp() {
        ConfigurationManager.loadProperties();
    }
}
