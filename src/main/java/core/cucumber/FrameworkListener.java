package core.cucumber;

import core.service.ConfigurationManager;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunStarted;

public class FrameworkListener implements EventListener {

    @Override
    public void setEventPublisher(final EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, setUp);
    }

    private EventHandler<TestRunStarted> setUp = event -> {
        ConfigurationManager.loadProperties();
    };
}
