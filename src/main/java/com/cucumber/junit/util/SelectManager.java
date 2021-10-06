package com.cucumber.junit.util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.cucumber.junit.driver.DriverManager.getDriver;

public class SelectManager {
    public static Select newSelect(By by){return new Select (getDriver().findElement(by)); }
}
