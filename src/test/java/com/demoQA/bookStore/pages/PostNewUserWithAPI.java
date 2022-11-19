package com.demoQA.bookStore.pages;

import com.demoQA.bookStore.utils.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PostNewUserWithAPI extends TestBase{

    public Response response;
    File outFile = new File(ConfigurationReader.getProperty("filePath"));
    PrintWriter output;
    String userID;

    public Map<String, Object> createNewUser(){
        Map<String, Object> newUser = new HashMap<>();
        newUser.put("userName",ConfigurationReader.getProperty("username"));
        newUser.put("password",ConfigurationReader.getProperty("password"));
        return newUser;
    }

    public Response sendPostRequest(){
      response =  RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(createNewUser())
                .when().post(apiUser);
      return response;
    }

    public void captureUserIdAndWriteItOnAFile() throws FileNotFoundException {
        Map<String, Object> userIDMap = response.as(Map.class);
        userID = (String) userIDMap.get("userID");
        if(outFile.exists()){
            outFile.delete();
        }
        output = new PrintWriter(outFile);
        output.println(userID);
        output.close();
    }

    public String getUserID() throws FileNotFoundException {
        Scanner s = new Scanner(outFile);
        return s.next();
    }


}
