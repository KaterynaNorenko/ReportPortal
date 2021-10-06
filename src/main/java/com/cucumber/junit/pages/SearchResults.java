package com.cucumber.junit.pages;

import org.openqa.selenium.By;

import static com.cucumber.junit.util.ActionsManager.newAction;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchResults extends BasePage {
    private static final By ADD_TO_ORDER_BTN = By.xpath("//form[@id='addToCartForm1934793']/descendant::button[@type='submit']");
    private static final By CHECKOUT_BTN = By.xpath("//a[@href='/yacceleratorstorefront/electronics/en/cart' and @class='btn btn-primary btn-block add-to-cart-button']");
    private static final By RESULTS = By.xpath("//div[@class='results']");
    private static final By ADD_TO_CART_BTN = By.cssSelector("#addToCartForm3514521 > button");
    private static final By LI_ION = By.xpath("//a[@class='product__list--name' and contains(@href, '1451563')]");
    private static final By DSC_WX1 = By.xpath("//a[@class='product__list--name' and contains(@href, '3514521')]");
    private static final By DSC_N1 = By.xpath("//a[@class='product__list--name' and contains(@href, '358639')]");
    private static final By DSLR_A330 = By.xpath("//a[@class='product__list--name' and contains(@href, '2934302')]");
    private static final By CHECKBOX_SHOP_BY_PRICE = By.xpath("//span[contains(text(), '$500-$999')]/preceding::span[@class='facet__list__mark'][1]");
    private static final By CHECKBOX_SHOP_BY_MEGAPIXELS = By.xpath("//span[contains(text(), '10 - 10')]/preceding::span[@class='facet__list__mark'][1]");
    private static final By FILTER_SHOP_BY_BRAND = By.xpath("//a[contains(@href, 'Abrand') and contains (text(), 'Sony')]");
    private static final By SIZE_OF_RESULTS = By.xpath("//div[@class='pagination-bar-results']");

    public SearchResults clickCheckoutBtn() {
        waitUntilElementVisible(CHECKOUT_BTN, 10);
        clickElement(CHECKOUT_BTN);
        return this;
    }

    public SearchResults clickAddToOrderBtn() {
        waitUntilElementVisible(ADD_TO_ORDER_BTN, 10);
        clickElement(ADD_TO_ORDER_BTN);
        return this;
    }

/*  delete method
          public SearchResults verifyResultsAreDisplayed(){
          findElement(RESULTS).isDisplayed();
          assertTrue("Search Results are not displayed", findElement(RESULTS).isDisplayed());
          return this;
    }
*/

    public boolean isResultsDisplayed(){
        return findElement(RESULTS).isDisplayed();
    }

    public SearchResults verifyPresenceOfElements(){
        findElement(LI_ION).isDisplayed();
        newAction().moveToElement(findElement(DSC_WX1)).perform();
        findElement(DSC_WX1).isDisplayed();
        newAction().moveToElement(findElement(DSC_N1)).perform();
        findElement(DSC_N1).isDisplayed();
        return this;
    }

    public SearchResults applyFilters(){
        newAction().moveToElement(findElement(CHECKBOX_SHOP_BY_PRICE)).click().perform();
        waitUntilElementVisible(RESULTS, 10);
        newAction().moveToElement(findElement(CHECKBOX_SHOP_BY_MEGAPIXELS)).click().perform();
        waitUntilElementVisible(RESULTS, 10);
        newAction().moveToElement(findElement(FILTER_SHOP_BY_BRAND)).click().perform();
        waitUntilElementVisible(RESULTS, 10);
        return this;
    }

    public SearchResults verifyOnlyProducts(){
        assertEquals("Number of found products is wrong", "2 Products found", findElement(SIZE_OF_RESULTS).getText());
        findElement(DSC_WX1).isDisplayed();
        newAction().moveToElement(findElement(DSLR_A330)).perform();
        findElement(DSLR_A330).isDisplayed();
        return this;
    }

    public SearchResults clickAddToCartBtn(){
        waitUntilElementVisible(ADD_TO_CART_BTN, 10);
        clickElement(ADD_TO_CART_BTN);
        return this;
    }

}