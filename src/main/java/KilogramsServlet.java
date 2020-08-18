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

        double kgToGrams = Double.valueOf(kg) * 1000;
        double kgToMg = Double.valueOf(kg) * 1000 * 1000;
        double gramsToKg = Double.valueOf(g) / 1000;
        double gramsToMg = Double.valueOf(g) * 1000;
        double mgToKg = Double.valueOf(mg) / 1000000;
        double mgToGram = Double.valueOf(mg) / 1000;

        writer.println("<h1>Podana wartość w przeliczeniu na:</h1>");
        if (kg != null && !kg.equals("")) {
            writer.println("<h2>kilogramy: " + kg + " </h2>");
            writer.println("<h2>gramy: " + kgToGrams + " </h2>");
            writer.println("<h2>miligramy: " + kgToMg + " </h2>");
        } else if (g != null && !g.equals("")) {
            writer.println("<h2>kilogramy: " + gramsToKg + " </h2>");
            writer.println("<h2>gramy: " + g + " </h2>");
            writer.println("<h2>miligramy: " + gramsToMg + " </h2>");
        } else if (mg != null && !mg.equals("")) {
            writer.println("<h2>kilogramy: " + mgToKg + " </h2>");
            writer.println("<h2>gramy: " + mgToGram + " </h2>");
            writer.println("<h2>miligramy: " + mg + " </h2>");
        } else {
            writer.println("<h1>Wypełnij tylko jedno pole!</h1>");
        }
    }
}
