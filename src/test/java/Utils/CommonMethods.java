package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CommonMethods {
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


    }
    public static void closeBrowwser(){
        driver.close();
    }
}
