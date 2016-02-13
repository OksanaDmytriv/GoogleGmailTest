package GmailTest1302.pages;

import GmailTest1302.TestData;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;

public class Gmail extends TestData {

    public static ElementsCollection emails = $$(".F.cf.zt");

    //вынесла создание сабджекта сюда и не прописывала в параметрах методов, так как я не могу точно знать время отправления письма
    static Date d = new Date();
    static SimpleDateFormat format1 = new SimpleDateFormat("hh:mm");
    static String subject = "test" + format1.format(d.getTime());

    public static void openGmail() {
        open("http://gmail.com");
    }

    public static void loginToGmail(String email, String password) {
        $("#Email").setValue(email).pressEnter();
        $("#Passwd").setValue(password).pressEnter();
    }

    public static void sendEmail() {
        $(byText("COMPOSE")).click();
        $(By.name("to")).setValue(email);
        $(By.name("subjectbox")).setValue(subject);
        $(byText("Send")).click();
    }

    public static void refreshGmail() {
        $(".asf.T-I-J3.J-J5-Ji").click();
    }

    public static void assertEmailAvailability(int emailIndex) {
        emails.get(emailIndex).shouldHave(text(subject));
    }

    //а тут какаято мистика! при переходе на эту страницу оно сразу открывает последнее письмо, почему? нет же такой комманды!)
    public static void openSentMail() {
        $(byTitle("Sent Mail")).click();
    }

    public static void openInbox() {
        $(byTitle("Inbox")).click();
    }

    public static void findEmailBySubject() {
        $(By.name("q")).setValue("subject:" + subject).pressEnter();
    }

    //падает почему-то, не могу найти причину, скрины идеи показывают что элемент таки есть
    //ошибка: Element should have text 'test07:13' {.F.cf.zt[0]}
    //Element: '<table cellpadding="0" class="F cf zt" id=":36" displayed:false></table>'
    public static void assertOneEmailAvailability() {
        emails.get(0).shouldHave(text(subject));
    }


}
