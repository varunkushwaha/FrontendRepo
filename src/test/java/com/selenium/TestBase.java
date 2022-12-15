package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties pro;

    public TestBase() {
        try {
            String FilePath = "src/test/Resources/config/config.properties";
            File scr = new File(FilePath);
            FileInputStream fs = new FileInputStream(scr);
            pro = new Properties();
            pro.load(fs);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeMethod
    public static void initialization() {
        String browserName = pro.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("Chrome browser started");
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(selectEnvironmentUrl());
        System.out.println("Url started = " + pro.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public static String selectEnvironmentUrl() {
        String baseUrl = null;
        String environment = pro.getProperty("environment");
        System.out.println("Selected environment is:" + environment);
        if (environment.equals("DEV")) {
            baseUrl = "https://www.google.com/";
        } else if (environment.equals("QA")) {
            baseUrl = "https://www.facebook.com/";
        } else if (environment.equals("UAT")) {
            baseUrl = "https://www.amazon.in/";
        } else if (environment.equals("PROD")) {
            baseUrl = "https://www.flipkart.com/";
        } else {
            System.out.println("Invalid environment: " + environment);
        }
        return baseUrl;
    }
}
