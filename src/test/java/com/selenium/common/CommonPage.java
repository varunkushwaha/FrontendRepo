package com.selenium.common;

import com.base.core.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonPage {
    WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement username() {
        return driver.findElement(By.name("username"));
    }

    public WebElement password() {
        return driver.findElement(By.name("password"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
    }


}
