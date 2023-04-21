Feature: As a User, I want to be able to navigate to Products page

  Background: Starting from the Home page
    Given I am on the Home Page
    When I click on the Products button

  Scenario: Navigate to the Products page from Home page
    Then I will go to the Products page

  Scenario: Navigate to the Product page from Home page and write "Dress" on search bar
    And I click on the search bar
    And Enter "Dress" and press enter
    Then I will go to Dress page

    Scenario: On the Product page search for "Dress" and press search button
      And Enter "Dress" on search bar
      And Press on search button
      Then I will go to Dress page