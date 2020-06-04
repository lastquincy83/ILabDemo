package com.omf.testcase.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GoogleDemo {

    public void runTest(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();



        driver.navigate().to("http://facebook.com");
        // navigate methods
        driver.navigate().back();
        driver.navigate().forward();
    }
}
