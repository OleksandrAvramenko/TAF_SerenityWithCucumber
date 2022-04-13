package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Props {
    ENV("env"),
    BROWSER("browser"),
    HOST_URL("host"),
    STANDARD_USER_NAME("standard.user.name"),
    STANDARD_USER_PASSWORD("standard.user.password"),
    LOCKED_OUT_USER_NAME("locked.user.name"),
    LOCKED_OUT_USER_PASSWORD("locked.user.password"),
    PAGE_LOAD_TIMEOUT("page.load.timeout");

    private String value;
}
