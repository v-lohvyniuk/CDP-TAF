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

    @Value("${driver.type}")
    private String driverType;

    @Value("${hub.url}")
    private String hubUrl;

    @Value("${use.local.driver}")
    private Boolean useLocalDriver;

    public Long webdriverWait() {
        return webdriverWait;
    }

    public Integer getShortWait() {
        return shortWait;
    }

    public Boolean getUseLocalDriver() {
        return useLocalDriver;
    }

    public String getDriverType() {
        return driverType;
    }

    public String getHubUrl() {
        return hubUrl;
    }

    public Long getWebdriverWait() {
        return webdriverWait;
    }
}
