package GmailTest1402.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;


public class Gmail {

    public static void open() {
        Selenide.open("http://gmail.com");
    }

    public static void login(String email, String password) {
        $("#Email").setValue(email).pressEnter();
        $("#Passwd").setValue(password).pressEnter();
    }
}
