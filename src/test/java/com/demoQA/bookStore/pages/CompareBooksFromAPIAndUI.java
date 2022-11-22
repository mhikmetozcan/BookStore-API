package com.demoQA.bookStore.pages;

import com.demoQA.bookStore.utils.BrowserUtils;
import com.demoQA.bookStore.utils.ConfigurationReader;
import com.demoQA.bookStore.utils.Driver;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompareBooksFromAPIAndUI extends TestBase{

    public List<String> booksFromAPI = new ArrayList<>();
    GenerateToken generateToken = new GenerateToken();
    PostNewUserWithAPI postNewUserWithAPI = new PostNewUserWithAPI();
    public List<String> booksFromUI = new ArrayList<>();
    LogInPage logInPage =new LogInPage();

    @FindBy(xpath = "//div[@class='rt-tr-group']//a")
    public List<WebElement> booksListAsWebElements;


    @FindBy(id = "userName-value")
    public WebElement isbnNumber;

//    @Test
//    public void test(){
//        Driver.getDriver().get(ConfigurationReader.getProperty("logInPageURL"));
//        logInPage.enterCredentials(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
//        logInPage.loginButton.click();
//        BrowserUtils.waitFor(2);
//        System.out.println("booksListAsWebElements.size() = " + booksListAsWebElements.size());
//        booksListAsWebElements.get(0).click();
//        Driver.getDriver().navigate().back();
//        booksListAsWebElements.get(1).click();
//        Driver.getDriver().navigate().back();
//        Driver.getDriver().close();
//    }



    @Override
    public Response sendGetRequest(){
       try{
           response = RestAssured.given().accept(ContentType.JSON)
                   .and().contentType(ContentType.JSON)
                   .header("Authorization", "Bearer "+generateToken.getUserToken())
                   .pathParam("id", postNewUserWithAPI.getUserID())
                   .when().get(apiGetUser+"/{id}");
       }catch(FileNotFoundException e){
           e.printStackTrace();
       }
       return response;
    }

    public List<String> addEachBookFromUIToList(@NotNull List<String> listAPI, List<WebElement> webElements ){
        List<String> booksFromUI = new ArrayList<>();
        for(int a = 0; a< listAPI.size(); a++){
            webElements.get(a).click();
            booksFromUI.add(isbnNumber.getText());
            Driver.getDriver().navigate().back();
        }
        return booksFromUI;
    }

}
