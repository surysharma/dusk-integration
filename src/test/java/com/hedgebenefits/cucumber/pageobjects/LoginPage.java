package com.hedgebenefits.cucumber.pageobjects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractWebPage {

    private WebDriver driver;

    private LoginPage(WebDriver driver) {
        this.driver = driver;
        Assertions.assertThat(driver.getTitle()).isEqualTo("Login");
    }

    public static LoginPage loginPage(WebDriver driver) {
        return new LoginPage(driver);
    }

    @Override
    WebDriver driver() {
        return driver;
    }
}
