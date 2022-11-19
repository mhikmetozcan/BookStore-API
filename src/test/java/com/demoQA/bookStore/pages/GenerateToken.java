package com.demoQA.bookStore.pages;

import com.demoQA.bookStore.utils.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GenerateToken extends TestBase{

    File outFile = new File(ConfigurationReader.getProperty("filePathToken"));
    PrintWriter output;
    String token;

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

    public void captureUserTokenAndWriteItOnAFile() throws FileNotFoundException {
        Map<String, Object> userIDMap = response.as(Map.class);
        token = (String) userIDMap.get("token");
        if(outFile.exists()){
            outFile.delete();
        }
        output = new PrintWriter(outFile);
        output.println(token);
        output.close();
    }

    public String getUserID() throws FileNotFoundException {
        Scanner s = new Scanner(outFile);
        return s.next();
    }

}
