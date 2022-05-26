package com.cdp.taf.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Properties {

    public static final ApplicationContext context;

    public static final WebDriverProperties driver;

    public static final EnvProperties env;

    static {
        context = new AnnotationConfigApplicationContext();
        ((AnnotationConfigApplicationContext) context).register(WebDriverProperties.class);
        ((AnnotationConfigApplicationContext) context).register(EnvProperties.class);

        ((AnnotationConfigApplicationContext) context).refresh();

        //configuring beans
        driver = context.getBean(WebDriverProperties.class);
        env = context.getBean(EnvProperties.class);
    }
}
