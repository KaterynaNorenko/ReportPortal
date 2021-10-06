Feature: As a user I want to get ability to create order

  @regression
  Scenario: Proceed to checkout, final review and place order as guest user
    Given I open the Initial Home Page
    And I click on advanced btn
    And I click on proceed link
    And I search for "DSC WX"
    And I am redirected to a Search Results Page
    And Search results contain the following products
    And I apply the following search filters
    And Search results contain only the following products
    And I click Add to cart button for product with name DSC-WX1
    And I select Checkout in cart pop-up
    And I am redirected to a Cart page
    And Cart order summary is as following:
      | Tax                                 | Total   |
      | *No taxes are included in the total | $576.81 |
    And I click Checkout button on Cart page
    And I checkout as a new customer with email "test@user.com"
    And I perform email confirmation "test@user.com"
    And Checkout order summary is as following:
      | Sub Total | Discounts | Tax    | Total   |
      | $576.81   | - $20.00  | $28.84 | $605.65 |
    And I select the COUNTRY&REGION "Ukraine" manually
    And I click the next button
    And the following validation messages are displayed for shipping address
      | firstName       | Please enter a first name   |
      | lastName        | Please enter a last name    |
      | addressLine1    | Please enter address Line 1 |
      | city            | Please enter a Town/City    |
      | postCode        | Please enter post code      |
    And I fill delivery address information manually:
      | First Name | Last Name | Address Line1    | City | Postcode |
      | First      | Last      | Random address 1 | Kyiv | 123456   |
    When I press Next button on checkout
    And I confirm Shipment Method by pressing another Next button
    And I enter my card details
      | cardType    | Visa             |
      | nameOnCard  | Random Name      |
      | cardNumber  | 4111111111111111 |
      | expiryYear  | 2022             |
      | expiryMonth | 03               |
      | cvv         | 123              |