package pages.PolteqTestingGreatshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ContactPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id='id_contact']")
    WebElement subjectHeadingDropdown;

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//*[@id='id_order']")
    WebElement orderReferenceField;

    @FindBy(xpath = "//*[@id='message']")
    WebElement messageField;

    @FindBy(xpath = "//*[@id='submitMessage']")
    WebElement submitButton;

    @FindBy(xpath = "//*[contains(@class, 'alert-success')]")
    List<WebElement> successMessageXpath;

    @FindBy(className = "alert-success")
    List<WebElement> successMessage;

    public ContactPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void selectSubject(String subject) {

        Select dropdown = new Select(subjectHeadingDropdown);
        dropdown.selectByVisibleText(subject);
    }

    public void fillInEmail(String email) {

        emailField.sendKeys(email);
    }

    public void fillInReference(String reference) {

        orderReferenceField.sendKeys(reference);
    }

    public void fillInMessage(String message) {

        messageField.sendKeys(message);
    }

    public void clickOnSubmit() {

        submitButton.click();
    }

    public int returnNumberOfSuccessMessages() {

        wait.until(ExpectedConditions.visibilityOf(successMessageXpath.getFirst()));
        return successMessageXpath.size();
    }

    public boolean returnNumberOfSuccessMessagesBoolean() {

        wait.until(ExpectedConditions.visibilityOf(successMessageXpath.getFirst()));
        return successMessageXpath.size()== 1;
    }
}