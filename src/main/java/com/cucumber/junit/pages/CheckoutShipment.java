package com.cucumber.junit.pages;

import io.cucumber.datatable.DataTable;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static com.cucumber.junit.util.ActionsManager.newAction;
import static com.cucumber.junit.util.JsExecutorManager.executeJsScript;
import static com.cucumber.junit.util.SelectManager.newSelect;
import static org.junit.Assert.assertEquals;

public class CheckoutShipment extends BasePage {
    private static final By ORDER_SUBTOTAL = By.cssSelector(".subtotal span");
    private static final By ORDER_TOTAL = By.cssSelector(".totals span");
    private static final By ORDER_TAX = By.cssSelector("div.tax > span");
    private static final By DISCOUNTS = By.cssSelector(".subtotals__item--state-discount > span");
    private static final By COUNTRY_REGION_DROP_DOWN = By.xpath("//select[@id='address.country']");
    private static final By NEXT_BTN = By.xpath("//button[@id='addressSubmit']");
    private static final By NEXT_BTN_CONFIRMATION = By.xpath("//button[@id='deliveryMethodSubmit']");
    private static final By CARD_TYPE = By.xpath("//*[@id='card_cardType']");
    private static final By NAME_ON_CARD = By.xpath("//*[@id='card_nameOnCard']");
    private static final By CARD_NUMBER = By.xpath("//*[@id='card_accountNumber']");
    private static final By EXPIRY_YEAR = By.xpath("//*[@id='ExpiryYear']");
    private static final By EXPIRY_MONTH = By.xpath("//*[@id='ExpiryMonth']");
    private static final By CVV = By.xpath("//*[@id='card_cvNumber']");
    private static final By FIRST_NAME_MESSAGE = By.xpath("//*[@id='firstName.errors']");
    private static final By lAST_NAME_MESSAGE = By.xpath("//*[@id='lastName.errors']");
    private static final By ADDRESS_LINE1_MESSAGE = By.xpath("//*[@id='line1.errors']");
    private static final By CITY_MESSAGE = By.xpath("//*[@id='townCity.errors']");
    private static final By POST_CODE_MESSAGE = By.xpath("//*[@id='postcode.errors']");
    private static final By FIRST_NAME = By.xpath("//*[@id='address.firstName']");
    private static final By LAST_NAME = By.xpath("//*[@id='address.surname']");
    private static final By ADDRESS_LINE1 = By.xpath("//*[@id='address.line1']");
    private static final By CITY = By.xpath("//*[@id='address.townCity']");
    private static final By POST_CODE = By.xpath("//*[@id='address.postcode']");

    public CheckoutShipment verifyOrderSubtotal(String expectedSubtotal) {
        assertEquals("Order Subtotal is wrong", expectedSubtotal, findElement(ORDER_SUBTOTAL).getText());
        return this;
    }

    public CheckoutShipment verifyOrderTotal(String expectedTotal) {
        assertEquals("Order Total is wrong", expectedTotal, findElement(ORDER_TOTAL).getText());
        return this;
    }

    public CheckoutShipment verifyOrderTax(String expectedTax) {
        assertEquals("Order Tax is wrong", expectedTax, findElement(ORDER_TAX).getText());
        return this;
    }

    public CheckoutShipment selectCountryRegion(String country) {
        newSelect(COUNTRY_REGION_DROP_DOWN).selectByVisibleText(country);
        return this;
    }

    public CheckoutShipment clickNextBtn() {
        waitUntilBtnClickable(NEXT_BTN);
        executeJsScript("window.scrollBy(0,650)");
        findElement(NEXT_BTN).click();
        return this;
    }

    public CheckoutShipment clickNextBtnConfirmation() {
        newAction().moveToElement(findElement(NEXT_BTN_CONFIRMATION)).click().perform();
        return this;
    }

    public CheckoutShipment verifyOrderSummary(DataTable orderSummary) {
        Assertions.assertAll(
                () -> assertEquals("Order Subtotal is wrong", orderSummary.cell(1, 0), findElement(ORDER_SUBTOTAL).getText()),
                () -> assertEquals("Order Discounts is wrong", orderSummary.cell(1, 1), findElement(DISCOUNTS).getText()),
                () -> assertEquals("Order Tax is wrong", orderSummary.cell(1, 2), findElement(ORDER_TAX).getText()),
                () -> assertEquals("Order Total is wrong", orderSummary.cell(1, 3), findElement(ORDER_TOTAL).getText())
        );
        return this;
    }


   public CheckoutShipment verifyValidationMessages(DataTable validationMessages){
       executeJsScript("window.scrollBy(0,750)");
       Assertions.assertAll(
               () -> assertEquals("First Name message is wrong", validationMessages.cell(0,1), findElement(FIRST_NAME_MESSAGE).getText()),
               () -> assertEquals("Last Name message is wrong", validationMessages.cell(1,1), findElement(lAST_NAME_MESSAGE).getText()),
               () -> assertEquals("Address message is wrong", validationMessages.cell(2,1), findElement(ADDRESS_LINE1_MESSAGE).getText()),
               () -> assertEquals("City message is wrong", validationMessages.cell(3,1), findElement(CITY_MESSAGE).getText()),
               () -> assertEquals("Post Code message is wrong", validationMessages.cell(4,1), findElement(POST_CODE_MESSAGE).getText())
       );
       return this;
   }


/*    public String getFieldTextByName(String fieldName) {
        if ("firstName".equals(fieldName)) {
            return findElement(FIRST_NAME_MESSAGE).getText();
        } else if ("lastName".equals(fieldName)) {
            return findElement(lAST_NAME_MESSAGE).getText();
        } else if ("addressLine1".equals(fieldName)) {
            return findElement(ADDRESS_LINE1_MESSAGE).getText();
        } else if ("city".equals(fieldName)) {
            return findElement(CITY_MESSAGE).getText();
        } else if ("postCode".equals(fieldName)) {
            return findElement(POST_CODE_MESSAGE).getText();
        } else {
            return "";
        }
    }

 */

    public CheckoutShipment fillAddressInformation(DataTable addressInformation) {
        findElement(FIRST_NAME).sendKeys(addressInformation.cell(1, 0));
        findElement(LAST_NAME).sendKeys(addressInformation.cell(1, 1));
        findElement(ADDRESS_LINE1).sendKeys(addressInformation.cell(1, 2));
        findElement(CITY).sendKeys(addressInformation.cell(1, 3));
        findElement(POST_CODE).sendKeys(addressInformation.cell(1, 4));
        return this;
    }

    public CheckoutShipment enterCardDetails(DataTable cardDetails) {
        executeJsScript("window.scrollBy(0,500)");
        newSelect(CARD_TYPE).selectByVisibleText(cardDetails.cell(0, 1));
        findElement(NAME_ON_CARD).sendKeys(cardDetails.cell(1, 1));
        findElement(CARD_NUMBER).sendKeys(cardDetails.cell(2, 1));
        newSelect(EXPIRY_YEAR).selectByVisibleText(cardDetails.cell(3, 1));
        newSelect(EXPIRY_MONTH).selectByVisibleText(cardDetails.cell(4, 1));
        findElement(CVV).sendKeys(cardDetails.cell(5, 1));
        return this;
    }
/*
        public CheckoutShipment enterCardDetails(Map<String, String> cardDetails) {
        executeJsScript("window.scrollBy(0,500)");
        newSelect(CARD_TYPE).selectByVisibleText(cardDetails.get(CARD_TYPE_KEY));

 */
}
