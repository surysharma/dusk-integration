package com.hedgebenefits.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractWebPage {

    private static HomePage homePage;

    private HomePage(WebDriver driver) {
        super(driver, "Home");
    }

    public static HomePage adminPage(WebDriver driver) {
        homePage = new HomePage(driver);
        return homePage;
    }
}
