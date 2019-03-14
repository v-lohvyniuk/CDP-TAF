package com.cdp.taf.ui.decorator;

import java.lang.reflect.Field;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.
        DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class CustomFieldDecorator extends DefaultFieldDecorator {

    private WebDriver driver;

    public CustomFieldDecorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
        driver = (WebDriver) searchContext;
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Class<?> decoratableClass = decoratableClass(field);
        if (decoratableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }

            return createElement(loader, locator, decoratableClass, driver);
        }
        return super.decorate(loader, field);
    }

    private Class<?> decoratableClass(Field field) {

        Class<?> clazz = field.getType();

        try {
            clazz.getConstructor(WebElement.class); // if one-arg constructor is used
        } catch (Exception e) {
            try {
                clazz.getConstructor(WebElement.class, WebDriver.class); // if two-args constructor is used
            } catch (Exception e1) {
                e1.printStackTrace();
                return null;
            }
        }

        return clazz;
    }

    protected <T> T createElement(ClassLoader loader,
                                  ElementLocator locator, Class<T> clazz, WebDriver driver) {
        WebElement proxy = proxyForLocator(loader, locator);
        return createInstance(clazz, proxy, driver);
    }

    private <T> T createInstance(Class<T> clazz, WebElement element, WebDriver driver) {
        try {
            return (T) clazz.getConstructor(WebElement.class, WebDriver.class)
                    .newInstance(element, driver);
        } catch (Exception e) {
            throw new AssertionError("WebElement can't be represented as " + clazz
            );
        }
    }
}