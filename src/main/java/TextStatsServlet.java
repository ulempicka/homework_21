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
        response.setContentType("txt/html");
        PrintWriter writer = response.getWriter();

        writer.println("<h3>Wpisany przez Ciebie tekst:</h3>");
        writer.println("<p>" + text + "</p>");
        writer.println("<h3>Statystyki tekstu:</h3>");
        writer.println("<p>Liczba wszystkich znaków w tekście: " + text.length() + "</p>");

        int countCharsWithoutSpaces = 0;
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) != ' ')
                countCharsWithoutSpaces++;
        }
        writer.println("<p>Liczba wszystkich znaków bez spacji: " + countCharsWithoutSpaces + "</p>");

        String[] split = text.split(" ");
        int countWords = split.length;
        writer.println("<p>Liczba wyrazów: " + countWords + "</p>");

        String reversed = null;
        for(int i = text.length()-1; i >= 0; i--) {
             reversed += text.charAt(i);
        }
        boolean isPalindrome = reversed.equals(text);
        writer.println("<p>Czy tekst jest palindromem? " + isPalindrome + "</p>");
    }
}
