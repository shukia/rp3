package sqli;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest21 {

  public void sqlTest21(HttpServletRequest request) {
    String ip = request.getParameter("ip");
    try {
      String sql = "INSERT INTO banned_ip(id, ip) VALUE('" + UUID.randomUUID().toString() + "','" + ip + "')";
      Statement statement = getJDBCConnection().createStatement();
      sink(sql, statement);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }


  public void sink (String sql, Statement statement) {
    try {
      statement.execute(sql);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    System.out.print("sdfdsf");
  }

  Connection getJDBCConnection() {
    return null;
  }


}