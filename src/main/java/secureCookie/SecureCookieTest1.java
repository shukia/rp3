package secureCookie;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecureCookieTest1 {
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    unsafe(request, response);
  }

  private void unsafe(HttpServletRequest request, HttpServletResponse response) {
    String password = "p-" + new Random().nextLong();
    Cookie cookie = new Cookie("password", password);
    cookie.setPath("/");
    cookie.setDomain("");
    cookie.setComment("cookie description");
    cookie.setMaxAge(900);
    response.addCookie(cookie);
  }
}
