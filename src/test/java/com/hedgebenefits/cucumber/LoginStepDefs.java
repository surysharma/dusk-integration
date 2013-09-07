package com.hedgebenefits.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath*:cucumber.xml")
public class LoginStepDefs {

    @Autowired
    private WebDriver webDriver;

    @Given("^the User clicks on the \"(\\w+\\s\\w+)\" link$")
    public void user_clicks_on_the_link(String companyHome) {
        throw new PendingException();
    }

    @Given("^and the User is represented with login page$")
    public void user_presented_with_login_page() {
        throw new PendingException();
    }

    @When("^the invalid combination of invalidadmin and test is given$")
    public void the_invalid_combination_of_invalidadmin_and_test_is_given() throws Throwable {
        throw new PendingException();
    }

    @Then("^the User is presented the message \"([^\"]*)\"$")
    public void the_User_is_presented_the_message(String arg1) throws Throwable {
        throw new PendingException();
    }

    @When("^the invalid combination of admin and invalidtest is given$")
    public void the_invalid_combination_of_admin_and_invalidtest_is_given() throws Throwable {
        throw new PendingException();
    }

    @When("^the User give valid combination of admin and test is given$")
    public void the_User_give_valid_combination_of_admin_and_test_is_given() throws Throwable {
        throw new PendingException();
    }

    @Then("^the User successfully goes to the company home page$")
    public void the_User_successfully_goes_to_the_company_home_page() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
