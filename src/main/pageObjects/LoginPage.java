import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    By email= By.cssSelector("[type='email'");
    By password= By.cssSelector("[type='password'");
    By confirm = By.cssSelector("input.btn.btn-primary.btn-md.login-button");
    public String urlLogin = "https://sso.teachable.com/secure/9521/users/sign_in?clean_login=true&reset_purchase_session=1";

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

    public WebElement getConfirm()
    {
        return  driver.findElement(confirm);
    }
}
