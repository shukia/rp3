package sqli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest4 {

    public void sqlTest4(HttpServletRequest request) {
        String ip = request.getParameter("ip");
        String id = request.getParameter("id");
        try {
            String sql = "INSERT INTO banned_ip(id, ip) VALUE('" + UUID.randomUUID().toString() + "','" + ip + "','" + id + "')";
            Statement statement = getJDBCConnection().createStatement();
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