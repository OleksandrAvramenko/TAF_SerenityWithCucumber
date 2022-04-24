package core.driver;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DriverType {
    CHROME("chrome"),
    CHROME_HEADLESS("chrome"),
    REMOTE_CHROME("chrome"),
    REMOTE_FIREFOX("firefox"),
    SAUCELABS_CHROME("chrome"),
    SAUCELABS_FIREFOX("firefox");

    private String browser;
    }
