package com.demoQA.bookStore.stepDefinitions;

import com.demoQA.bookStore.pages.AddBookToUser;
import com.demoQA.bookStore.pages.GenerateToken;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddingBookToUserAccountStepDefinitions {

    AddBookToUser addBookToUser = new AddBookToUser();

    @And("ISBN exist in the response body")
    public void isbnExistInTheResponseBody() {
        Assert.assertEquals( "9781449337711",  addBookToUser.response.body().path("books.isbn").toString().substring(1,14));
        addBookToUser.response.prettyPrint();
    }
}
