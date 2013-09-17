package com.hedgebenefits.cucumber.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataInPage extends AbstractWebPage {

    private static DataInPage dataInPage;

    public DataInPage(WebDriver driver, String title) {
        super(driver, title);
    }

    public static DataInPage dataInPage(WebDriver driver) {
        dataInPage = new DataInPage(driver, "Data In");
        return dataInPage;
    }

    public DataInPage chooseFile(String filePath) {
        driver.findElement(By.id("upload")).sendKeys(filePath);
        return this;
    }

    public DataInPage upload() {
        driver.findElement(By.id("submit")).click();
        return this;
    }
}
