package enums;

import lombok.Getter;

@Getter
public enum Props {

    @Value("${env}")
    ENV,

    @Value("${host}")
    HOST_URL,

    @Value("${standard.user.name}")
    STANDARD_USER_NAME,

    @Value("${standard.user.password}")
    STANDARD_USER_PASSWORD,

    @Value("${locked.user.name}")
    LOCKED_OUT_USER_NAME,

    @Value("${locked.user.password}")
    LOCKED_OUT_USER_PASSWORD,

    @Value("${page.load.timeout}")
    PAGE_LOAD_TIMEOUT;

    private String value;
}
