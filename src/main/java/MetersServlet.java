import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/meters")
public class MetersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String m = request.getParameter("meters");
        String cm = request.getParameter("cm");
        String mm = request.getParameter("mm");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if ((m != null && !m.equals("") && cm != null && !cm.equals("") && mm != null && !mm.equals(""))
                || (m != null && !m.equals("") && cm != null && !cm.equals(""))
                || (cm != null && !cm.equals("") && mm != null && !mm.equals(""))
                || (m != null && !m.equals("") && mm != null && !mm.equals(""))) {
            writer.println("<h1>Wypełnij tylko jedno pole!</h1>");
            return;
        }

        double mValue = 0;
        double cmValue = 0;
        double mmValue = 0;

        if (m != null && !m.equals("")) {
            mValue = Double.valueOf(m);
            cmValue = mValue * 100;
            mmValue = mValue * 1000;
        } else if (cm != null && !cm.equals("")) {
            cmValue = Double.valueOf(cm);
            mValue = cmValue / 100;
            mmValue = cmValue * 10;
        } else if (mm != null && !mm.equals("")) {
            mmValue = Double.valueOf(mm);
            mValue = mmValue / 1000;
            cmValue = mmValue / 10;
        }

        writer.println("<h1>Podana wartość w przeliczeniu na:</h1>");
        writer.println("<h2>metry: " + mValue + " </h2>");
        writer.println("<h2>centymetry: " + cmValue + " </h2>");
        writer.println("<h2>milimetry: " + mmValue + " </h2>");
    }
}
