package com.demoQA.bookStore.pages;

import com.demoQA.bookStore.utils.Driver;
import static io.restassured.RestAssured.*;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.openqa.selenium.support.PageFactory;

public abstract class TestBase {
    public TestBase(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

   public final String apiGenerateToken = "/Account/v1/GenerateToken";
   public final String apiLogin = "/Account/v1/Login";
   public final String apiAuthorized = "/Account/v1/Authorized";
   public final String apiUser = "/Account/v1/User";
   public final String apiGetUser = "/Account/v1/User/UUID";
   public final String apiAddBook = "/BookStore/v1/Books";
   public final String uiLogin = "/login";
   public final String uiProfile = "/profile";
   public final String uiBooks = "/books";



}
