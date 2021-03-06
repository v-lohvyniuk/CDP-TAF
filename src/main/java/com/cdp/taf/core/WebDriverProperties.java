package com.cdp.taf.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("webdriver.properties")
public class WebDriverProperties {

    @Value("${webdriver.wait}")
    private Long webdriverWait;

    @Value("${webdriver.short.wait}")
    private Integer shortWait;

    public Long webdriverWait() {
        return webdriverWait;
    }

    public Integer getShortWait() {
        return shortWait;
    }
}
