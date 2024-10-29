package com.example.javaapp_login;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import java.sql.*;

public class HelloController {
    @FXML
    private TextField id;             // Ô nhập tên đăng nhập
    @FXML
    private TextField password;       // Ô nhập mật khẩu
    @FXML
    private Button btnlogin, btnreset;

    private Connection conn;
    private ObservableList<Account> accs = FXCollections.observableArrayList();

    // Phương thức khởi tạo, được gọi khi người dùng nhấn đăng nhập
    @FXML
    public void initialize() {
        connectDTB();
        getData();
    }

    // Hành động cho nút đăng nhập
    @FXML
    public void handleLoginButtonClick() {
        String txtName = id.getText().trim();
        String txtPass = password.getText().trim();

        // Kiểm tra đầu vào
        if (txtName.isEmpty() || txtPass.isEmpty()) {
            showAlert("Lỗi", "Tên đăng nhập và mật khẩu không được để trống.");
            return;
        }

        boolean loggedIn = validateLogin(txtName, txtPass);
        if (loggedIn) {
            // Hiển thị thông báo đăng nhập thành công
            showAlert("Đăng nhập thành công!", "Chào mừng bạn đến với ứng dụng.");
        } else {
            // Hiển thị thông báo đăng nhập thất bại
            showAlert("Đăng nhập thất bại!", "Tên đăng nhập hoặc mật khẩu không chính xác.");
        }
    }

    @FXML
    // Kết nối tới cơ sở dữ liệu MySQL
    private void connectDTB() {
        String url = "jdbc:mysql://localhost:3306/user";
        try {
            conn = DriverManager.getConnection(url, "root", "");
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại: " + e.getMessage());
        }
    }

    @FXML
    // Lấy dữ liệu từ bảng account và thêm vào danh sách accs
    private void getData() {
        String sqlSelect = "SELECT * FROM user";
        try (Statement lenh = conn.createStatement();
             ResultSet ketQua = lenh.executeQuery(sqlSelect)) {
            while (ketQua.next()) {
                accs.add(new Account(ketQua.getString("id"), ketQua.getString("password")));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn dữ liệu: " + e.getMessage());
        }
    }

    @FXML
    private boolean validateLogin(String id, String password) {
        String sqlSelect = "SELECT * FROM user WHERE id = ? AND password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sqlSelect)) {
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Đăng nhập thành công cho ID: " + id);
                    return true;
                } else {
                    System.out.println("Tên đăng nhập hoặc mật khẩu không chính xác cho ID: " + id);
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi kiểm tra đăng nhập: " + e.getMessage());
            return false;
        }
    }



    // Phương thức hiển thị thông báo
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    public void handleResetButtonClick() {
        id.clear();
        password.clear();
    }

}
