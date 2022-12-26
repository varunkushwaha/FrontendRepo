package com.selenium.common;

import com.base.core.automationBase.TestBase;
import org.openqa.selenium.WebDriver;

public class CommonFlow extends TestBase {
    private WebDriver driver = null;
    private CommonPage common = null;


    public CommonFlow(WebDriver driver) {
        this.driver = driver;
        this.common = new CommonPage(driver);
    }

    public void loginToApplication(){
        common.username().sendKeys(pro.getProperty("username"));
        common.password().sendKeys(pro.getProperty("password"));
        common.loginButton().click();
    }
}
