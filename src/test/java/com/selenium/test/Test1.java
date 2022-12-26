package com.selenium.test;

import com.base.core.automationBase.TestBase;
import com.base.core.utils.SeleniumUtils;
import com.selenium.common.CommonFlow;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 extends TestBase {
    CommonFlow flow ;
    public Test1() {
        super();
    }

    @BeforeMethod
    public void loginToApplication() throws InterruptedException {
        System.out.println("Login to the started");
        flow = new CommonFlow(driver);
        flow.loginToApplication();
        SeleniumUtils.sleep(10);
        System.out.println("Login to the application successfully");
    }

    @Test
    public void m1() {
        System.out.println("Test method m1 started");
    }

    @Test
    public void m2() {
        System.out.println("Test method m2 started");
    }

    @Test
    public void m3() {
        System.out.println("Test method m3 started");
    }

    @Test
    public void m4() {
        System.out.println("Test method m4 started");
    }

    @Test
    public void m5() {
        System.out.println("Test method m5 started");
    }

    @Test
    public void m6() {
        System.out.println("Test method m6 started");
    }

    @Test
    public void m7() {
        System.out.println("Test method m7 started");
    }

    @Test
    public void m8() {
        System.out.println("Test method m8 started");
    }

    @Test
    public void m9() {
        System.out.println("Test method m9 started");
    }
}
