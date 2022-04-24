package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Props {
    ENV("env"),
    BROWSER("browser"),
    REMOTE_DRIVER_URL("remote.driver.url"),
    SAUCELABS_DRIVER_URL("saucelabs.driver.url"),
    SAUCELABS_USERNAME("saucelabs.username"),
    SAUCELABS_ACCESSKEY("saucelabs.accesskey"),
    HOST_URL("host"),
    STANDARD_USER_NAME("standard.user.name"),
    STANDARD_USER_PASSWORD("standard.user.password"),
    LOCKED_OUT_USER_NAME("locked.user.name"),
    LOCKED_OUT_USER_PASSWORD("locked.user.password"),
    PAGE_LOAD_TIMEOUT("page.load.timeout"),
    IMPLICITLY_TIMEOUT("implicitly.timeout"),
    EXPLICITLY_TIMEOUT("explicitly.timeout");

    private String value;
}
