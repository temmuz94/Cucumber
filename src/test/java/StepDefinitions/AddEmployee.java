package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
     // WebElement PimTab= driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"));
      clickOn(addEmpPage.PimTab);

    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
      // WebElement clickOnAdd=  driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]"));
      clickOn(addEmpPage.clickOnAdd);
    }
    @When("user enters firstname, middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {

       // WebElement firstName= driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        sendText(addEmpPage.firstName, ConfigReader.getPropValue("firstname"));
       // WebElement middleName = driver.findElement(By.xpath("//*[@id=\"middleName\"]"));
        sendText(addEmpPage.middleName, ConfigReader.getPropValue("middlename"));
       // WebElement lastName= driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        sendText(addEmpPage.lastName, ConfigReader.getPropValue("lastname"));

    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
     // WebElement clickOnSave= driver.findElement(By.xpath("//*[@id=\"btnSave\"]"));
      clickOn(addEmpPage.clickOnSave);
    }


}
