import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoginCase extends base {




    @BeforeMethod

    public void intalizeBroswer() throws IOException
    {
            driver = intalizeDriver();
    }

    @Test

    public void shouldSignIn() throws IOException {

        System.out.println("Should execute test ");
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


