package com.omf.testcase.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NewToursDemoAuto {

    public void runTest(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://www.newtours.demoaut.com");
        Actions actions = new Actions(driver);

        actions.keyDown(Keys.LEFT_CONTROL)
                .click(driver.findElement(By.linkText("REGISTER")))
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        // Contact information
        driver.findElement(By.name("firstName")).sendKeys("Damian");
        driver.findElement(By.name("lastName")).sendKeys("Naidoo");
        driver.findElement(By.name("phone")).sendKeys("0611234567");
        driver.findElement(By.name("userName")).sendKeys("test@test.com");

        // Mailing information
        driver.findElement(By.name("address1")).sendKeys("21 faraway Street");
        driver.findElement(By.name("address2")).sendKeys("faraway place");
        driver.findElement(By.name("city")).sendKeys("faraway city");
        driver.findElement(By.name("state")).sendKeys("faraway state");
        driver.findElement(By.name("postalCode")).sendKeys("7441");
        Select country = new Select(driver.findElement(By.name("country")));
        country.selectByVisibleText("JAPAN");

        // User information
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.name("password")).sendKeys("Test1234");
        driver.findElement(By.name("confirmPassword")).sendKeys("Test1234");

        // Submit Button
        driver.findElement(By.name("register")).click();

        // Sign-on link
        driver.findElement(By.partialLinkText("sign")).click();

        // Login
        driver.findElement(By.name("userName")).sendKeys("test@test.com");
        driver.findElement(By.name("password")).sendKeys("Test1234");
        driver.findElement(By.name("login")).submit();
    }
}
