package com.hedgebenefits.cucumber.pageobjects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AdminPage extends AbstractWebPage {

    private AdminPage(WebDriver driver) {
        super(driver);
        Assertions.assertThat(driver.getTitle()).isEqualTo("Admin Registration");
    }

    public static AdminPage adminPage(WebDriver driver) {
        return new AdminPage(driver);
    }
}
