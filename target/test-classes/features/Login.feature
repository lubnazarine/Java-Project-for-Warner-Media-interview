Feature: Login tests

  Background: Opening the browser and navigate to login screen
    Given user opens browser and enters url and lands on homepage
    When user clicks on sign in
    Then verify user land on login screen

  Scenario: launch home page, sign in and signout successfully
    When user enters username and password
    Then user is able to login successfully
    When user clicks on sign out
    Then user is able to sign out successfully

@NegativeTests
  Scenario Outline: launch home page and sign in negative flows
    When user enters "<username>" and "<password>"
    Then verify error "<message>"
    Examples:
      | username       | password | message                    |
      | abc12@test.com | 12345    | Authentication failed.     |
      | abc12@test.com |          | Password is required.      |
      |                |          | An email address required. |





