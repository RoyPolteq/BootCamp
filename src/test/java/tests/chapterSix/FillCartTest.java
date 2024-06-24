package tests.chapterSix;

import lib.BrowserActions;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
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
import tests.TestShopScenario;

import java.time.Duration;

public class FillCartTest extends TestShopScenario {

    WebDriver driver;
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
    public void addIpodShuffle() {

        Assert.assertTrue(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed(), "the cart is not empty");
        driver.findElement(By.cssSelector("[title='More about ipod']")).click();
        driver.findElement( By.xpath("//*[text()=' iPod shuffle ']")).click();
        //driver.findElement(By.cssSelector("[title='iPod shuffle']")).click();
        driver.findElement(By.id("add_to_cart")).click();
        driver.findElement(By.cssSelector("[title='Continue shopping']")).click();
        String test = driver.findElement(By.className("ajax_cart_quantity")).getAttribute("innerText");
        Assert.assertEquals(test, "1", "the quantity in the cart is not correct");

        //assertj version of the same assert
        Assertions.assertThat(test).as("dit is de error tekst").isEqualTo("1");

        //soft assertion version of this, this basically creates a list of assertions and then checks them with the assertall
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(test).as("quantity should be 1").isEqualTo("1");
        softly.assertAll();
    }

    @AfterMethod
    public void cleanUp () {

        BrowserActionsOne.cleanupBrowser();
    }
}
