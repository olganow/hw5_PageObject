package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ConfirmationPage {

    private final static String THANKS_SUBMITTING_FORM = "Thanks for submitting the form";

    private SelenideElement
            titleInput = $("#example-modal-sizes-title-lg"),
            nameInput = $x("//td[text()='Student Name']"),
            emailInput = $x("//td[text()='Student Email']"),
            genderInput = $x("//td[text()='Gender']"),
            mobileInput = $x("//td[text()='Mobile']"),
            birthdayInput = $x("//td[text()='Date of Birth']"),
            subjectInput = $x("//td[text()='Subjects']"),
            hobbyInput = $x("//td[text()='Hobbies']"),
            pictureInput = $x("//td[text()='Picture']"),
            addressInput = $x("//td[text()='Address']"),
            stateAndCityInput = $x("//td[text()='State and City']");

    public ConfirmationPage confirmPage() {
        titleInput.shouldHave(text(THANKS_SUBMITTING_FORM));
        return this;
    }

    public ConfirmationPage confirmName(String firstNameUser, String lastNameUser) {
        nameInput.parent().shouldHave(text(firstNameUser + " " + lastNameUser));
        return this;
    }

    public ConfirmationPage confirmEmail(String email) {
        emailInput.parent().shouldHave(text(email));
        return this;
    }

    public ConfirmationPage confirmGender(String gender) {
        genderInput.parent().shouldHave(text(gender));
        return this;
    }

    public ConfirmationPage confirmPhone(String phone) {
        mobileInput.parent().shouldHave(text(phone));
        return this;
    }

    public ConfirmationPage confirmBirthday(String dayOfbirth, String monthOfbirth, String yearOfBirth) {
        birthdayInput.parent().shouldHave(text(dayOfbirth + " " + monthOfbirth + "," + yearOfBirth));

        return this;
    }

    public ConfirmationPage confirmSubjects(String subjectOne, String subjectSecond) {
        subjectInput.parent().shouldHave(text(subjectOne + ", " + subjectSecond));
        return this;
    }

    public ConfirmationPage confirmHobby(String hobby) {
        hobbyInput.parent().shouldHave(text(hobby));
        return this;
    }

    public ConfirmationPage confirmAvatar(String picture) {
        pictureInput.parent().shouldHave(text(picture));
        return this;
    }

    public ConfirmationPage confirmStreet(String street) {
        addressInput.parent().shouldHave(text(street));
        return this;
    }

    public ConfirmationPage confirmStateAndSity(String state, String city) {
        stateAndCityInput.parent().shouldHave(text(state + " " + city));
        return this;
    }


}
