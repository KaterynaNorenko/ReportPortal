package com.cucumber.junit.hooks;

import com.cucumber.junit.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class DriverHooks {

    @Before
    public void setupDriver(){
        DriverManager.setupDriver();
    }

    @After
            //(order=1)
    public void quitDriver(){
        DriverManager.quitDriver();
    }

//  if I had more than 1 scenario for 1 session
//    @After(order=5)
//    public void cleanSession(){
//        DriverManager.getDriver().manage().deleteAllCookies();
//    }
}
