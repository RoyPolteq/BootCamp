package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;



public class BrowserActions {

    WebDriver driver;

    public void openWebsiteChrome (WebDriver driver, String url) {

        this.driver = driver;
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    public void cleanupBrowser() {

        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
