package daihocnhatrang.duongthianhhong.DAL;

import daihocnhatrang.duongthianhhong.Model_DTO.NhanVien;
import daihocnhatrang.duongthianhhong.Utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class NhanVienDAL {

  public boolean AddNew(NhanVien nv) {
    return true;
  }

  public boolean Login(String user, String pass) {
    boolean result = false;
    try {
      // Kết nối cơ sở dữ liệu
      Connection conn = DBUtils.getConnection();
      String sql = "INSERT INTO Users (username, pass) VALUES (?, ?)";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, user);
      stmt.setString(2, pass);

      int rowsAffected = stmt.executeUpdate();
      if (rowsAffected > 0) {
        result = true;
      }
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
}

