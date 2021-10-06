package com.cucumber.junit.util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.cucumber.junit.driver.DriverManager.getDriver;

public class WebDriverWaiters {
    public void waitUntilBtnClickable(By locator) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilElementVisible(By locator, long timeout) {
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
