package Utils;

import StepDefinitions.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;
    public static void openBrowserAndLaunchApp(){
        ConfigReader.readProperties();

        String browserType = ConfigReader.getPropValue("browserType");
        switch (browserType) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Safari":
                driver = new SafariDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new InternetExplorerDriver();
                break;

        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Constants.WAIT_TIME));
        initializePageObjects(); // This steps will initialize all the pages we have in our PageInitializer class
        // along with the launching of application
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("This is the beginning of my Test Case");
        Log.info("My Test Case is executing right now");
        Log.warning("My Test Case might have some trivial issues");

    }
    public static void closeBrowser(){
        Log.info("This Test Case is about to get completed");
        Log.endTestCase("This Test Case is finished");
        driver.close();
    }

    public static void clickOn(WebElement element){
        element.click();

    }
    public static void sendText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
    public static Select clickOnDropDown(WebElement element){
        Select sel= new Select(element);
        return sel;
    }
    public static void selectByValue(WebElement element, String value){
        clickOnDropDown(element).selectByValue(value);

    }

    public static void selectByVisibleText(WebElement element, String text){
        clickOnDropDown(element).selectByVisibleText(text);
    }
    public static void selectByIndex(WebElement element, int index){
        clickOnDropDown(element).selectByIndex(index);
    }
    public static void selectByOptions(WebElement element, String text){
        List<WebElement> options= clickOnDropDown(element).getOptions();
        for (WebElement option : options) {
            String dropDownOptionText= option.getText();
            if(dropDownOptionText.equals(text)){
                option.click();
            }

        }
    }
//Screenshots
    public static byte[] takeScreenshot(String imageName){

        //This casting WebDriver instance driver to TakeScreenshot Interface

        TakesScreenshot ts =(TakesScreenshot) driver;

        //Captures the ss and stores it as byte array
        byte[] picBytests = ts.getScreenshotAs(OutputType.BYTES);

        //Stores screenshot as a File in the sourceFile variable
       File sourcePath= ts.getScreenshotAs(OutputType.FILE);

       //FileUtils.copyFile(sourcePath, new File(Constants.SCREENSHOT_FILEPATH+imageName+getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));

        try {
            FileUtils.copyFile(sourcePath, new File(Constants.SCREENSHOT_FILEPATH+imageName+gettimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        return picBytests;

    }
    public static String gettimeStamp(String pattern){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);

    }

}
