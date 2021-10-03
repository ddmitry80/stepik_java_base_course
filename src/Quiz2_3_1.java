import java.util.Locale;

public class Quiz2_3_1 {
    public static boolean isPalindrome(String text) {
        System.out.println("in text: " + text);
        String text2 = text.replaceAll("[^a-zA-Z0-9]", "");
        String text3 = new StringBuilder(text2).reverse().toString();
        System.out.println(text2);
        System.out.println(text3);
        Boolean r = text2.equalsIgnoreCase(text3);
        System.out.println(text3.toString());
        return r;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam, I'm Adam!"));
    }
}
