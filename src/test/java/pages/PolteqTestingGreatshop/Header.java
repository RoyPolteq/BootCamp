package pages.PolteqTestingGreatshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {

    @FindBy(xpath = "//*[@title='Contact us']")
    WebElement loginButton;

    public Header (WebDriver driver) {

        super(driver); //roept de code in de constructor aan van de class waarvan je extend
    }

        public void clickOnContactUs () {

            loginButton.click();
        }
}
