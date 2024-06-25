package parametersExperiment;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDrivenTest extends TestShopScenarioBrowserDriven {

    @Parameters({"subject","email" , "orderID" , "message"})
    @Test
    public void successfulSubmit(String subject, String email, String orderID, String message) {

        headerOne.clickOnContactUs();
        contactPageOne.selectSubject(subject);
        contactPageOne.fillInEmail(email);
        contactPageOne.fillInReference(orderID);
        contactPageOne.fillInMessage(message);
        contactPageOne.clickOnSubmit();

        Assertions.assertThat(contactPageOne.returnNumberOfSuccessMessages()).as("The amount of success messages is not 1").isEqualTo(1);
        Assertions.assertThat(contactPageOne.returnNumberOfSuccessMessagesBoolean()).as("it is not 1").isTrue();
        Assertions.assertThat(contactPageOne.returnNumberOfSuccessMessagesNoList()).as("success message not there").isTrue();
    }
}
