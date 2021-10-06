package com.cucumber.junit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.cucumber.junit.util.ActionsManager.newAction;

public class SignInRegister extends BasePage{
    private static final By EMAIL_INPUT = By.xpath("//input[@id='guest.email']");
    private static final By EMAIL_INPUT_CONFIRMATION = By.xpath("//input[@id='guest.confirm.email']");

 public SignInRegister inputEmail(String email){
     newAction().moveToElement(findElement(EMAIL_INPUT)).click().sendKeys(email).sendKeys(Keys.ENTER).perform();
     return this;
 }

 public SignInRegister inputEmailConfirmation (String email){
     newAction().moveToElement(findElement(EMAIL_INPUT_CONFIRMATION)).click().sendKeys(email).sendKeys(Keys.ENTER).perform();
     return this;
 }
}
