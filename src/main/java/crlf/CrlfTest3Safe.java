package crlf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.reference.DefaultHTTPUtilities;

public class CrlfTest3Safe {
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    unsafe(request, response);
  }

  private void unsafe(HttpServletRequest request, HttpServletResponse response) {
    String name = request.getParameter("name");
    response.setContentType("text/html");
    DefaultHTTPUtilities.getInstance().addHeader(response,"Content-Disposition", "attachment;filename=" + name + ".csv");
    response.addHeader("Content-type", "application/csv");
  }
}
