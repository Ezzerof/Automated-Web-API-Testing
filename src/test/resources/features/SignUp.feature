Feature: As a User, I want to be able to sign up so that I can use the website

  @jr
  Scenario: Navigating to the sign up page
    Given I am on the main page
    When I click on the Signup link
    Then I should go to the Signup page


  @jr
  Scenario: Entering details on sign up page
    Given I am on the sign up page
    When I enter details
    Then I should go to the account information page