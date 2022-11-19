package com.demoQA.bookStore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends TestBase{

    @FindBy(id = "userName")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login")
    public WebElement loginButton;

    public void enterCredentials(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
    }



}
