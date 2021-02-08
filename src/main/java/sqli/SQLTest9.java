package sqli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest9 {

    public void sqlTest9(HttpServletRequest request) {
        String ip = request.getParameter("ip");
        if (ip.length() > 3) {
            ip = ip + ".a";
        } else {
            ip = ip + ".b";
        }
        try {
            String sql = "INSERT INTO banned_ip(id, ip) VALUE('" + UUID.randomUUID().toString() + "','" + ip + "')";
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