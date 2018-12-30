package com.cdp.taf.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("env.properties")
public class EnvProperties {

    @Value("${locale}")
    private String locale;

    public String getLocale() {
        return locale;
    }
}
