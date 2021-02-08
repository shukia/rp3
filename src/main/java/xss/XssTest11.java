package xss;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class XssTest11 {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // BAD: a request parameter is written directly to the Servlet response stream
    response.getWriter().print(
        "The page \"" + request.getParameter("page") + "\" was not found.");

  }
}
