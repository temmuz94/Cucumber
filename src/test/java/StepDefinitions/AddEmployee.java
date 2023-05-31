package StepDefinitions;

import Pages.AddEmployeePage;
import Utils.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class AddEmployee extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {

        // driver.findElement(By.id("menu_pim_viewPimModule")).click();
        //WebElement pimTab = driver.findElement(By.id("menu_pim_viewPimModule"));
        clickOn(AddEmployeePage.addEmpPage.pimTab);

    }

    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {

        //WebElement eddEmpBtn = driver.findElement(By.id("menu_pim_addEmployee"));
        clickOn(AddEmployeePage.addEmpPage.eddEmpBtn);
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {

        //driver.findElement(By.id("firstName")).sendKeys(ConfigReader.getPropertyValue("firstname"));
        //WebElement firstNameTextBox = driver.findElement(By.id("firstName"));
        sendText(AddEmployeePage.addEmpPage.firstNameTextBox, ConfigReader.getPropValue("firstname"));

        //driver.findElement(By.id("middleName")).sendKeys(ConfigReader.getPropertyValue("middlename"));

        //WebElement middleNameTextBox = driver.findElement(By.id("middleName"));
        sendText(AddEmployeePage.addEmpPage.middleNameTextBox, ConfigReader.getPropValue("middlename"));

        //driver.findElement(By.id("lastName")).sendKeys(ConfigReader.getPropertyValue("lastname"));
        //WebElement lastNameTextBox = driver.findElement(By.id("lastName"));
        sendText(AddEmployeePage.addEmpPage.lastNameTextBox,ConfigReader.getPropValue("lastname"));

    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        //WebElement saveBtn = driver.findElement(By.id("btnSave"));
        Assert.assertTrue(AddEmployeePage.addEmpPage.saveBtn.isDisplayed());
        System.out.println("My assertion is returning true");
        clickOn(AddEmployeePage.addEmpPage.saveBtn);
    }

    @When("user enters {string} and {string} and  {string}")
    public void user_enters_and_and(String fname, String mname, String lname) {
        sendText(AddEmployeePage.addEmpPage.firstNameTextBox, fname);
        sendText(AddEmployeePage.addEmpPage.middleNameTextBox, mname);
        sendText(AddEmployeePage.addEmpPage.lastNameTextBox, lname);
    }

    @When("user captures the employee id")
    public void user_captures_the_employee_id() {
        GlobalVariables.emp_id = AddEmployeePage.empIdLocator.getAttribute("value");
        System.out.println("The employee id is: " + GlobalVariables.emp_id);
    }

    @When("query the information in backend")
    public void query_the_information_in_backend() {
        String query = "select * from hs_hr_employees where employee_id='"
                + GlobalVariables.emp_id+"'";
        //to store the table coming from db, we used global variable here
        //in this variable we got all the keys and values for the employee we searched
        GlobalVariables.tabledata = DBUtility.getListOfMapsFromRset(query);
    }

    @Then("verify the results from frontend and backend")
    public void verify_the_results_from_frontend_and_backend() {
        //now, from all these values we need to compare one by one value
        String firstNameFromDB = GlobalVariables.tabledata.get(0).get("emp_firstname");
        System.out.println(firstNameFromDB);
        String lastNamefromDB = GlobalVariables.tabledata.get(0).get("emp_lastname");
        System.out.println(lastNamefromDB);

        //adding assertions
        Assert.assertEquals(firstNameFromDB, "nesha");
        Assert.assertEquals(lastNamefromDB, "standart");
        System.out.println("My assertion has passed my test case");
    }



    @When("user adds multiple employee from excel using {string} and verify it")
public void user_adds_multiple_employee_from_excel_using_and_verify_it(String sheetName) {
    List<Map<String, String>> empDataExcel = ExcelReader.excelListIntoMap(Constants.TESTDATA_FILEPATH, sheetName);


    for (Map<String, String> employee : empDataExcel) {

        String fname = employee.get("firstName");
        String mName = employee.get("middleName");
        String lastName = employee.get("lastName");

        System.out.println(fname);
        System.out.println(mName);
        System.out.println(lastName);
    }
}}
