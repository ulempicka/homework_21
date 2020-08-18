import java.io.PrintWriter;

public final class TextStatsUtils {

    private TextStatsUtils() {
    }

    public static void countAllChars(String text, PrintWriter writer) {
        writer.println("<i>" + text + "</i>");
        writer.println("<h1>Ilość znaków: " + text.length() + "</h1>");
    }

    public static void countCharsWithoutSpaces(String text, PrintWriter writer) {
        int charsWithoutSpaces = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ')
                charsWithoutSpaces++;
        }
        writer.println("<h1>Ilość znaków bez spacji: " + charsWithoutSpaces + "</h1>");
    }

    public static void countWords(String text, PrintWriter writer) {
        String[] split = text.split(" ");
        int countWords = split.length;
        writer.println("<h1>Ilość słów: " + countWords + "</h1>");
    }

    public static void isPalindrome(String text, PrintWriter writer) {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        boolean isPalindrome = reversed.equals(text);
        writer.println("<h1>Odwrócony text: " + reversed + "</h1>");
        writer.println("<h1>Palindrom: " + isPalindrome + "</h1>");
    }
}
