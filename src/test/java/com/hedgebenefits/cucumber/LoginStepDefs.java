package com.hedgebenefits.cucumber;

import com.hedgebenefits.cucumber.utils.StepDefConstant;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static com.hedgebenefits.cucumber.pageobjects.HomePage.adminPage;
import static com.hedgebenefits.cucumber.pageobjects.LoginPage.loginPage;
import static com.hedgebenefits.cucumber.pageobjects.company.CompanyHomePage.companyHomePage;

@ContextConfiguration("classpath*:cucumber.xml")
public class LoginStepDefs {

    @Autowired
    private WebDriver driver;

    @Given("^the User is on Hedge benefits page$")
    public void admin_page() {
        driver.get(StepDefConstant.BASE_URL.value());
    }

    @And("^the User clicks on the \"(\\w+\\s\\w+)\" link$")
    public void user_clicks_on_the_link(String companyHome) {
        adminPage(driver).clickOn(companyHome);

    }

    @And("^and the User is represented with login page$")
    public void user_presented_with_login_page() {
        loginPage(driver);
    }


    @When("^the invalid combination of (\\w+) and (\\w+) is given$")
    public void the_invalid_combination_of_username_password_is_given(String userName, String password) throws Throwable {
        loginPage(driver).authenticateWith(userName, password).andGo();
    }

    @Then("^the User is presented the message \"([^\"]*)\"$")
    public void the_User_is_presented_the_message(String errorMessage) throws Throwable {
        String actualErrorMessage = loginPage(driver).authenticationError();
        Assertions.assertThat(errorMessage).isEqualTo(actualErrorMessage);
    }

    @When("^the User give valid combination of (\\w+) and (\\w+) is given$")
    public void the_User_give_valid_combination_of_username_password_is_given(String userName, String password) throws Throwable {
        loginPage(driver).authenticateWith(userName, password).andGo();
    }

    @Then("^the User successfully goes to the company home page$")
    public void the_User_successfully_goes_to_the_company_home_page() throws Throwable {
        companyHomePage(driver);
    }

    @And("^the User is already logged in with following credentials$")
    public void logged_in_user(DataTable dataTable) throws Throwable {
        String username = dataTable.asMaps().get(0).get("username");
        String password = dataTable.asMaps().get(0).get("password");
        driver.get(StepDefConstant.BASE_URL.buildCompleteUrlWith("/login"));
        loginPage(driver).authenticateWith(username, password).andGo();
    }

    @And("^the User should be able to see the \"(\\w+)\" link$")
    public void see_the_link(String link) throws Throwable {
        Assertions.assertThat(driver.findElement(By.linkText(link)).isDisplayed()).isTrue();
    }
}
