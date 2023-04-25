Feature: Register While Checkout
  Background:
    Given Iam on HomePage of automation exercise
@Ag
    Scenario:

      When I click on add to cart option
      Then products should be added to the cart

      When I click on cart page
      Then I can navigate to cart page
      And I can see the added products

      When I click on proceed to checkout
      Then It should show Register_login button

      When I click on Register_login button
      Then It should navigate to login page

      When I enter UserName and Email
      And I click on Signup button
      Then It should navigate to signup page

      When I enter All Details
      And I click on create account button
      Then It should show  ACCOUNT CREATED! and click Continue button
      And it should show Logged in as username at top

      When I click on Cart button
      And click on Proceed To Checkout' button
      Then It should show Address Details and Review Your Order

      When I Enter description in comment text area and click Place Order
      And Enter payment details: Name on Card, Card Number, CVC, Expiration date
      And Click Pay and Confirm Order button
      Then it should show Your order has been placed successfully!

      When I click Delete Account button
      Then it should show ACCOUNT DELETED! message and click Continue button



