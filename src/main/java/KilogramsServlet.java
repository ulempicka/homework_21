import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/kilograms")
public class KilogramsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String kg = request.getParameter("kg");
        String g = request.getParameter("g");
        String mg = request.getParameter("mg");
        String[] paramValues = new String[]{kg, g, mg};

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        int paramCount = UnitUtils.howManyFieldsFilled(paramValues);

        if (paramCount > 1) {
            writer.println("<h1>Wypełnij tylko jedno pole!</h1>");
            return;
        }

        double kgValue = 0;
        double gValue = 0;
        double mgValue = 0;

        if (kg != null && !kg.equals("")) {
            kgValue = Double.valueOf(kg);
            gValue = kgValue * 1000;
            mgValue = kgValue * 1000 * 1000;
        } else if (g != null && !g.equals("")) {
            gValue = Double.valueOf(g);
            kgValue = gValue / 1000;
            mgValue = gValue * 1000;
        } else if (mg != null && !mg.equals("")) {
            mgValue = Double.valueOf(mg);
            kgValue = mgValue / 1000_000;
            gValue = mgValue / 1000;
        }

        writer.println("<h1>Podana wartość w przeliczeniu na:</h1>");
        writer.println("<h2>kilogramy: " + kgValue + " </h2>");
        writer.println("<h2>gramy: " + gValue + " </h2>");
        writer.println("<h2>miligramy: " + mgValue + " </h2>");
    }
}
