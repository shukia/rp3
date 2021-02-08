package sqli;

import java.sql.Connection;
import java.sql.SQLException;

public class goxr3plusSlicedTest {

  private String libraryName;

  public void deleteLibrary(final boolean byPassQuestion) throws SQLException {
    if (byPassQuestion) {
      getJDBCConnection()
          .createStatement()
          .executeUpdate("DELETE FROM LIBRARIES WHERE NAME='" + getLibraryName() + "' ");
    }
  }

  Connection getJDBCConnection() {
    return null;
  }

  public String getLibraryName() {
    return libraryName;
  }
}
