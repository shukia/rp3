package sqli;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest1 {

	public void sqlTest1(HttpServletRequest request) {
		String ip = request.getParameter("ip");
		try {
			Statement statement = getJDBCConnection().createStatement();
			String sql = "INSERT INTO banned_ip(id, ip) VALUE('" + UUID.randomUUID().toString() + "','" + ip + "')";
			statement.execute(sql);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		System.out.print("sdfsf");
	}

	Connection getJDBCConnection() {
		return null;
	}
}