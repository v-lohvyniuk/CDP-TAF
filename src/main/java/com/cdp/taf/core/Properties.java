package com.cdp.taf.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Properties {

    public static final ApplicationContext context;

    public static final WebDriverProperties forDriver;

    public static final EnvProperties forEnv;

    static {
        context = new AnnotationConfigApplicationContext();
        ((AnnotationConfigApplicationContext) context).register(WebDriverProperties.class);
        ((AnnotationConfigApplicationContext) context).register(EnvProperties.class);

        ((AnnotationConfigApplicationContext) context).refresh();

        //configuring beans
        forDriver = context.getBean(WebDriverProperties.class);
        forEnv = context.getBean(EnvProperties.class);
    }
}
