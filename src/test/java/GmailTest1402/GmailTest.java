package GmailTest1402;

import GmailTest1402.pages.Gmail;
import GmailTest1402.pages.Mails;
import GmailTest1402.pages.Menu;
import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static GmailTest1402.Helpers.getUniqueText;

public class GmailTest {

    static {
        Configuration.timeout = 15000;
    }

    @Test
    public void testGmailCommonFlow() {

        String subject = getUniqueText("test");

        Gmail.open();
        Gmail.login(TestData.email, TestData.password);

        Mails.send(TestData.email, subject);
        Menu.refresh();
        Mails.assertMail(0, subject);

        Menu.openSent();
        Mails.assertMail(0, subject);

        Menu.openInbox();
        Menu.search(subject);
        Mails.assertMails(subject);
    }
}

