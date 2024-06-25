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
import org.testng.Assert;
import pages.polteqGreatWorkshop.Header;
import pages.polteqGreatWorkshop.LogInPage;

import java.util.List;

public class StepDefinitions {

    WebDriver driver;
    BrowserActions BrowserActionsOne;
    Header headerOne;
    LogInPage logInPageOne;
    private String username = "roy91191@hotmail.com";
    private String password = "Test01";

    @Before
    public void createBrowser () {

        BrowserActionsOne = new BrowserActions();
        driver = DriverFactory.createDriver(Browser.CHROME);
        headerOne = new Header(driver);
        logInPageOne = new LogInPage(driver);
    }

    @Given("I am on the Polteq great testshop")
    public void iAmOnThePolteqGreatTestshop() {

        BrowserActionsOne.openWebsiteChrome(driver, "https://greatshop.polteq-testing.com" );
    }

    @When("I log in as a valid user")
    public void iLogInAsAValidUser() {

        headerOne.clickOnSignIn();
        logInPageOne.fillInEmail(username);
        logInPageOne.fillInPassword(password);
        logInPageOne.clickOnSubmit();
    }

    @When("I log in as {string} with password {string}")
    public void iLogInAsAVariableUser(String email, String pswd) {

        headerOne.clickOnSignIn();
        logInPageOne.fillInEmail(email);
        logInPageOne.fillInPassword(pswd);
        logInPageOne.clickOnSubmit();
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
