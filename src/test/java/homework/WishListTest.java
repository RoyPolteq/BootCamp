package homework;

import lib.BrowserActions;
import org.assertj.core.api.Assertions;
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
import org.openqa.selenium.Alert;

import java.time.Duration;
import java.util.List;

public class WishListTest {

    WebDriver driver;
    String username = "roy91191@hotmail.com";
    String password = "Test01";
    BrowserActions BrowserActionsOne;
    WebDriverWait wait;
    String columnName;
    WebElement rowWeNeed;

    @BeforeMethod
    public void createBrowser () {

        BrowserActionsOne = new BrowserActions();
        driver = new ChromeDriver();
        BrowserActionsOne.openWebsiteChrome(driver, "https://greatshop.polteq-testing.com" );
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void removeWishlistItem() {

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertTrue(driver.findElements(By.className("logout")).size()>0,"The logout button doesn't exist");

        driver.findElement(By.className("lnk_wishlist")).click();

        driver.findElement(By.id("name")).sendKeys("Test 1");
        driver.findElement(By.id("submitWishlist")).click();

        driver.findElement(By.id("name")).sendKeys("Test 2");
        driver.findElement(By.id("submitWishlist")).click();

        driver.findElement(By.id("name")).sendKeys("Test 3");
        driver.findElement(By.id("submitWishlist")).click();

        driver.findElement(By.id("name")).sendKeys("Feel the pain");
        driver.findElement(By.id("submitWishlist")).click();

        driver.findElement(By.id("name")).sendKeys("ATest 4");
        driver.findElement(By.id("submitWishlist")).click();

        WebElement table = driver.findElement(By.id("block-history"));
        List<WebElement> tableRows;
        tableRows = table.findElements(By.tagName("tr"));

        for (WebElement row : tableRows) {

           List<WebElement> rowColumns;
           rowColumns = row.findElements(By.tagName("td"));

           for (WebElement cell : rowColumns) {

               columnName = cell.getAttribute("innerText");

              if (columnName.equals("Feel the pain")) {

                  rowWeNeed =row;
                  break;
              }
           }
        }

        rowWeNeed.findElement(By.className("icon-remove")).click();
        BrowserActionsOne.acceptAlert();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()=' Feel the pain ']")));
        List<WebElement> checkList;
        checkList = table.findElements(By.xpath("//*[text()=' Feel the pain ']"));
        Assertions.assertThat(checkList.size()).as("The row is still there").isEqualTo(0);
        BrowserActionsOne.clearWishList();
    }

    @AfterMethod
    public void cleanUp () {

        BrowserActionsOne.cleanupBrowser();
    }
}
