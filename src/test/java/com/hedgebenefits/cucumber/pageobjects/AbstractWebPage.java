package com.hedgebenefits.cucumber.pageobjects;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public abstract class AbstractWebPage {

    private WebDriver driver;

    public AbstractWebPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOn(String linkName) {
        try {
            driver.findElement(By.linkText(linkName)).click();
        } catch (NoSuchElementException exception) {
            Assert.fail(format("Link %s does not exist", linkName));
        }
    }
}
