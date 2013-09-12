package com.hedgebenefits.cucumber.pageobjects.company;

import com.hedgebenefits.cucumber.pageobjects.AbstractWebPage;
import org.openqa.selenium.WebDriver;

public class CompanyHomePage extends AbstractWebPage {

    private CompanyHomePage(WebDriver driver) {
        super(driver, "Company Home");
    }

    public static void companyHomePage(WebDriver driver) {
        new CompanyHomePage(driver);
    }
}
