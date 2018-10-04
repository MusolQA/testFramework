import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    By email= By.cssSelector("input[name='uLogin'");
    By password= By.cssSelector("input[name='uPassword'");
    By getActiveDirectory = By.cssSelector("input[name='uDomain'");
    By confirm = By.cssSelector("button.login-form-button.button-primary-eworkin.ng-binding");

    public String urlLogin = "http://krkrnd02.andea.com:83/eworkin/#/";

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getEmail()
{
    return driver.findElement(email);
}

    public WebElement getPassword()
    {
        return driver.findElement(password);
    }

    public WebElement getActiveDirectory()
    {

        return driver.findElement(getActiveDirectory);
    }

    public WebElement getConfirm()
    {
        return  driver.findElement(confirm);
    }
}
