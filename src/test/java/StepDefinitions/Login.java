package StepDefinitions;

import Pages.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
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
import java.util.List;
import java.util.Map;

public class Login extends CommonMethods {

    @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {
        openBrowserAndLaunchApp();


    }
    @When("user enters valid email and password")
    public void user_enters_valid_email_and_password() {
      //  LoginPage login = new LoginPage();


    //  WebElement userNameTextBox=  driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
      sendText(login.userNameTextBox, ConfigReader.getPropValue("username"));
     // WebElement passwordTextBox=  driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
      sendText(login.passwordTextBox, ConfigReader.getPropValue("password"));
  }
    @When("click on login button")
    public void click_on_login_button() {
       // driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
       // LoginPage login = new LoginPage();
        clickOn(login.loginButtonX);
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
       closeBrowser();
    }
    @When("user enters valid {string} and {string}")
    public void user_enters_valid_and(String username, String password) {
       // LoginPage login = new LoginPage();

       // WebElement userNameTextBox=  driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        sendText(login.userNameTextBox, username);

        //WebElement passwordTextBox=  driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        sendText(login.passwordTextBox, password);

    }
    @When("user enters username and password and verifies login")
    public void user_enters_username_and_password_and_verifies_login(DataTable dataTable) {
      //  LoginPage login = new LoginPage();

        List<Map<String, String>> userCredentials= dataTable.asMaps();
        for (Map<String, String> userCred : userCredentials) {
          String userName=  userCred.get("username");
           String password=  userCred.get("password");
         //   WebElement userNameTextBox=  driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
            sendText(login.userNameTextBox, userName);

         //   WebElement passwordTextBox=  driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
            sendText(login.passwordTextBox, password);

          //  WebElement loginButtonX = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
            clickOn(login.loginButtonX);

          //  WebElement welcomeIcon= driver.findElement(By.id("welcome"));
            clickOn(login.welcomeIcon);

         //   WebElement logoutLink=driver.findElement(By.xpath("//a[text()='Logout']"));
            clickOn(login.logoutLink);


        }
    }


}
