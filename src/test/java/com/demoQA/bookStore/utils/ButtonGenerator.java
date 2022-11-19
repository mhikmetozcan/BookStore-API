package com.demoQA.bookStore.utils;

import com.demoQA.bookStore.pages.LogInPage;

public class ButtonGenerator {


    LogInPage logInPage = new LogInPage();

    /**
     * Is used for clicking any button with a single step definition as "click on 'button'"
     * @param buttonName name of the button to be clicked
     */
    public void clickButton(String buttonName){
        setComponent();
        switch (buttonName){
            case "login":
                logInPage.loginButton.click();
                break;
            case "another button":

                break;
            case "yet another button":

                break;
        }
    }

    /**
     * Prepares the page object instance
     */
    public void setObject(){
        if(logInPage == null){
            logInPage = new LogInPage();
        }

    }

    /**
     * Destroys previous instances of the page objects
     */
    public void resetObject(){
        logInPage = null;
    }

    /**
     * Sets the page objects for the use
     */
    public void setComponent(){
        resetObject();
        setObject();
    }
}
