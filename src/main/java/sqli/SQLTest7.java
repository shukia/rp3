package sqli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest7 {

    public void sqlTest7(HttpServletRequest request) {
        String ip = request.getParameter("ip");
        String id = request.getParameter("id");
        try {
            getJDBCConnection().createStatement().execute("INSERT INTO banned_ip(id, ip) VALUE('" + UUID.randomUUID().toString() + "','" + ip + "','" + id + "')");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        System.out.print("sdfdsf");
    }

    Connection getJDBCConnection() {
        return null;
    }
}