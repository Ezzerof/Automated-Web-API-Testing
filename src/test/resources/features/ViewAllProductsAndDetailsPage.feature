## Happy Scenario:
Feature: View product Details

Background: Starting from the home page
Given I am on the automation exercise website


Scenario : Verify that all product details are visible on product detail page
  And I click on the 'Products' button
  And User is in the ALL PRODUCTS page
  When User clicks 'View Product' of first product
  Then User should be in the product detail page
  And The following are visible : product name, category, price, availability, condition, brand

