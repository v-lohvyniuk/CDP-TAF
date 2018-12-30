package com.cdp.taf;

import com.cdp.taf.core.EnvProperties;
import com.cdp.taf.core.WebDriverConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertiesResolver {

    public static final ApplicationContext context;

    public static final WebDriverConfig webDriverConfig;

    static {
        context = new AnnotationConfigApplicationContext();
        ((AnnotationConfigApplicationContext) context).register(WebDriverConfig.class);
        ((AnnotationConfigApplicationContext) context).register(EnvProperties.class);

        ((AnnotationConfigApplicationContext) context).refresh();

        //configuring beans
        webDriverConfig = context.getBean(WebDriverConfig.class);
    }
}
