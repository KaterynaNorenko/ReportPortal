package com.cucumber.junit.util;

import org.openqa.selenium.interactions.Actions;

import static com.cucumber.junit.driver.DriverManager.getDriver;

public class ActionsManager {

    public static Actions newAction(){
        return new Actions(getDriver());
    }
}
