package com.cucumber.junit.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;

import static com.cucumber.junit.util.ActionsManager.newAction;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPage extends BasePage{
    private static final By CHECKOUT_BTN_CART = By.xpath("//div[@class='cart__actions border']/descendant::button[@class='btn btn-primary btn-block btn--continue-checkout js-continue-checkout-button']");
    private static final By CART = By.xpath("//*[@class='cart-headline']");
    private static final By CART_ORDER_TAX = By.xpath("//div[@class='cart-totals-taxes text-right']");
    private static final By CART_ORDER_TOTAL = By.xpath("//div[@class='col-xs-6 cart-totals-right text-right grand-total']");

    public CartPage clickCheckoutBtnCart(){
        clickElement(CHECKOUT_BTN_CART);
        return this;
    }

    public CartPage verifyRedirectToCartPage(){
        assertTrue("Cart is not displayed", findElement(CART).isDisplayed());
        return this;
    }

    public CartPage verifyCartOrderSummary(DataTable cartOrderSummary){
        newAction().moveToElement(findElement(CART_ORDER_TAX)).perform();
        assertEquals("Order Tax is wrong", cartOrderSummary.cell(1,0), findElement(CART_ORDER_TAX).getText());
        newAction().moveToElement(findElement(CART_ORDER_TOTAL)).perform();
        assertEquals("Order Total is wrong", cartOrderSummary.cell(1,1), findElement(CART_ORDER_TOTAL).getText());
        return this;
    }
}
