package tests.chapterNine;

import lib.BrowserActions;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PolteqTestingGreatshop.ContactPage;
import pages.PolteqTestingGreatshop.Header;

import java.time.Duration;

public class ContactFormTest {

    WebDriver driver;
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
    public void successfulSubmit() {

        Header headerOne = new Header(driver);
        ContactPage contactPageOne = new ContactPage(driver);

        headerOne.clickOnContactUs();
        contactPageOne.selectSubject("Customer Service");
        contactPageOne.fillInEmail("bootcamper@feelthepain.com");
        contactPageOne.fillInReference("4321234");
        contactPageOne.fillInMessage("Ipod defect while lifting, need new one");
        contactPageOne.clickOnSubmit();

        Assertions.assertThat(contactPageOne.returnNumberOfSuccessMessages()).as("The amount of success messages is not 1").isEqualTo(1);
        Assertions.assertThat(contactPageOne.returnNumberOfSuccessMessagesBoolean()).as("it is not 1").isTrue();
        Assertions.assertThat(contactPageOne.returnNumberOfSuccessMessagesNoList()).as("success message not there").isTrue();
    }

    @AfterMethod
    public void cleanUp () {

        BrowserActionsOne.cleanupBrowser();
    }
}
