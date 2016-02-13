package GmailTest1302;

import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static GmailTest1302.pages.Gmail.*;

public class GmailTest extends TestData {

    static {
        Configuration.timeout = 15000;
    }

    @Test
    public void testGmailCommonFlow() {

        openGmail();
        loginToGmail(email, password);

        sendEmail();
        refreshGmail();
        assertEmailAvailability(0);

        openSentMail();
        assertEmailAvailability(0);

        openInbox();
        findEmailBySubject();
        assertOneEmailAvailability();
    }
}

