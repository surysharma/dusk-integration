package com.hedgebenefits.cucumber.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadStatusPage extends AbstractWebPage {

    private static UploadStatusPage uploadStatusPage;

    public UploadStatusPage(WebDriver driver, String title) {
        super(driver, title);
    }

    public static UploadStatusPage uploadStatusPage(WebDriver driver) {
        uploadStatusPage = new UploadStatusPage(driver, "Upload Status");
        return uploadStatusPage;
    }

    public String getUploadedLocation() {
        String uploadedLocation = driver.findElement(By.id("uploaded_path")).getText();
        return uploadedLocation;
    }
}
