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

  @excel
  Scenario: Adding multiple employee using excel file

    When user adds multiple employee from excel using "EmployeeData" and verify it

  @database
  Scenario: adding the employee from front end and verifying it from back end
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    #And user clicks on add employee button
    And user enters "nesha" and "sania" and  "standart"
    And user captures the employee id
    And user clicks on save button
    And query the information in backend
    Then verify the results from frontend and backend




