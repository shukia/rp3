package xss;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XssTest9 {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        unsafe(request, response);
    }

    private void unsafe(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String alert = "\"alert('" + name + "');\"";
        String onClick = "<a onclick=" + alert + ">";
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<br><br><h1 align=center><font color=\"red\">Unsafe Javascript Attribute context:<br></font></h1>");
            out.println(onClick);
            out.println("Click me</a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}