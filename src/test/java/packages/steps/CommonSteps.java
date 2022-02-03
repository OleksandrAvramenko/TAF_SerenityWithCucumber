package packages.steps;

import core.service.ConfigurationManager;
import enums.Props;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CommonSteps extends ScenarioSteps {

    @Step
    public void navigateToBaseUrl() {
        getDriver().get(ConfigurationManager.getProperty(Props.HOST_URL));
    }

    @Step
    public String getCurrentPageUrl() {
        return getDriver().getCurrentUrl();
    }

    @Step
    public String getCurrentPageTitle() {
        return getDriver().getTitle();
    }
}