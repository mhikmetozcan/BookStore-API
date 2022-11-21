package com.demoQA.bookStore.stepDefinitions;

import com.demoQA.bookStore.pages.CompareBooksFromAPIAndUI;
import com.demoQA.bookStore.pages.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompareBooksFromAPIAndUIStepDefinitions {

    CompareBooksFromAPIAndUI compareBooks = new CompareBooksFromAPIAndUI();
    @When("user sends GET request to {string} endpoint")
    public void user_sends_get_request_to_endpoint(String endPoint) {
        compareBooks.response = compareBooks.sendGetRequest();
        compareBooks.response.prettyPrint();
    }
    @Then("user gets the list of books that are registered to them")
    public void user_gets_the_list_of_books_that_are_registered_to_them() {

    }


}
