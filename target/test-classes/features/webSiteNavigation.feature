Feature: As a User, I want to be able to navigate the automation exercise Website
<<<<<<< HEAD
@ah
  Background: Starting from the homepage
    Given I am on the automation exercise Website
@ah
  Scenario: Navigating to the products page from the Home page

    When I click on the products link
    Then I will go to the products Page
@ah
=======

  Background: Starting from the homepage
    Given I am on the automation exercise Website

  @webNav
  Scenario: Navigating to the products page from the Home page
    When I click on the products link
    Then I will go to the products Page

<<<<<<< HEAD
  @webNav
  Scenario: Navigating to the cart page from the Home page
    When I click on the cart link
    Then I will go to the cart page

  @webNav
  Scenario: Navigating to the SignIn page from the Home page
    When I click on the Signup\/Login link
    Then I will go to the sign in page

  @webNav
  Scenario: Navigating to the Test cases page from the Home page
=======
  @wnf
>>>>>>> dev
  Scenario:  Navigating to the cart page from the Home page
    When I click on the cart link
    Then I will go to the cart page

<<<<<<< HEAD
@ah
  Scenario:  Navigating to the SignIn page from the Home page
#    When I click on the Signup/Login link
    Then I will go to the sign In page
@ah
  Scenario:  Navigating to the Test cases page from the Home page
    When I click on the Test cases link
    Then I will go to the Test cases page
@ah
  Scenario:  Navigating to the API Testing page from the Home page
    When I click on the API Testing link
    Then I will go to the API Testing page
@ah
  Scenario:  Navigating to the Video Tutorials page from the Home page
    When I click on the video tutorials link
    Then I will go to the Video Tutorials page
@ah
=======
  @wnf
  Scenario:  Navigating to the SignIn page from the Home page
    When I click on the Signup/Login link
    Then I will go to the sign In page
  @wnf
  Scenario:  Navigating to the Test cases page from the Home page
>>>>>>> dev
    When I click on the Test cases link
    Then I will go to the Test cases page

  @webNav
  Scenario: Navigating to the API Testing page from the Home page
    When I click on the API Testing link
    Then I will go to the API Testing page

  @webNav
  Scenario: Navigating to the Video Tutorials page from the Home page
    When I click on the video tutorials link
    Then I will go to the Video Tutorials page
<<<<<<< HEAD
=======
  @wnf
>>>>>>> dev
  Scenario:  Navigating to the Contact Us page from the Home page
    When I click on the contact us link
    Then I will go to the contact us page
>>>>>>> dev

  @webNav
  Scenario: Navigating to the Contact Us page from the Home page
    When I click on the contact us link
    Then I will go to the contact us page