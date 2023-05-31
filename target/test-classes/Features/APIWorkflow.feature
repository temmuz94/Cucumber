Feature: API workflow for HRMS
  Background:
    Given a JWT is generated

  @api
  Scenario: create an employee using API call
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    Then the employee contains key "Message" and  value "Employee Created"
    Then the employee id "Employee.employee_id" is stored as a global variable to be used for other calls

  @apijsonworkflow
  Scenario: create an employee using API call
    Given a request is prepared to create an employee using json payload
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    Then the employee contains key "Message" and  value "Employee Created"
    Then the employee id "Employee.employee_id" is stored as a global variable to be used for other calls

  @apijsonworkflow
  Scenario: retrieve an employee using API call
    Given a request is prepared to get the created employee
    When a GET call is made to get the employee
    Then the status code for this employee is 200
    Then the employee data we get having id "employee.employee_id" must match with globally stored employee id
    Then the retrieved data at "employee" object matches with the data of created employee
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |nelena       |faria       |ms             |Female    |2012-05-20  |confirmed |Engineer     |

  @dynamic
  Scenario: create an employee using API call
    Given a request is prepared to create an employee with dynamic data "nelena" , "faria" , "ms" , "F" , "2012-05-20" , "Confirmed" , "Engineer"
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    Then the employee contains key "Message" and  value "Employee Created"
    Then the employee id "Employee.employee_id" is stored as a global variable to be used for other calls

  @updateemployee
  Scenario: updating the employee via API call
    Given a request is prepared to update an employee
    When a PUT call is made to update an employee
    Then the status code of updated employee is 200
