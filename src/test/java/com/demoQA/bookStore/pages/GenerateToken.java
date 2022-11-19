package com.demoQA.bookStore.pages;

import com.demoQA.bookStore.utils.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class GenerateToken extends TestBase{

    public Map<String, Object> User(){
        Map<String, Object> user = new HashMap<>();
        user.put("userName", ConfigurationReader.getProperty("username"));
        user.put("password",ConfigurationReader.getProperty("password"));
        return user;
    }

    @Override
    public Response sendPostRequest(){
        response =  RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(User())
                .when().post(apiGenerateToken);
        return response;
    }

}
