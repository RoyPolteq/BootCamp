package pages.polteqGreatWorkshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LogInPage extends BasePage {

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//*[@id='passwd']")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id='SubmitLogin']")
    WebElement submitButton;

    public LogInPage(WebDriver driver) {

        super(driver); //roept de code in de constructor aan van de class waarvan je extend
    }

    public void fillInEmail (String email) {

        emailField.sendKeys(email);
    }

    public void fillInPassword(String password) {

        passwordField.sendKeys(password);
    }

    public void clickOnSubmit() {

        submitButton.click();
    }
}
