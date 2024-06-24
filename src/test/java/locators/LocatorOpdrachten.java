package locators;

import lib.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LocatorOpdrachten {

    WebDriver driver;
    String username = "roy91191@hotmail.com";
    String password = "Test01";
    BrowserActions BrowserActionsOne;
    WebDriverWait wait;

    @BeforeMethod
    public void createBrowser () {

        BrowserActionsOne = new BrowserActions();
        driver = new ChromeDriver();
        BrowserActionsOne.openWebsiteChrome(driver, "https://greatshop.polteq-testing.com" );
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void clickOnAccessories () {

        driver.findElement(By.xpath("//li/a[@title='Accessories']")).click();
    }

    @Test
    public void clickOnIpod() {

        driver.findElement(By.xpath("//div[@id='categories_block_left']/div/ul/li/a[contains(text(), 'iPods')]")).click();
        //dit zou ook werken
        driver.findElement(By.xpath("//div[@id='categories_block_left']//a[contains(text(), 'iPods')]"));
    }
}
