package com.selenium.test;

import com.selenium.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 extends TestBase {

    public Test1() {
        super();
    }

    @BeforeMethod
    public void loginToApplication() {
        System.out.println("Login to the application");
    }

    @Test
    public void m1(){
        System.out.println("Test method m1 started");
    }

    @Test
    public void m2(){
        System.out.println("Test method m2 started");
    }

}
