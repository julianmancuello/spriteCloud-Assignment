@ui-test @regressions
Feature: Cart Functionality

  Background:
    Given the user access to Sauce Demo
    And the user logs in with STANDARD_USER credentials

  Scenario: Products added to the cart appear in the cart
    When the user add first 4 products to cart
    And click on the cart icon
    Then check the products were added successfully to the cart