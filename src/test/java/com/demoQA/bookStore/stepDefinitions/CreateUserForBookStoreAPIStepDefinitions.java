package com.demoQA.bookStore.stepDefinitions;

import com.demoQA.bookStore.pages.*;
import com.demoQA.bookStore.utils.ButtonGenerator;
import com.demoQA.bookStore.utils.ConfigurationReader;
import com.demoQA.bookStore.utils.Driver;
import com.demoQA.bookStore.utils.EndPointGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.FileNotFoundException;

public class CreateUserForBookStoreAPIStepDefinitions {

    PostNewUserWithAPI postNewUserWithAPI = new PostNewUserWithAPI();
    LogInPage logInPage = new LogInPage();
    ButtonGenerator buttonGenerator = new ButtonGenerator();
    ProfilePage profilePage = new ProfilePage();
    EndPointGenerator endPointGenerator = new EndPointGenerator();

    @When("user sends POST request to {string} endpoint")
    public void user_sends_post_request_to_endpoint(String endPoint) {
        TestBase.response = endPointGenerator.goToEndPoint(endPoint);
    }
    @Then("Status code is {int}")
    public void status_code_is(int statusCode) {
        Assert.assertEquals(statusCode, postNewUserWithAPI.response.statusCode());
    }
    @Then("userID captured and verified")
    public void user_id_captured_and_verified() throws FileNotFoundException {
        postNewUserWithAPI.captureUserIdAndWriteItOnAFile();
        Assert.assertTrue(postNewUserWithAPI.response.body().path("userID").equals(postNewUserWithAPI.getUserID()) && postNewUserWithAPI.getUserID()!=null);
        postNewUserWithAPI.response.prettyPrint();
    }
    @Then("userName is correct")
    public void user_name_is_correct() {
        Assert.assertEquals(postNewUserWithAPI.response.body().path("username"),ConfigurationReader.getProperty("username"));
    }
    @Given("user navigates to login page")
    public void userNavigatesToLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("logInPageURL"));
    }
    @When("user enters login credentials")
    public void userEntersLoginCredentials() {
        logInPage.enterCredentials(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
    }
    @And("user clicks on {string} button")
    public void userClicksOnButton(String buttonName) {
        buttonGenerator.clickButton(buttonName);
    }
    @Then("user is logged in")
    public void userIsLoggedIn() {
        Assert.assertTrue(profilePage.userNameTag.getText().equals(ConfigurationReader.getProperty("username"))&&profilePage.logoutButton.isDisplayed());

    }


}
