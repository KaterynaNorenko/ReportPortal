package com.cucumber.junit.pages;

import com.cucumber.junit.driver.DriverManager;
import org.openqa.selenium.By;

import static com.cucumber.junit.util.ActionsManager.newAction;
import static org.openqa.selenium.Keys.ENTER;

public class HomePage extends BasePage {
    private static final String ACCELERATOR_URL = "https://ecsc00a08ec4:9002/yacceleratorstorefront/?site=electronics";
    private static final By SEARCH_INPUT = By.xpath("//*[@id='js-site-search-input']");
    private static final By ADVANCED_BTN = By.xpath("//button[@id='details-button']");
    private static final By PROCEED_LINK = By.xpath("//a[@id='proceed-link']");

    public void openAcceleratorWebsite(){
        DriverManager.getDriver().get(ACCELERATOR_URL);
    }

    public HomePage clickAdvancedBtn(){
        clickElement(ADVANCED_BTN);
        return this;
    }

    public HomePage clickProceedLink(){
        clickElement(PROCEED_LINK);
        return this;
    }

    public HomePage searchForItem(String productNumber){
        newAction().moveToElement(findElement(SEARCH_INPUT)).click().sendKeys(productNumber).sendKeys(ENTER).perform();
        return this;
    }
}
