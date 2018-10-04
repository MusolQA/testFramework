import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.jar.Pack200.Packer;

import com.beust.jcommander.converters.PathConverter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class HomePage extends base {

    // testing data




    @BeforeMethod

    public void intalizeBroswer() throws IOException
    {
            driver = intalizeDriver();

    }

    @Test

    public void basePageNavigation() throws IOException, InterruptedException {


        driver.get(homeUrl);
        Thread.sleep(5000);
        LandingPage lp = new LandingPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(lp.standradLogonButton));
        lp.getStandardLogonButton().click();
    }


    @Test

    public void shouldLoginAdmin() throws IOException, InterruptedException {

        basePageNavigation();
        LoginPage lp = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(lp.getActiveDirectory));
        lp.getEmail().sendKeys(testEmail);
        lp.getPassword().sendKeys(testPassword);
        lp.getConfirm().click();

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


