package GmailTest1402.pages;

import static com.codeborne.selenide.Selenide.$;


public class Gmail {

    public static void open() {
        //иначе не хочет, считает что я использую этот же метод и пишет что стринг не должен быть параметром, помоги
        com.codeborne.selenide.Selenide.open("http://gmail.com");
    }

    public static void login(String email, String password) {
        $("#Email").setValue(email).pressEnter();
        $("#Passwd").setValue(password).pressEnter();
    }
}
