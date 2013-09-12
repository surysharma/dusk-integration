package com.hedgebenefits.cucumber.pageobjects;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static com.hedgebenefits.cucumber.utils.StepDefConstant.BASE_URL;
import static java.lang.String.format;
import static org.apache.commons.lang.StringUtils.startsWith;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractWebPage {

    protected WebDriver driver;

    public AbstractWebPage(WebDriver driver, String title) {
        this.driver = driver;
        if (!startsWith(driver.getCurrentUrl(), BASE_URL.value())) {
            this.driver.get(BASE_URL.value());
        }
        assertThat(driver.getTitle()).isEqualTo(title);
    }

    public void clickOn(String linkName) {
        try {
            driver.findElement(By.linkText(linkName)).click();
        } catch (NoSuchElementException exception) {
            Assert.fail(format("Link %s does not exist", linkName));
        }
    }
}
