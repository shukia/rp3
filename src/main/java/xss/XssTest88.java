package xss;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class XssTest88{
	HttpServletRequest request;
    HttpServletResponse response;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        String name = request.getParameter("name");
        unsafe(name);
    }

    private void unsafe(String name) {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.write("<html>");
            out.write("<head>");
            out.write("<style>h1 {color:" + name + ";}</style>");
            out.write("</head>");
            out.write("<body>");
            out.write("<br><br>Unsafe CSS style block context:<br>");
//            out.write("<h1>" + Encode.forHtml(name) + "</h1>");
            out.write("</body>");
            out.write("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void safe(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.write("<html>");
//            out.write("<head>");
//            out.write("<style>h1 {color:" + Encode.forCssString(name) + ";}</style>");
//            out.write("</head>");
//            out.write("<body>");
//            out.write("<br><br>Safe CSS style block context:<br>");
//            out.write("<h1>" + Encode.forHtml(name) + "</h1>");
//            out.write("</body>");
//            out.write("</html>");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}