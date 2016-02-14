package GmailTest1402.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;


public class Menu {

    public static void refresh() {
        $(".asf").click();
    }

    public static void openSentMail() {
        $(byTitle("Sent Mail")).click();
    }

    public static void openInbox() {
        $(byTitle("inbox")).click();
    }

    public static void search(String subject) {
        $(By.name("q")).setValue("subject:" + subject).pressEnter();
    }
}
