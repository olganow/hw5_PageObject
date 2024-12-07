import org.junit.jupiter.api.Test;
import pages.ConfirmationPage;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase {
    private String firstNameUser = "Firstname",
            lastNameUser = "Secondname",
            email = "useremail@mail.ma",
            gender = "Female",
            phone = "1234567890",
            yearOfBirth = "1998",
            monthOfbirth = "May",
            dayOfbirth = "16",
            subjectOne = "Economics",
            subjectSecond = "Biology",
            hobby = "Sports",
            picture = "mypict.png",
            street = "ABC avenue, 000",
            state = "Uttar Pradesh",
            city = "Lucknow";

    RegistrationPage registrationPage = new RegistrationPage();
    ConfirmationPage confirmationPage = new ConfirmationPage();

    @Test
    void successfulFillInAndSubmitFullFormTest() {
        registrationPage.openPage()
                .setFirstName(firstNameUser)
                .setLastName(lastNameUser)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(dayOfbirth, monthOfbirth, yearOfBirth)
                .setSubjects(subjectOne, subjectSecond)
                .setHobby(hobby)
                .setAvatar(picture)
                .setAddress(street, state, city)
                .submitForm();

        confirmationPage
                .confirmPage()
                .confirmName(firstNameUser, lastNameUser)
                .confirmEmail(email)
                .confirmGender(gender)
                .confirmPhone(phone)
                .confirmBirthday(dayOfbirth, monthOfbirth, yearOfBirth)
                .confirmSubjects(subjectOne, subjectSecond)
                .confirmHobby(hobby)
                .confirmAvatar(picture)
                .confirmStreet(street)
                .confirmStateAndSity(state, city);
    }


    @Test
    void successfulFillInAndSubmitShortFormTest() {
        registrationPage.openPage()
                .setFirstName(firstNameUser)
                .setLastName(lastNameUser)
                .setGender(gender)
                .setUserNumber(phone)
                .submitForm();

        confirmationPage
                .confirmPage()
                .confirmName(firstNameUser, lastNameUser)
                .confirmGender(gender)
                .confirmPhone(phone);
    }


    @Test
    void unsuccessfulFillInAndSubmitShortFormTestWithEmptySecondNameFieldNegative() {
        registrationPage.openPage()
                .setFirstName(firstNameUser)
                .setGender(gender)
                .setUserNumber(phone)
                .submitForm()
                .validateLastUserField();
    }

}

