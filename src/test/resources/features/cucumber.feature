Feature: As a User, I want to be able to navigate to Products page

  Background: Starting from the Home page
    Given I am on the Home Page

  Scenario: Navigate to the Products page from Home page
    When I click on the Products button
    Then I will go to the Products page