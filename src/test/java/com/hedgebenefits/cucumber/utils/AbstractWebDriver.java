package com.hedgebenefits.cucumber.utils;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.FactoryBean;

public abstract class AbstractWebDriver implements FactoryBean<WebDriver> {

    @Override
    public WebDriver getObject() throws Exception {
        return getWebDriver();
    }

    @Override
    public Class<WebDriver> getObjectType() {
        return WebDriver.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    protected abstract WebDriver getWebDriver();
}
