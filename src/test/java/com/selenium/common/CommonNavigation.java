package com.selenium.common;

import com.base.core.automationBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonNavigation extends TestBase {
    @FindBy(xpath="//input[@name='username']")
    WebElement username;
    @FindBy(xpath="//input[@name='password']")
    WebElement password;
    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    WebElement loginButton;

    public CommonNavigation() {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public void loginToOrangeHrm() {
        username.sendKeys("username");
        password.sendKeys(pro.getProperty("password"));
        loginButton.click();
    }
}
