package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PolteqTestingGreatshop.ContactPage;
import pages.PolteqTestingGreatshop.Header;

import java.time.Duration;

public class TestShopScenario {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Header headerOne;
    protected ContactPage contactPageOne;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
