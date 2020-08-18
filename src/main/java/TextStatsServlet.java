import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/textStats")
public class TextStatsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String text = request.getParameter("textFromUser");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        countAllChars(text, writer);
        countCharsWithoutSpaces(text, writer);
        countWords(text, writer);
        isPalindrome(text, writer);
    }

    private void isPalindrome(String text, PrintWriter writer) {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        boolean isPalindrome = reversed.equals(text);
        writer.println("<h1>Odwrócony text: " + reversed + "</h1>");
        writer.println("<h1>Palindrom: " + isPalindrome + "</h1>");
    }

    private void countWords(String text, PrintWriter writer) {
        String[] split = text.split(" ");
        int countWords = split.length;
        writer.println("<h1>Ilość słów: " + countWords + "</h1>");
    }

    private void countCharsWithoutSpaces(String text, PrintWriter writer) {
        int charsWithoutSpaces = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ')
                charsWithoutSpaces++;
        }
        writer.println("<h1>Ilość znaków bez spacji: " + charsWithoutSpaces + "</h1>");
    }

    private void countAllChars(String text, PrintWriter writer) {
        writer.println("<i>" + text + "</i>");
        writer.println("<h1>Ilość znaków: " + text.length() + "</h1>");
    }
}
