package tests.chapterNine;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.PolteqTestingGreatshop.ContactPage;
import pages.PolteqTestingGreatshop.Header;
import tests.TestShopScenario;

public class ContactFormTest extends TestShopScenario {

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
}
