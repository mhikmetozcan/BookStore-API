package com.demoQA.bookStore.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class BrowserUtils {
    /**
     * Clicks on an element using JavaScript
     *
     * @param element the web element for the JS executor to click
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * This method will accept a dropdown as a WebElement
     * and return all the options in a List of WebElements.
     * @param dropdownElement the dropdown element whose options are extracted into a list
     * @return List<WebElement> actualOptionsAsWebElement
     */
    public static List<WebElement> dropdownOptions(WebElement dropdownElement){
        Select select = new Select(dropdownElement);
        return select.getOptions();
    }

    /**
     * Switches to new window by the exact title. Returns to original window if target title not found
     * @param targetTitle Title of the target window
     */
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    /**
     * Performs a pause
     *
     * @param seconds to wait
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Presses ctrl+v in order to paste the content on the clipboard into the text input field
     */

    public static void pasteContent()  {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
    }


    /**
     * Presses Enter key
     */
    public static void hitEnter() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    /**
     * Checks and accepts if an alert window pops up
     */
    public static void checkAlert(){
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.accept();
        } catch (org.openqa.selenium.UnhandledAlertException e) {
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.accept();
            System.out.println("There is no alert");
        }
    }
}
