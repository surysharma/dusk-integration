package com.hedgebenefits.cucumber;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static com.hedgebenefits.cucumber.pageobjects.DataInPage.dataInPage;
import static com.hedgebenefits.cucumber.pageobjects.HomePage.adminPage;
import static com.hedgebenefits.cucumber.pageobjects.LoginPage.loginPage;
import static com.hedgebenefits.cucumber.pageobjects.UploadStatusPage.uploadStatusPage;
import static com.hedgebenefits.cucumber.pageobjects.company.CompanyHomePage.companyHomePage;

@ContextConfiguration("classpath*:cucumber.xml")
public class FileUploadStepDefs {

    @Autowired
    private WebDriver driver;

    @Given("^An Authenticated user with following credentials uploads a file$")
    public void An_Authenticated_user_uploads_a_file(DataTable dataTable) throws Throwable {
        adminPage(driver).clickOn("Company Home");
        loginPage(driver)
                .authenticateWith(dataTable.asMaps().get(0).get("username"), dataTable.asMaps().get(0).get("password"))
                .andGo();
        companyHomePage(driver).clickOn("Data In");
        //TODO: Remove hard coding!
        dataInPage(driver).chooseFile("/Users/sureshsharma/projects/dusk-integration/src/test/resources/testdata/sample.csv").upload();
    }

    @Then("^the file should be uploaded at a specified location$")
    public void the_file_should_be_uploaded_at_a_specified_location(DataTable location) throws Throwable {
        String dir = location.asMaps().get(0).get("dir");
        String uploadedLocation = uploadStatusPage(driver).getUploadedLocation();
        Assertions.assertThat(uploadedLocation).contains(dir);
    }
}
