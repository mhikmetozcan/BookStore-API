package com.demoQA.bookStore.stepDefinitions;

import com.demoQA.bookStore.pages.GenerateToken;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GenerateTokenStepDefinitions {
    GenerateToken generateToken = new GenerateToken();
    String token;
    String date;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @When("Token and expiry date are captured")
    public void token_and_expiry_date_are_captured() throws FileNotFoundException {
        generateToken.captureUserTokenAndWriteItOnAFile();
        generateToken.response.prettyPrint();
        token = generateToken.response.body().path("token");
        date = generateToken.response.body().path("expires").toString().substring(0, 10);
        System.out.println("token = " + token);
    }

    @Then("There are more than {int} days to expiry")
    public void there_are_more_than_days_to_expiry(Integer days) throws ParseException {
        Date tokenExpiryDate = sdf.parse(date);
        LocalDate tokenExpiryLocalDate = tokenExpiryDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        boolean isMoreThan5Days= LocalDate.now().plusDays(days).isBefore(tokenExpiryLocalDate);
        Assert.assertTrue(isMoreThan5Days);
    }

    @Then("Status is success in the response body")
    public void status_is_success_in_the_response_body() {
        Assert.assertEquals("Success", generateToken.response.body().path("status"));
    }

    @Then("{string} message is included in the response body")
    public void message_is_included_in_the_response_body(String resultMessage) {
        Assert.assertEquals(resultMessage, generateToken.response.body().path("result"));
    }
}
