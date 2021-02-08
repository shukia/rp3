package xss;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class XssTest52 {
	HttpServletRequest request;
    HttpServletResponse response;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        unsafe(name);
    }

    private void unsafe(String name) {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.write("<br><br>Unsafe HTML context:<br>");
            out.write("<h1>" + name + "</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}