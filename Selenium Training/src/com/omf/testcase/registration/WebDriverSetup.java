package com.omf.testcase.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverSetup {

    String path = System.getProperty("user.dir");
    public WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", path + "/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public WebDriver getFirefoxDriver(){
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", false);
        WebDriver webDriver = new FirefoxDriver(options);
//        System.setProperty("webdriver.gecko.driver", path + "\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
        return webDriver;
    }

    public void setIEDriver(){
        System.setProperty("webdriver.ie.driver", path + "/iedriver.exe");
    }

}
