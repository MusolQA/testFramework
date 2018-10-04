import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    By standradLogonButton= By.cssSelector("a[href='#/logindb']");

    public LandingPage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getStandardLogonButton()
    {
        return driver.findElement(standradLogonButton);
    }

}
