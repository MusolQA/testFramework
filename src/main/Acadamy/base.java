import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public WebDriver driver;
    public WebDriverWait wait;

    String homeUrl = "http://krkrnd02.andea.com:83/eworkin/#/loginad";

    String testEmail = "admin";
    String testPassword = "1";
    String testUrl = "emptynow2";



    public WebDriver intalizeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\pruszlewicz\\IdeaProjects\\eworkin\\src\\main\\Acadamy\\data.properties");
        prop.load(fis);
        String broswerName = prop.getProperty("broswer");

        if (broswerName.equals("chrome")) {
            System.out.println("chrome");
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        } else if (broswerName.equals("firefox")) {
            System.out.println("firefox");

        } else if (broswerName.equals("IE")) {
            System.out.println("IE");
        }


    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    return driver;


    }




}
