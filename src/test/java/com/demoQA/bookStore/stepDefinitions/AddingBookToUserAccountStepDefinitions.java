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
        addBookToUser.response.prettyPrint();
        Assert.assertEquals( "9781449331818",  addBookToUser.response.body().path("books[0].isbn"));
     //   addBookToUser.response.prettyPrint();
    }
}
