package com.selenium.test;

import com.base.core.automationBase.TestBase;
import com.selenium.common.CommonNavigation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 extends TestBase {
    CommonNavigation common;
    public Test1() {
        super();
    }

    @BeforeMethod
    public void loginToApplication() {
        common = new CommonNavigation();
        System.out.println("Login to the started");
        common.loginToOrangeHrm();
        System.out.println("Login to the application");
    }

    @Test
    public void m1() {
        System.out.println("Test method m1 started");
    }

    @Test
    public void m2() {
        System.out.println("Test method m2 started");
    }

}
