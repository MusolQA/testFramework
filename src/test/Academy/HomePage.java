import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends base {

    @Test

    public void basePageNavigation() throws IOException {
        driver = intalizeDriver();
        driver.get(homeUrl);
        LandingPage lp = new LandingPage(driver);
        lp.getLogin().click();
    }
}
