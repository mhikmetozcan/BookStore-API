package com.demoQA.bookStore.stepDefinitions;

import com.demoQA.bookStore.pages.CompareBooksFromAPIAndUI;
import com.demoQA.bookStore.pages.TestBase;
import com.demoQA.bookStore.utils.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class CompareBooksFromAPIAndUIStepDefinitions {

    CompareBooksFromAPIAndUI compareBooks = new CompareBooksFromAPIAndUI();
    @When("user sends GET request to {string} endpoint")
    public void user_sends_get_request_to_endpoint(String endPoint) {
        compareBooks.response = compareBooks.sendGetRequest();
        compareBooks.response.prettyPrint();
    }
    @Then("user gets the list of books that are registered to them and verifies each book appears on their profile")
    public void user_gets_the_list_of_books_that_are_registered_to_them() {
        JsonPath json = compareBooks.response.jsonPath();
        compareBooks.booksFromAPI = json.getList("books.isbn");
        BrowserUtils.waitFor(2);
        compareBooks.booksFromUI = compareBooks.addEachBookFromUIToList(compareBooks.booksFromAPI,compareBooks.booksListAsWebElements);
        Assert.assertEquals(compareBooks.booksFromAPI,compareBooks.booksFromUI);
    }

}
