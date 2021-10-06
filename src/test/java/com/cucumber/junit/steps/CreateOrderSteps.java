package com.cucumber.junit.steps;

import com.cucumber.junit.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateOrderSteps {

    private HomePage homePage = new HomePage();
    private SearchResults searchResults = new SearchResults();
    private CartPage cartPage = new CartPage();
    private SignInRegister signInRegister = new SignInRegister();
    private CheckoutShipment checkoutShipment = new CheckoutShipment();

    @Given("the user opens Accelerator website")
    public void openAcceleratorWebsite() {
        homePage.openAcceleratorWebsite();
    }

    @When("the user clicks on advanced btn")
    public void enableOpenPage(){
        homePage.clickAdvancedBtn();
    }

    @And("the user clicks on proceed link")
    public void proceedOpenPage(){
        homePage.clickProceedLink();
    }

    @And("the user searches for a product with number {string}")
    public void searchForItem(String productNumber) {
        homePage.searchForItem(productNumber);
    }

    @And("the user adds item to order")
    public void addItemToOrder() {
        searchResults.clickAddToOrderBtn();
    }

    @And("the user clicks on checkout button")
    public void clickOnCheckoutButton() {
        searchResults.clickCheckoutBtn();
    }

    @And("the user clicks on checkout button on cart page")
    public void clickOnCheckoutButtonCartPage() {
        cartPage.clickCheckoutBtnCart();
    }

    @And("the user inputs email {string}")
    public void inputEmail(String email) {
        signInRegister.inputEmail(email);
    }

    @And("the user performs email confirmation {string}")
    public void performEmailConfirmation(String email) {
        signInRegister.inputEmailConfirmation(email);
    }

    @Then("order subtotal is displayed and equals {string}")
    public void verifyOrderSubtotalPresence(String expectedSubtotal) {
        checkoutShipment.verifyOrderSubtotal(expectedSubtotal);
    }

    @And("order total is displayed and equals {string}")
    public void verifyOrderTotalPresence(String expectedTotal) {
        checkoutShipment.verifyOrderTotal(expectedTotal);
    }

    @And("order tax is displayed and equals {string}")
    public void verifyOrderTaxPresence(String expectedTax) {
        checkoutShipment.verifyOrderTax(expectedTax);
    }

}
