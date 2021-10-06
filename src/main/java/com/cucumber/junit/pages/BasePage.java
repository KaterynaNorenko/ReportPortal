package com.cucumber.junit.pages;

import com.cucumber.junit.util.WebDriverWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.cucumber.junit.driver.DriverManager.getDriver;

public class BasePage extends WebDriverWaiters {

    public BasePage(){
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement findElement (By by) {
        return getDriver().findElement(by);
    }

    public BasePage clickElement(By by){
        getDriver().findElement(by).click();
        return this;
    }

}
