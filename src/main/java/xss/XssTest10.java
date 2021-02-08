package xss;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class XssTest10 {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        unsafe(request, response);
    }
    private void unsafe(HttpServletRequest request, HttpServletResponse response) {
        String callBack = request.getParameter("callBack");
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.write(callBack);
            out.write("<br><br>Unsafe CSS style attribute context:<br>");
            out.write("<h1>TEXT</h1>");
            out.write("</div>");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        DefaultHTTPUtilities
    }

}