# Automated-Web-API-Testing

## Goal

The goal of this project is to test the functionality of the website https://automationexercise.com/ and derive user stories from it. The objective is to create high-quality user stories and test cases and implement a fully functional API test framework using Service Object Model/Rest Assured, as well as a fully functional test framework using POM pattern for web testing. Additionally, the project aims to create Gherkin scenarios that represent user journeys and expose tests via BDD using cucumber for better communication and understanding among team members, including non-technical ones. The project will be completed in two sprints - API and Web implementation. The project board will be updated regularly with the sprint backlog and progress tracked using Trello, GitHub, JIRA, or any other preferred tool.

## **Requirements:**

- Java Development Kit (JDK) 11 or later
- IntelliJ IDEA or another Java IDE
- Git or another version control system

## Installation

 1. Clone the repository from GitHub:
   `git clone https://github.com/Ezzerof/Automated-Web-API-Testing.git`
 2. Import the project into your Java IDE.

 3. Install the necessary dependencies using a build tool such as Maven or Gradle.
 
 4. Fill the .csv and .json files from test/resources

 5. Run the api package to start the API testing application, or web/TestRunner.java to run Web testing application.

## Project Roles:


| Role         | Contributor        | Contact                         |
|--------------|--------------------|---------------------------------|
| Scrum Master | Anusha Gampa       | agampa@spartaglobal.com         |
| GitHub Lead  | Cristian Bitca     | cbitca@spartaglobal.com         |
| Dev/Tester   | Katie Olivia Hulme |  katiehulme@spartaglobal.com    |
| Dev/Tester   | Chloe Vera Turner  | cturner@spartaglobal.com        |
| Dev/Tester   | Sahan Seneviratne  | sseneviratne@spartaglobal.com   |
| Dev/Tester   | Marcella chessa    | mchessa@spartaglobal.com        |
| Dev/Tester   | Abubakar Muhammad  | amuhammad@spartaglobal.com      |
| Dev/Tester   | James Reed         | jreed@spartaglobal.com          |
| Dev/Tester   | Rafael Lopes       | rlopes@spartaglobal.com         |
| Dev/Tester   | Ajay Balakrishnan  | abalakrishnan@spartaglobal.com  |


## **Details of the Functionality in Major Sections:**

## **Routes.java:**

It provides several end points of the API and returns URL.

## **Usage of the project**

This project contains several packages to test API and their responses through several http requests like GET, POST, PUT, DELETE, UPDATE. This project contains **api** package with number of testcases to test different aspects of API like test cases for Products, brands, user and login. The **web** package contains tests of the Web part with tests for navigation, links, forms, and user interactions.

## **Summary:**

 This project has been developed in REST ASSURED framework so that everyone can test the API easily. Our project is developed in such a way that it is reusable, readable, maintainable easily by other testers of an API. In web testing, the testing team focused on evaluating the functionality, usability, security, and performance of the website. The team conducted functional testing to ensure that the website's navigation, links, forms, and user interactions were working correctly. Usability testing was conducted to assess the website's user-friendliness and user experience.
