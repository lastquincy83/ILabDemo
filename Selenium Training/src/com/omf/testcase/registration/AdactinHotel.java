package com.omf.testcase.registration;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class AdactinHotel {

    @Test
    public void runTest(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("http://adactinhotelapp.com");

        driver.findElement(By.name("username")).sendKeys("testingdd1234");
        driver.findElement(By.name("password")).sendKeys("Test1234");
        driver.findElement(By.name("login")).click();

        Select location = new Select(driver.findElement(By.name("location")));
        location.selectByVisibleText("Sydney");

        Select hotels = new Select(driver.findElement(By.name("hotels")));
        hotels.selectByVisibleText("Hotel Creek");

        Select roomType = new Select(driver.findElement(By.name("room_type")));
        roomType.selectByVisibleText("Standard");

        Select numberOfRooms = new Select(driver.findElement(By.name("room_nos")));
        numberOfRooms.selectByVisibleText("1 - One");

        driver.findElement(By.name("datepick_in")).clear();
        driver.findElement(By.name("datepick_in")).sendKeys(getCheckinDate(7));
        driver.findElement(By.name("datepick_out")).clear();
        driver.findElement(By.name("datepick_out")).sendKeys(getCheckinDate(5));

        Select adultsPerRoom = new Select(driver.findElement(By.name("adult_room")));
        adultsPerRoom.selectByVisibleText("2 - Two");

        Select childrenPerRoom = new Select(driver.findElement(By.name("child_room")));
        childrenPerRoom.selectByVisibleText("1 - One");

        driver.findElement(By.name("Submit")).click();

        Assert.assertEquals("Check-In Date shall be before than Check-Out Date", driver.findElement(By.id("checkin_span")).getText());
        Assert.assertEquals("Check-Out Date shall be after than Check-In Date", driver.findElement(By.id("checkout_span")).getText());

        // submit dates and options
        driver.findElement(By.name("datepick_in")).clear();
        driver.findElement(By.name("datepick_in")).sendKeys(getCheckinDate(-5));
        driver.findElement(By.name("datepick_out")).clear();
        driver.findElement(By.name("datepick_out")).sendKeys(getCheckinDate(-3));

        driver.findElement(By.name("Submit")).click();

//        Assert.assertEquals("Check-In Date shall be before than Check-Out Date", driver.findElement(By.id("checkin_span")).getText());
        // select option
        driver.findElement(By.name("radiobutton_0")).click();
        driver.findElement(By.name("continue")).click();



        Select cc_exp_month = new Select(driver.findElement(By.name("cc_exp_month")));
        cc_exp_month.selectByVisibleText("January");

        Select cc_exp_year = new Select(driver.findElement(By.name("cc_exp_year")));
        cc_exp_year.selectByVisibleText("2021");
    }

    public String getCheckinDate(int numberOfDays) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        //Number of Days to add
        c.add(Calendar.DAY_OF_MONTH, numberOfDays);
        //Date after adding the days to the given date
        return formatter.format(c.getTime());
    }
}
