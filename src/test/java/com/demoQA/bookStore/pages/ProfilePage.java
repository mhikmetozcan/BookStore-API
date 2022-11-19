package com.demoQA.bookStore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends TestBase{
    @FindBy(id = "userName-value")
    public WebElement userNameTag;

    @FindBy(xpath = "//button[.='Log out']")
    public WebElement logoutButton;

}
