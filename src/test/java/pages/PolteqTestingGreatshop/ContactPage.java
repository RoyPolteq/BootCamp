package pages.PolteqTestingGreatshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class ContactPage extends BasePage {

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

    @FindBy(xpath = "//*[contains(@class, 'alert-success')]") //als een webelement meerdere classes heeft, moet je met xpath contains gebruiken
    List<WebElement> successMessageXpath;

    @FindBy(className = "alert-success")
    WebElement successMessage;

    public ContactPage(WebDriver driver) {

        super(driver); //roept de constructor code aan van de class die je extend
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

    public boolean returnNumberOfSuccessMessagesNoList() {

        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();
    }
}
