package pages.PolteqTestingGreatshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    WebDriver driver;

    @FindBy(xpath = "//*[@title='Contact us']")
    WebElement loginButton;

    public Header (WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

        public void clickOnContactUs () {

            loginButton.click();
        }
}
