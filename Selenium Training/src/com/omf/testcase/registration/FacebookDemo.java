package com.omf.testcase.registration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookDemo {

    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new WebDriverSetup().getChromeDriver();
//        new NewToursDemoAuto().runTest(driver);
//        new GoogleDemo().runTest(driver);
        new AdactinHotel().runTest(driver);
        driver.wait(2);
        driver.quit();
    }
}
