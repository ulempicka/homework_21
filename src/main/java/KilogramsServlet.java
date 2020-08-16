import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/kilograms")
public class KilogramsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kg = request.getParameter("kg");
        String g = request.getParameter("g");
        String mg = request.getParameter("mg");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        int kgToGrams = Integer.valueOf(kg) * 1000;
        int kgToMg = Integer.valueOf(kg) * 1000 * 1000;
        int gramsToKg = Integer.valueOf(g) / 1000;
        int gramsToMg = Integer.valueOf(g) * 1000;
        int mgToKg = Integer.valueOf(mg) / 1000000;
        int mgToGram = Integer.valueOf(mg) / 1000;

        writer.println("<h1>Podana wartość w przeliczeniu na:</h1>");
        String quantity = null;
        switch (quantity){
            case "kg":
                writer.println("<h2>kilogramy: " + kg +" </h2>");
                writer.println("<h2>gramy: " + kgToGrams +" </h2>");
                writer.println("<h2>miligramy: " + kgToMg +" </h2>");
                break;
            case "g":
                writer.println("<h2>kilogramy: " + gramsToKg +" </h2>");
                writer.println("<h2>gramy: " + g +" </h2>");
                writer.println("<h2>miligramy: " + gramsToMg +" </h2>");
                break;
            case "mg":
                writer.println("<h2>kilogramy: " + mgToKg +" </h2>");
                writer.println("<h2>gramy: " + mgToGram +" </h2>");
                writer.println("<h2>miligramy: " + mg +" </h2>");
                break;
            default:
                writer.println("<h1>Wypełnij tylko jedno pole!</h1>");
        }
    }
}
