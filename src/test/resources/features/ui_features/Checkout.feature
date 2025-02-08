@ui-test
Feature: Checkout Flow

  Background:
    Given the user access to Sauce Demo
    And the user logs in with STANDARD_USER credentials
    When the user add first 4 products to cart
    And click on the cart icon

  Scenario: Validate successfully checkout
    Given the user click on checkout button
    And the user fill the personal information form
      | firstName | lastName | postalCode |
      | John      | Smith    | 1111AA     |
    When the user click on finish button
    Then the purchase was completed successfully
    And successful purchase message and green check displayed

