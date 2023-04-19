Feature: Add Employee

  @testcase2
  Scenario: Adding a new Employee
    # because you using Hooks u do not need to use open and close browsers
    When user enters valid email and password
    And click on login button
    When  user clicks on PIM option
    When user clicks on add employee button
   # When user enters firstname, middlename and lastname
   # When user clicks on save button

