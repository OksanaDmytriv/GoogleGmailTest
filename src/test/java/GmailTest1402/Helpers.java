package GmailTest1402;

public class Helpers {

    public static String getUniqueText(String prefix) {
        prefix += prefix + System.currentTimeMillis();
        return prefix;
    }
}
