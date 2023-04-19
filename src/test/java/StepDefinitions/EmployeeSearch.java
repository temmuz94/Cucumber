package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeSearch extends CommonMethods {
    @When("user enters valid an employee id")
    public void user_enters_valid_an_employee_id() {
       WebElement idTextBox = driver.findElement(By.xpath("//*[@id=\"empsearch_id\"]"));
       sendText(idTextBox, ConfigReader.getPropValue("empid"));

    }

    @When("clicks on search button")
    public void clicks_on_search_button() {
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"searchBtn\"]"));
        clickOn(searchButton);

    }

    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("The employee is Displayed");

    }
    @When("user selects job title")
    public void user_selects_job_title() {
       WebElement searchByJob = driver.findElement(By.xpath("//*[@id=\"empsearch_job_title\"]"));
       selectByOptions(searchByJob, "Singer");
       WebElement empStatusDropDown = driver.findElement(By.xpath("//*[@id=\"empsearch_employee_status\"]"));
       selectByOptions(empStatusDropDown, "Active");
    }
}
