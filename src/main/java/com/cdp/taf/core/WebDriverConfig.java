package com.cdp.taf.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("webdriver.properties")
public class WebDriverConfig {

    @Value("${webdriver.wait}")
    private Long webdriverWait;

    public Long webdriverWait() {
        return webdriverWait;
    }

}
