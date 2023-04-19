Feature: Searching the employee
  Background:
    When user enters valid email and password
    And click on login button
    When  user clicks on PIM option
    #Backround keyword used to define all the common steps that multiple
  # scenarios have in same feature file , till the time flow is not broken

  @searchEmp
  Scenario: Search an employee by id
   # Given open the browser and launch HRMS application
   # When user enters valid email and password
   # And click on login button
   # When  user clicks on PIM option
    When user enters valid an employee id
    And clicks on search button
    Then user see employee information is displayed
    #Then close the browser // because you use your hooks no need to mention close or open browsers

  @searchEmpTitle
  Scenario: Search employee by job title

  #  When user enters valid email and password
  #  When  user clicks on PIM option
    When user selects job title
    And clicks on search button
    Then user see employee information is displayed

