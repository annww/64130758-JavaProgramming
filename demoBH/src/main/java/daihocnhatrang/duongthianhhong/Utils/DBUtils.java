package daihocnhatrang.duongthianhhong.Utils;

import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
  public DBUtils() {
  }

  public static Connection openConnection() {
    Connection con = null;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String connectionURL = "jdbc:mysql://localhost:3306/demobh";
      con = DriverManager.getConnection(connectionURL, "root", "");
      System.out.println("Connection successful!");
    } catch (ClassNotFoundException var2) {
      ClassNotFoundException e = var2;
      System.out.println("MySQL Driver not found!");
      e.printStackTrace();
    } catch (SQLException var3) {
      SQLException e = var3;
      System.out.println("Connection failed!");
      e.printStackTrace();
    }

    return con;
  }

  public static void closeConnection(Connection con) {
    if (con != null) {
      try {
        con.close();
        System.out.println("Connection closed!");
      } catch (SQLException var2) {
        SQLException e = var2;
        System.out.println("Failed to close connection!");
        e.printStackTrace();
      }
    }

  }
}
