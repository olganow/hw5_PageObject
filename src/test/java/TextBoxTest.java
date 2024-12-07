import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase {

    private String
            fullNameUser = "Firstname Secondname",
            email = "useremail@mail.ma",
            currentAddress = "Current address",
            permanentAddress = "Permanent address";

    TextBoxPage textBox = new TextBoxPage();

    @Test
    void successfulFillInAndSubmitFullFormTest() {
        textBox.openPage()
                .setFullName(fullNameUser)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitForm()
                .confirmData(fullNameUser, email, currentAddress, permanentAddress);
    }
}
