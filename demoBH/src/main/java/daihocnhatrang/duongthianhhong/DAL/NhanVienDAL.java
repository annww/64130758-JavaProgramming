package daihocnhatrang.duongthianhhong.DAL;

import daihocnhatrang.duongthianhhong.Model_DTO.NhanVien;
import daihocnhatrang.duongthianhhong.Utils.ComonUtils;
import daihocnhatrang.duongthianhhong.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NhanVienDAL {
  public NhanVienDAL() {
  }

  public boolean AddNew(NhanVien nv) {
    return true;
  }

  public boolean Delete(NhanVien nv) {
    return true;
  }

  public boolean Login(String tk, String mk) throws SQLException {
    Connection conn = DBUtils.openConnection();
    String sqlSelect = "SELECT * FROM user";
    Statement lenh = conn.createStatement();
    ResultSet ketQua = lenh.executeQuery(sqlSelect);

    do {
      if (!ketQua.next()) {
        DBUtils.closeConnection(conn);
        return false;
      }
    } while(!tk.equals(ketQua.getString("user")) || !ComonUtils.hashPassword(mk).equals(ketQua.getString("pass")));

    DBUtils.closeConnection(conn);
    return true;
  }

  public boolean createAccount(String tk, String mk) throws SQLException {
    Connection conn = DBUtils.openConnection();
    String sql = "INSERT INTO user (user,pass) VALUES (?, ?)";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, tk);
    statement.setString(2, ComonUtils.hashPassword(mk));
    int rowsInserted = statement.executeUpdate();
    if (rowsInserted > 0) {
      System.out.println("Thêm bản ghi thành công!");
      DBUtils.closeConnection(conn);
      statement.close();
      return true;
    } else {
      DBUtils.closeConnection(conn);
      return false;
    }
  }
}
