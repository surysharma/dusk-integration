package com.hedgebenefits.cucumber.pageobjects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractWebPage {

    private LoginPage(WebDriver driver) {
        super(driver, "Login");
        Assertions.assertThat(driver.getTitle()).isEqualTo("Login");
    }

    public static LoginPage loginPage(WebDriver driver) {
        return new LoginPage(driver);
    }

    public LoginPage authenticateWith(String userName, String password) {
        driver.findElement(By.cssSelector("input[name='j_username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[name='j_password']")).sendKeys(password);
        return this;
    }

    public void andGo() {
        driver.findElement(By.cssSelector("input[type=submit]")).click();
    }

    public String authenticationError() {
        return driver.findElement(By.cssSelector("td.error")).getText();
    }
}
