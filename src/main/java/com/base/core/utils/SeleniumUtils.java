package com.base.core.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SeleniumUtils {

    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (1000 * seconds));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Boolean isElementPresent(WebDriver driver, By locator, String errorMessage) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *locators: locators for which want to check visibility
     *errorMessage : error message
     **/
    public static Boolean isElementVisible(WebDriver driver, By locator, String errorMessage) {
        try {
            WebElement element = driver.findElement(locator);
            if (element.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *locators: locators for which want to apply web-driver wait
     *seconds : Wait in seconds
     **/
   public static void WebDriverWait(WebDriver driver, double seconds, By locators) {
        WebDriverWait wait = new WebDriverWait(driver, (long) (1000 * seconds));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locators));
    }

    /**    // Revisit
     *locators: locators for which want to apply fluent wait
     *seconds : Wait in seconds
     * pollingPeriod: pollingPeriod in seconds
     **/
   public static void FluentWait(WebDriver driver, double seconds, double pollingPeriod,By locators) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout((long)(1000*seconds), TimeUnit.SECONDS)
                .pollingEvery((long)(1000*pollingPeriod),TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public static void doubleClick(WebDriver driver , WebElement ele){
        Actions act = new Actions(driver);
        act.doubleClick(ele);
    }

    public static boolean isAlertPresent(WebDriver driver) {
        try{
            driver.switchTo().alert();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

}
