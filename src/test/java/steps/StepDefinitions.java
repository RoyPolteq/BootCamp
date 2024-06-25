package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lib.Browser;
import lib.BrowserActions;
import lib.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class StepDefinitions {

    WebDriver driver;
    BrowserActions BrowserActionsOne;
    private String username = "roy91191@hotmail.com";
    private String password = "Test01";

    @Before
    public void createBrowser () {

        BrowserActionsOne = new BrowserActions();
        driver = DriverFactory.createDriver(Browser.CHROME);
    }

    @Given("I am on the Polteq great testshop")
    public void iAmOnThePolteqGreatTestshop() {

        BrowserActionsOne.openWebsiteChrome(driver, "https://greatshop.polteq-testing.com" );
    }

    @When("I log in as a valid user")
    public void iLogInAsAValidUser() {

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {

        List<WebElement> signOutButtons;
        signOutButtons = driver.findElements(By.className("logout"));
        Assert.assertTrue(signOutButtons.size()>0,"The logout button doesn't exist");
    }

    @After
    public void cleanUp () {

        BrowserActionsOne.cleanupBrowser();
    }
}
