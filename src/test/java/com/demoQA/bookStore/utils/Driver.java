package com.demoQA.bookStore.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){

    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /**
     * Impelements Singleton Design Pattern for the WebDriver
     * @return WebDriver
     */
    public static WebDriver getDriver() {  //Singleton Design Pattern

        if(driverPool.get() == null){
            String browserType = ConfigurationReader.getProperty("browser");


            switch (browserType){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                // cases for other browser types can be added here as necessary
            }
        }

        return driverPool.get();

    }

    /**
     * Closes down the WebDriver instance after use
     */
    public static void closeDriver(){
        if(driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.set(null);
        }
    }

}
