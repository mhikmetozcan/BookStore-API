package com.demoQA.bookStore.pages;

import com.demoQA.bookStore.utils.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddBookToUser extends TestBase{
    PostNewUserWithAPI postNewUserWithAPI = new PostNewUserWithAPI();
    GenerateToken generateToken = new GenerateToken();

    public Map<String, Object> addBook() throws FileNotFoundException {
        Map<String, Object> book = new HashMap<>();
        book.put("userId", postNewUserWithAPI.getUserID());
        Map<String,String> isbns= new HashMap<>();
        isbns.put("isbn", "9781449331818");
        List<Map> listOfIsbns = new ArrayList<>();
        listOfIsbns.add(isbns);
        book.put("collectionOfIsbns",listOfIsbns);
        return book;
    }

    public Response sendPostRequest(){
       try{ response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON).header("Authorization", "Bearer "+generateToken.getUserToken())
                .body(addBook())
               .when().post(apiAddBook);
       }
       catch (FileNotFoundException e){
           e.printStackTrace();
       }
        return response;
    }
}
