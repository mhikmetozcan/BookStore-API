package com.demoQA.bookStore.pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.FileNotFoundException;
import java.util.List;

public class CompareBooksFromAPIAndUI extends TestBase{

    List<String> books;
    GenerateToken generateToken = new GenerateToken();
    PostNewUserWithAPI postNewUserWithAPI = new PostNewUserWithAPI();
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

}
