package daihocnhatrang.duongthianhhong;

import daihocnhatrang.duongthianhhong.BLL.NhanVienBLL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    NhanVienBLL bll = new NhanVienBLL();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Tài Khoản: ");
    String tk = scanner.nextLine();

    System.out.print("Mật khẩu: ");
    String mk = scanner.nextLine();

    if(bll.checkLogin(tk, mk) == true) {
      System.out.println("Đăng nhập thành công");

    }else {
      System.out.println("Đăng nhập thất bại");
    }
//    bll.dangKiTaiKhoan(tk,mk);
  }
}