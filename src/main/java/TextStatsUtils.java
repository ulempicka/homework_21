import java.io.PrintWriter;

public final class TextStatsUtils {

    private TextStatsUtils() {
    }

    public static void countAllChars(String text, PrintWriter writer) {
        writer.println("<i>" + text + "</i>");
        writer.println("<h1>Ilość znaków: " + text.length() + "</h1>");
    }

    public static void countCharsWithoutSpaces(String text, PrintWriter writer) {
        int charsWithoutSpaces = text.replaceAll(" ", "").length();
        writer.println("<h1>Ilość znaków bez spacji: " + charsWithoutSpaces + "</h1>");
    }

    public static void countWords(String text, PrintWriter writer) {
        String[] split = text.split(" ");
        int countWords = split.length;
        writer.println("<h1>Ilość słów: " + countWords + "</h1>");
    }

    public static void isPalindrome(String text, PrintWriter writer) {
        String textToLower = text.toLowerCase();
        StringBuilder builder = new StringBuilder(textToLower);
        StringBuilder reversed = builder.reverse();
        boolean isPalindrome = reversed.equals(textToLower);
        writer.println("<h1>Odwrócony text: " + reversed + "</h1>");
        writer.println("<h1>Palindrom: " + isPalindrome + "</h1>");
    }
}
