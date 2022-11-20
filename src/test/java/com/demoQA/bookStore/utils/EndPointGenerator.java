package com.demoQA.bookStore.utils;

import com.demoQA.bookStore.pages.*;
import io.restassured.response.Response;

public class EndPointGenerator {

    PostNewUserWithAPI postNewUserWithAPI = new PostNewUserWithAPI();
    GenerateToken generateToken = new GenerateToken();
    AddBookToUser addBookToUser = new AddBookToUser();

    /**
     * Is used for reaching any endpoint with a single step definition
     * @param endPoint name of the button to be clicked
     */
    public Response goToEndPoint(String endPoint){
        setComponent();
        switch (endPoint){
            case "apiUSER":
                postNewUserWithAPI.response = postNewUserWithAPI.sendPostRequest();
                return postNewUserWithAPI.response;
            case "apiGenerateToken":
                generateToken.response = generateToken.sendPostRequest();
                return generateToken.response;
            case "apiAddBook":
                addBookToUser.response = addBookToUser.sendPostRequest();
                return addBookToUser.response;
        }

        return TestBase.response;
    }

    /**
     * Prepares the page object instance
     */
    public void setObject(){
        if(postNewUserWithAPI == null){
            postNewUserWithAPI = new PostNewUserWithAPI();
        }
        if(generateToken == null){
            generateToken = new GenerateToken();
        }
        if(addBookToUser == null){
            addBookToUser = new AddBookToUser();
        }

    }

    /**
     * Destroys previous instances of the page objects
     */
    public void resetObject(){
        postNewUserWithAPI = null;
        generateToken = null;
        addBookToUser = null;
    }

    /**
     * Sets the page objects for the use
     */
    public void setComponent(){
        resetObject();
        setObject();
    }
}
