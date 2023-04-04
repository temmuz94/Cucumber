Feature: Login Functionalities
  Scenario: Valid Admin Login
    Given open the browser and launch HRMS application
    When user enters valid email and password
    And click on login button
    Then user is logged in successfully
    Then close the browser