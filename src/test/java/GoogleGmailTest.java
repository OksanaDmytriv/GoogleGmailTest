import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;

public class GoogleGmailTest {
    @Test
    public void testSendEmail() {

        openGoogle();
        clickOnSighInButton();
        enterEmail("testoksana2@gmail.com");
        enterPassword("12qwerty");
        openGmailPage();
        startingCreateMailLetter();
        createAndSendEmail("testoksana2@gmail.com", "Hello hello");
        assertEmailReceived("Hello hello");
        assertNthResult("Hello hello", 1);
        assertEmailExistInSent("Hello hello");
    }

    SelenideElement emailGrid = $(".AO>.Tm>.aeF");

    private void openGoogle() {
        open("http://google.com/ncr");
    }

    private void clickOnSighInButton() {
        $("#gb_70").click();
    }

    private void enterEmail(String email) {
        $("#Email").setValue(email).pressEnter();
    }

    private void enterPassword(String password) {
        $("#Passwd").setValue(password).pressEnter();
    }

    private void openGmailPage() {
        $(byText("Gmail")).click();
        Configuration.timeout = 10000;
    }

    private void startingCreateMailLetter() {
        $(byText("COMPOSE")).click();
    }

    private void createAndSendEmail(String emailAddress, String subject) {
        $(By.name("to")).setValue(emailAddress).pressTab();
        $(By.name("subjectbox")).setValue(subject).pressTab();
        $(byText("Send")).click();
        refresh();
    }

    private void assertEmailReceived(String emailSubject) {
        emailGrid.shouldHave(text(emailSubject));
    }

    private void assertEmailExistInSent(String emailSubject) {
        $(byTitle("Sent Mail")).click();
        Configuration.timeout = 10000;
        emailGrid.shouldHave(text(emailSubject));
        $(byTitle("Inbox")).click();
        Configuration.timeout = 10000;
    }

    private void assertNthResult(String emailSubject, int emailQuantity) {
        $(".gbqfif").setValue(emailSubject).click();
        //метод работает, но если писем больше чем указано в параметре тест не падает, все передумала, пока не знаю, помоги плиз :)
       $(".Cp").getSize().equals(emailQuantity);

    }
}

