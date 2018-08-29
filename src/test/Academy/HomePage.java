import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.jar.Pack200.Packer;

import com.beust.jcommander.converters.PathConverter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class HomePage extends base {


    @BeforeMethod

    public void intalizeBroswer() throws IOException
    {
            driver = intalizeDriver();
    }

    @Test

    public void basePageNavigation() throws IOException {


        driver.get(homeUrl);
        LandingPage lp = new LandingPage(driver);
        lp.getLogin().click();

    }

    @Test

    public void shouldSignIn() throws IOException {

        LoginPage loginp = new LoginPage(driver);
        driver.get(loginp.urlLogin);
        loginp.getEmail().sendKeys("dasdasa");
        loginp.getPassword().sendKeys("ewqeqwe");
        loginp.getConfirm().click();
    }

    @AfterMethod(alwaysRun=true)
    public void catchExceptions(ITestResult result){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = result.getName();
        if(!result.isSuccess()){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File((String) ("failure_screenshots/"+methodName+"_"+formater.format(calendar.getTime())+".png")));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @AfterMethod(alwaysRun = true)

    public void closeBroswer()
    {
        driver.close();
    }


}


