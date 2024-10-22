import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue("Airat");
        $("#lastName").setValue("Karimov");
        $("#userEmail").setValue("karimov@yandex.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8900011111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("2000");
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text("2")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("Duck.png");
        $("#currentAddress").setValue("USA");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Airat Karimov"));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("karimov@yandex.ru"));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("8900011111"));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("02 August,2000"));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Maths"));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
        $(".table").$(byText("Picture")).sibling(0).shouldHave(text("Duck.png"));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text("USA"));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text("NCR Delhi"));
    }
}