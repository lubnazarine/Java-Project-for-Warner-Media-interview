@Add
Feature: Add Item test

  Background: Opening the browser and navigate to login screen
    Given user opens browser and enters url and lands on homepage
    When user clicks on sign in
    Then verify user land on login screen

  Scenario: Add a product
    When user enters username and password
    Then user is able to login successfully
    When user clicks on Women tab
    Then user is navigated to the Women's page
    When the user adds an item and checks out
