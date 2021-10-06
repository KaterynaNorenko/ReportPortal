package com.cucumber.junit.steps;

import com.cucumber.junit.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static org.junit.Assert.*;

public class DesktopCheckoutForGuestUserSteps {

    final static Logger logger = Logger.getLogger(DesktopCheckoutForGuestUserSteps.class);

    private HomePage homePage = new HomePage();
    private SearchResults searchResults = new SearchResults();
    private CartPage cartPage = new CartPage();
    private SignInRegister signInRegister = new SignInRegister();
    private CheckoutShipment checkoutShipment = new CheckoutShipment();

    @Given("I open the Initial Home Page")
    public void openHomePage() {
        homePage.openAcceleratorWebsite();
        logger.info("User opens the Initial Home Page");
    }

    @And("I click on advanced btn")
    public void enableOpenPage() {
        homePage.clickAdvancedBtn();
    }

    @And("I click on proceed link")
    public void proceedOpenPage() {
        homePage.clickProceedLink();
    }

    @And("I search for {string}")
    public void searchForItem(String productNumber) {
        homePage.searchForItem(productNumber);
        logger.info("User searches for a product");
    }

    @And("I am redirected to a Search Results Page")
    public void redirectToSearchResults() {
        assertTrue("Search Results are not displayed", searchResults.isResultsDisplayed());
    }

    @And("Search results contain the following products")
    public void searchResultsContainProducts() {
        searchResults.verifyPresenceOfElements();
    }

    @And("I apply the following search filters")
    public void applySearchFilters() {
        searchResults.applyFilters();
        logger.info("User applies filters");
    }

    @And("Search results contain only the following products")
    public void searchResultsContainOnlyTheFollowingProducts() {
        searchResults.verifyOnlyProducts();
    }

    @And("I click Add to cart button for product with name DSC-WX1")
    public void clickAddToCartButtonForProductWithName() {
        searchResults.clickAddToCartBtn();
        logger.info("User adds a product to cart");
    }

    @And("I select Checkout in cart pop-up")
    public void selectCheckoutInCartPopUp() {
        searchResults.clickCheckoutBtn();
    }

    @And("I am redirected to a Cart page")
    public void redirectToCartPage() {
        cartPage.verifyRedirectToCartPage();
    }

    @And("Cart order summary is as following:")
    public void cartOrderSummaryIsFollowing(DataTable cartOrderSummary) {
        cartPage.verifyCartOrderSummary(cartOrderSummary);
        logger.info("User checks the cart order summary");
    }

    @And("I click Checkout button on Cart page")
    public void clickCheckoutButtonOnCartPage() {
        cartPage.clickCheckoutBtnCart();
    }

    @And("I checkout as a new customer with email {string}")
    public void checkoutAsANewCustomerWithEmail(String email) {
        signInRegister.inputEmail(email);
        logger.info("User registers as a new customer");
    }

    @And("I perform email confirmation {string}")
    public void performEmailConfirmation(String email) {
        signInRegister.inputEmailConfirmation(email);
        logger.info("User confirms the email");
    }

    @And("Checkout order summary is as following:")
    public void checkoutOrderSummaryIsAsFollowing(DataTable orderSummary) {
        checkoutShipment.verifyOrderSummary(orderSummary);
        logger.info("User verifies order summary");
    }

    @And("I select the COUNTRY&REGION {string} manually")
    public void selectCountryRegionManually(String country) {
        checkoutShipment.selectCountryRegion(country);
        logger.info("User selects the country");
    }

    @And("I click the next button")
    public void clickTheNextButton() {
        checkoutShipment.clickNextBtn();
        logger.info("User proceeds to the shipment");
    }

    @And("the following validation messages are displayed for shipping address")
    public void verifyValidationMessagesAreDisplayedForShippingAddress(DataTable validationMessages) {
        checkoutShipment.verifyValidationMessages(validationMessages);
        logger.info("User is not able to order without filling in the address form");
        }

    @And("I fill delivery address information manually:")
    public void fillDeliveryAddressInformationManually(DataTable addressInformation) {
        checkoutShipment.fillAddressInformation(addressInformation);
        logger.info("User fills in the address information");
    }

    @When("I press Next button on checkout")
    public void pressNextButtonOnCheckout() {
        checkoutShipment.clickNextBtn();
    }

    @And("I confirm Shipment Method by pressing another Next button")
    public void confirmShipmentMethodByPressingAnotherNextButton() {
        checkoutShipment.clickNextBtnConfirmation();
        logger.info("User confirms shipment");
    }

    @And("I enter my card details")
    public void enterMyCardDetails(DataTable cardDetails) {
        checkoutShipment.enterCardDetails(cardDetails);
        logger.info("User provides card details");
    }
}
