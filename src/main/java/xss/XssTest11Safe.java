package xss;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.encoder.Encode;

public class XssTest11Safe {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Good: sanitize the request parameter
    response.getWriter().print(
        "The page \"" + Encode.forHtmlContent(request.getParameter("page")) + "\" was not found.");

  }
}
