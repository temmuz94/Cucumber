package StepDefinitions;

import Pages.AddEmployeePage;
import Pages.LoginPage;

public class PageInitializer {
    public static LoginPage login;
    public static AddEmployeePage addEmpPage;
    public static void initializePageObjects(){
       login = new LoginPage();
       addEmpPage = new AddEmployeePage();
    }

}
// This class will manage the object creating of different page Objects in our Framework
// Instead of calling the age objects again and again, this class will take good care of that step
