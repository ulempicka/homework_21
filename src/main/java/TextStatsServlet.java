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

        writer.println("<p>" + text + "</p>");
        writer.println("<h1>Ilość znaków: " + text.length() + "</h1>");

        int countCharsWithoutSpaces = 0;
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) != ' ')
                countCharsWithoutSpaces++;
        }
        writer.println("<h1>Ilość znaków bez spacji: " + countCharsWithoutSpaces + "</h1>");

        String[] split = text.split(" ");
        int countWords = split.length;
        writer.println("<h1>Ilość słów: " + countWords + "</h1>");

        String reversed = "";
        for(int i = text.length()-1; i >= 0; i--) {
             reversed += text.charAt(i);
        }
        boolean isPalindrome = reversed.equals(text);
        writer.println("<h1>Odwrócony text: " + reversed + "</h1>");
        writer.println("<h1>Palindrom: " + isPalindrome + "</h1>");
    }
}
