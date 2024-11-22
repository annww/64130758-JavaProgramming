package daihocnhatrang.duongthianhhong.BLL;

import daihocnhatrang.duongthianhhong.DAL.NhanVienDAL;
import daihocnhatrang.duongthianhhong.Model_DTO.NhanVien;

public class NhanVienBLL {
  NhanVienDAL nhanVienDAL;

  boolean ThemMoi(NhanVien nv) {
    boolean kq = nhanVienDAL.AddNew(nv);
    return kq;
  }

  public boolean checkLogin(String user, String pass) {
    //Kiểm tra tính đúng đắn
    //Vd: tên có rỗng không, có đúng format không
    //Nếu thỏa mãn thì gọi hàm dịch vụ ở tầng DAL
    if(user == null || user.isEmpty()){
      System.out.println("Tên đăng nhập không được để trống");
      return false;
    }
    else if(pass == null|| pass.isEmpty()){
      System.out.println("Mật khẩu không được để trống");
      return false;
    }
    return nhanVienDAL.Login(user, pass);
  }
}