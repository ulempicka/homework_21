import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/meters")
public class MetersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String meters = request.getParameter("meters");
        String cm = request.getParameter("cm");
        String mm = request.getParameter("mm");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        double metersToCm = Double.valueOf(meters) * 100;
        double metersToMM = Double.valueOf(meters) * 1000;
        double cmToMeters = Double.valueOf(cm) / 100;
        double cmToMM = Double.valueOf(cm) * 10;
        double mmToMeters = Double.valueOf(mm) / 1000;
        double mmToCm = Double.valueOf(mm) / 10;

        writer.println("<h1>Podana wartość w przeliczeniu na:</h1>");
        if (meters != null && !meters.equals("")) {
            writer.println("<h2>metry: " + meters + " </h2>");
            writer.println("<h2>centymetry: " + metersToCm + " </h2>");
            writer.println("<h2>milimetry: " + metersToMM + " </h2>");
        }else if (cm != null && !cm.equals("")) {
            writer.println("<h2>metry: " + cmToMeters + " </h2>");
            writer.println("<h2>centymetry: " + cm + " </h2>");
            writer.println("<h2>milimetry: " + cmToMM + " </h2>");
        }else if (mm != null && !mm.equals("")) {
            writer.println("<h2>metry: " + mmToMeters + " </h2>");
            writer.println("<h2>centymetry: " + mmToCm + " </h2>");
            writer.println("<h2>milimetry: " + mm + " </h2>");
        }else{
                writer.println("<h1>Wypełnij tylko jedno pole!</h1>");
        }
    }
}
