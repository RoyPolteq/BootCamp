package chapterSix;

import lib.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    BrowserActions BrowserActionsOne;
    WebDriverWait wait;

    @BeforeMethod
    public void createBrowser () {

        BrowserActionsOne = new BrowserActions();
        driver = new ChromeDriver();
        BrowserActionsOne.openWebsiteChrome(driver, "https://greatshop.polteq-testing.com" );
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void logOutSuccessful() {

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertTrue(driver.findElements(By.className("logout")).size()>0,"The logout button doesn't exist");

        driver.findElement(By.className("logout")).click();

        WebElement logOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("login")));
        Assert.assertTrue(logOutButton.isDisplayed(), "Login button is not there");
    }

    @AfterMethod
    public void cleanUp () {

        BrowserActionsOne.cleanupBrowser();
    }

}
