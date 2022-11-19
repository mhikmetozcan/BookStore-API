package com.demoQA.bookStore.stepDefinitions;

import com.demoQA.bookStore.utils.BrowserUtils;
import com.demoQA.bookStore.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public static void beforeClass() {
        RestAssured.baseURI = "https://demoqa.com";
    }

    //After scenario ends the WebDriver session and takes screenshot if the scenario fails
    @After
    public void tearDownScenario(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());
        }
        BrowserUtils.waitFor(5);
        Driver.closeDriver();
    }
}

