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

        int metersToCm = Integer.valueOf(meters) * 100;
        int metersToMM = Integer.valueOf(meters) * 1000;
        int cmToMeters = Integer.valueOf(cm) / 100;
        int cmToMM = Integer.valueOf(cm) * 10;
        int mmToMeters = Integer.valueOf(mm) / 1000;
        int mmToCm = Integer.valueOf(mm) / 10;

        writer.println("<h1>Podana wartość w przeliczeniu na:</h1>");
        String quantity = null;     //jak pobrac wartosc atryb name
        switch (quantity){
            case "meters":
                writer.println("<h2>metry: " + meters +" </h2>");
                writer.println("<h2>centymetry: " + metersToCm +" </h2>");
                writer.println("<h2>milimetry: " + metersToMM +" </h2>");
                break;
            case "cm":
                writer.println("<h2>metry: " + cmToMeters +" </h2>");
                writer.println("<h2>centymetry: " + cm +" </h2>");
                writer.println("<h2>milimetry: " + cmToMM +" </h2>");
                break;
            case "mm":
                writer.println("<h2>metry: " + mmToMeters +" </h2>");
                writer.println("<h2>centymetry: " + mmToCm +" </h2>");
                writer.println("<h2>milimetry: " + mm +" </h2>");
                break;
            default:
                writer.println("<h1>Wypełnij tylko jedno pole!</h1>");
        }
    }
}
