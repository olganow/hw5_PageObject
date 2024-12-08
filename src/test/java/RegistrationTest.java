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

    private String
            fullNameCellName = "Student Name",
            emailCellName = "Student Email",
            genderCellName = "Gender",
            phoneCellName = "Mobile",
            birthdayCellName = "Date of Birth",
            subjectCellName = "Subjects",
            hobbyCellName = "Hobbies",
            pictureCellName = "Picture",
            addressCellName = "Address",
            stateAndCityCellName = "State and City";

    RegistrationPage registrationPage = new RegistrationPage();
    ConfirmationPage confirmationPage = new ConfirmationPage();

    @Test
    void successfulFillInAndSubmitFullFormTest() {
        registrationPage
                .openPage()
                .removeBanner()
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
                .confirmResult(fullNameCellName, firstNameUser + " " + lastNameUser)
                .confirmResult(emailCellName, email)
                .confirmResult(genderCellName, gender)
                .confirmResult(phoneCellName, phone)
                .confirmResult(birthdayCellName, dayOfbirth + " " + monthOfbirth + "," + yearOfBirth)
                .confirmResult(subjectCellName, subjectOne + ", " + subjectSecond)
                .confirmResult(hobbyCellName, hobby)
                .confirmResult(pictureCellName, picture)
                .confirmResult(addressCellName, street)
                .confirmResult(stateAndCityCellName, state + " " + city);
    }

    @Test
    void successfulFillInAndSubmitShortFormTest() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName(firstNameUser)
                .setLastName(lastNameUser)
                .setGender(gender)
                .setUserNumber(phone)
                .submitForm();

        confirmationPage
                .confirmPage()
                .confirmResult(fullNameCellName, firstNameUser + " " + lastNameUser)
                .confirmResult(genderCellName, gender)
                .confirmResult(phoneCellName, phone);
    }


    @Test
    void unsuccessfulFillInAndSubmitShortFormTestWithEmptySecondNameFieldNegative() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName(firstNameUser)
                .setGender(gender)
                .setUserNumber(phone)
                .submitForm()
                .validateLastUserField();
    }

}

