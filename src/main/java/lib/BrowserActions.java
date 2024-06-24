package lib;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class BrowserActions {

    WebDriver driver;

    public void openWebsiteChrome (WebDriver driver, String url) {

        this.driver = driver;
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    public WebDriver returnDriver () {

        return driver;
    }

    public void cleanupBrowser() {

        driver.manage().deleteAllCookies();
        driver.quit();
    }

    public void acceptAlert () {

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clearWishList(){

        List<WebElement> removeButtons = driver.findElements(By.className("icon-remove"));

        for (WebElement removeButton : removeButtons ) {

            removeButton.click();
            acceptAlert();
        }


    }
}
