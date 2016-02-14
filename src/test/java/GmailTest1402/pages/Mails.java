package GmailTest1402.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Mails {

    public static ElementsCollection emails = $$(".F.cf.zt tr");

    public static void send(String email, String subject) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).setValue(email);
        $(By.name("subjectbox")).setValue(subject);
        $(byText("Send")).click();
    }

    public static void assertMails(String... subject) {
        emails.shouldHave(exactTexts(subject));
    }

    public static void assertMail(int index, String subject) {
        emails.get(index).shouldHave(text(subject));
    }
}
