package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {
    public LoginPage()
    {
        PageFactory.initElements(driver, this);// Initializing the webElements of the current page
        x=1;
    }
    int x;
    @FindBy(xpath = "//*[@id=\"txtUsername\"]")
    public WebElement userNameTextBox;
    @FindBy(xpath = "//*[@id=\"txtPassword\"]")
    public WebElement passwordTextBox;
    @FindBy(xpath = "//*[@id=\"btnLogin\"]")
    public WebElement loginButtonX;
    @FindBy(id = "welcome")
   public WebElement welcomeIcon;
@FindBy(xpath = "//a[text()='Logout']")
    public WebElement logoutLink;



    // Page Factory Model

}
