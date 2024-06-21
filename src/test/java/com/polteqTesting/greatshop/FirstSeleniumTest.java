package com.polteqTesting.greatshop;

import lib.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class FirstSeleniumTest {

    WebDriver driver;
    BrowserActions BrowserActionsOne;
    String username = "roy91191@hotmail.com";
    String password = "Test01";

    @BeforeMethod
    public void createBrowser () {

        BrowserActionsOne = new BrowserActions();
        driver = new ChromeDriver();
        BrowserActionsOne.openWebsiteChrome(driver, "https://greatshop.polteq-testing.com" );
    }

    @Test
    public void logInSuccessful() {

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();

        WebElement logoutButton = driver.findElement(By.className("logout"));
        String buttonText = logoutButton.getAttribute("outerText");
        Assert.assertEquals(buttonText,"Sign out","The logout button doesn't have the correct text");

        List<WebElement> signOutButtons;
        signOutButtons = driver.findElements(By.className("logout"));
        Assert.assertTrue(signOutButtons.size()>0,"The logout button doesn't exist");

        //shorter way to write this (makes a temporary list)
        Assert.assertTrue(driver.findElements(By.className("logout")).size()>0,"The logout button doesn't exist");
    }

    @AfterMethod
    public void cleanUp () {

        BrowserActionsOne.cleanupBrowser();
    }
}
