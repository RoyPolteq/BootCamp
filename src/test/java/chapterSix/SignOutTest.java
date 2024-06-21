package chapterSix;

import lib.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SignOutTest {

    WebDriver driver;
    String username = "roy91191@hotmail.com";
    String password = "Test01";

    @BeforeMethod
    public void createBrowser () {

        driver = new ChromeDriver();
        BrowserActions.openWebsiteChrome(driver, "https://greatshop.polteq-testing.com" );
    }

    @Test
    public void logOutSuccessful() {

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertTrue(driver.findElements(By.className("logout")).size()>0,"The logout button doesn't exist");

        driver.findElement(By.className("logout")).click();
        Assert.assertTrue(driver.findElements(By.className("login")).size()>0,"The login button doesn't exist");
    }

    @AfterMethod
    public void cleanUp () {

        BrowserActions.cleanupBrowser(driver);
    }

}
