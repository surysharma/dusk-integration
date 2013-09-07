package com.hedgebenefits.cucumber.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.stereotype.Component;

import static java.lang.System.getProperty;

@Component
public class WebDriverFactoryBean extends AbstractWebDriver {

    @Override
    protected WebDriver getWebDriver() {
        if (getProperty("webdriver.chrome.driver") == null) {
            return new HtmlUnitDriver();
        }
        return new ChromeDriver();
    }

}
