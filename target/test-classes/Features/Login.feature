Feature: Login Functionalities

  @smoke
  Scenario: Valid Admin Login
  # Given open the browser and launch HRMS application
  When user enters valid email and password
  And click on login button
  Then user is logged in successfully
  # Then close the browser

  #Please check the example of Regular Expression below
  @smoke2
  Scenario: Valid Admin Login
  # Given open the browser and launch HRMS application
  When user enters valid "ADMIN" and "Hum@nhrm123"
  And click on login button
  Then user is logged in successfully
  # Then close the browser

  #HOOKS: For defining pre and post steps in any cucumber framework
  # Always create in StepDefinition Folder
  # Cant be inherited
  #BACKROUND KEYWORD : When features file has common steps we can use in different scenarios of a feature file till
  # flow is not broken

  # 1.Hard Code
  # 2.Config File
  #----------------------------------------------------------------------------------------

  #Cucumber itself provides multiple option through which we can feed data from feature file into step definitions
  # 3. Regular Expression [limited set of data]
  # put the data in double quotes [" "]
  #===================================PARAMETERIZATION================================
  # Executing the same test case with multiple data
  # If you want to use parameterization
  # if you wish to implement data driven testing DDT
  # Scenario outline is always used along with the keyword Examples

  #4. Scenario Outline [parameterization / DDT][browser opens numbers times of test cases]
  # Provides you an alternative to Data driven testing
  # Also supports parametrization
  #5.dataTable
  # Page Object Model : An object Repository [ It stores or holds all the webElements specific to a particular page
  @scenarioOutline
  #Parameterization/ Data Driven
  Scenario Outline:
  #Given open the browser and launch HRMS application
  When user enters valid "<username>" and "<password>"
  And click on login button
  Then user is logged in successfully
 # Then close the browser
  Examples:
 | username | password    |
 | admin    | Hum@nhrm123 |
 | ADMIN    | Hum@nhrm123 |
 | Jason    | Hum@nhrm123 |
 | asa      | asa         |
 |          |             |
  @dataTable
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |

