package pages.polteqGreatWorkshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class Header extends BasePage {

    @FindBy(xpath = "//*[@title='Contact us']")
    WebElement contactUsButton;

    @FindBy(xpath = "//*[@class='login']")
    WebElement signInButton;

    public Header (WebDriver driver) {

        super(driver); //roept de code in de constructor aan van de class waarvan je extend
    }

        public void clickOnContactUs () {

            contactUsButton.click();
        }

        public void clickOnSignIn() {

            signInButton.click();
        }
}
