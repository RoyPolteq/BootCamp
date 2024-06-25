package parametersExperiment;

import lib.Browser;
import lib.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.polteqGreatWorkshop.ContactPage;
import pages.polteqGreatWorkshop.Header;

import java.time.Duration;

import static lib.Browser.CHROME;

public class TestShopScenarioBrowserDriven {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Header headerOne;
    protected ContactPage contactPageOne;

    @Parameters("browser")
    @BeforeMethod
    public void setup(Browser browser){

        driver = DriverFactory.createDriver(browser);
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
