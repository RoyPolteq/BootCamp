package tests;

import lib.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.polteqGreatWorkshop.ContactPage;
import pages.polteqGreatWorkshop.Header;

import java.time.Duration;

import static lib.Browser.CHROME;

public class TestShopScenario {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Header headerOne;
    protected ContactPage contactPageOne;

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createDriver(CHROME);
        driver.get("https://greatshop.polteq-testing.com");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        headerOne = new Header(driver);
        contactPageOne = new ContactPage(driver);
    }

    @AfterMethod
    public void tearDown () {

        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
