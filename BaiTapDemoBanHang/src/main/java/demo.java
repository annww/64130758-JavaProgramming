import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class demo {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
//    System.out.printf("Hello");
    // dang ky driver
    Class.forName("com.mysql.cj.jdbc.Driver");
    // 2. Mo ket noi
    // 2.1 Tao chuoi ket noi
    String strCont = "jdbc:mysql://localhost:3306/demobanhang";
    Connection conn = DriverManager.getConnection(strCont,"root","");
    System.out.printf("Haha");
    
  //Select
    String sqlSelect = "select & from sanpham";
    Statement Lenh = conn.createStatement();
    Resultset ketQua = Lenh.executeQuery(sqlSelect);
  }
}
