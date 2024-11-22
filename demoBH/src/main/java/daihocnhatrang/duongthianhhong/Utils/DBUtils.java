package daihocnhatrang.duongthianhhong.Utils;

import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
  @FXML
  private Connection conn;

  @FXML
  // Kết nối tới cơ sở dữ liệu MySQL

  private static final String URL = "jdbc:mysql://localhost:3306/demoBH";
  private static final String USER = "root";
  private static final String PASSWORD = "";

  public static Connection getConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return conn;
  }
}