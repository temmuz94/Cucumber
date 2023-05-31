package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashBoardPage extends CommonMethods {
    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement PIMOption;

    public dashBoardPage() {

        PageFactory.initElements(driver, this);
    }

}
