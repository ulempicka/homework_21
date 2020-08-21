import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/text-stats")
public class TextStatsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String text = request.getParameter("text");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        TextStatsUtils.countAllChars(text, writer);
        TextStatsUtils.countCharsWithoutSpaces(text, writer);
        TextStatsUtils.countWords(text, writer);
        TextStatsUtils.isPalindrome(text, writer);
    }
}
