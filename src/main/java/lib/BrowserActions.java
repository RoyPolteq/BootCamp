package lib;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BrowserActions {

    public static void openWebsiteChrome (WebDriver driver, String url) {

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    public static void cleanupBrowser(WebDriver driver) {

        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
