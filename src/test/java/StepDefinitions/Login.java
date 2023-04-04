package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Login extends CommonMethods {

    @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {
        openBrowserAndLaunchApp();


    }
    @When("user enters valid email and password")
    public void user_enters_valid_email_and_password() {
        driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys(ConfigReader.getPropValue("username"));
        driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys(ConfigReader.getPropValue("password"));
  }
    @When("click on login button")
    public void click_on_login_button() {
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
    }
    @Then("user is logged in successfully")
    public void user_is_logged_in_successfully() {
       boolean userLog = driver.findElement(By.xpath("//*[@id=\"welcome\"]")).isDisplayed();
       if(userLog){
           System.out.println("user is successfully logged in");

       }
    }
    @Then("close the browser")
    public void close_the_browser() {
       closeBrowwser();
    }


}
