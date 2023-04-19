package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {
    @FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/b")
   public WebElement PimTab;

    @FindBy(xpath = "//*[@id=\"menu_pim_addEmployee\"]")
  public WebElement clickOnAdd;


   @FindBy(xpath = "//*[@id=\"firstName\"]")
  public WebElement firstName;

   @FindBy(xpath = "//*[@id=\"middleName\"]")
  public WebElement middleName;

   @FindBy(xpath = "//*[@id=\"lastName\"]")
  public WebElement lastName;

   @FindBy(xpath = "//*[@id=\"btnSave\"]")
  public WebElement clickOnSave;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }
}
