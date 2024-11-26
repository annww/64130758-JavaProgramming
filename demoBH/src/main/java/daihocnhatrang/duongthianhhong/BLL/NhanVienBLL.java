package daihocnhatrang.duongthianhhong.BLL;

import daihocnhatrang.duongthianhhong.DAL.NhanVienDAL;
import daihocnhatrang.duongthianhhong.Model_DTO.NhanVien;
import daihocnhatrang.duongthianhhong.Utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class NhanVienBLL {
  NhanVienDAL nhanVienDAL = new NhanVienDAL();

  public NhanVienBLL() {
  }

  boolean ThemMoi(NhanVien nv) {
    boolean kq = this.nhanVienDAL.AddNew(nv);
    return kq;
  }

  public boolean dangKiTaiKhoan(String tenDN, String matkhau) throws SQLException {
    return this.nhanVienDAL.createAccount(tenDN, matkhau);
  }

  public boolean checkLogin(String tenDN, String matKhau) throws SQLException {
    Connection connection = DBUtils.openConnection();
    return this.nhanVienDAL.Login(tenDN, matKhau);
  }
}
