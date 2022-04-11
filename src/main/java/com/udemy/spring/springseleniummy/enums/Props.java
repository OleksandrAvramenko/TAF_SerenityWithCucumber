package com.udemy.spring.springseleniummy.enums;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Getter
@PropertySource("file:${basedir}/src/main/resources/environments/dev.properties")
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
