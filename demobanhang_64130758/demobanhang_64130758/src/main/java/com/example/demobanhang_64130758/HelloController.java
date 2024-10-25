package com.example.demobanhang_64130758;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.*;

public class HelloController {
    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, Integer> columnID;
    @FXML
    private TableColumn<Product, String> columnTenSP;
    @FXML
    private TableColumn<Product, String> columnGiaSP;
    @FXML
    private TableColumn<Product, String> columnMoTa;
    @FXML
    private Button btnAdd;

    private ObservableList<Product> productList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {
        // Gán dữ liệu cột cho TableView
        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnTenSP.setCellValueFactory(new PropertyValueFactory<>("tenSP"));
        columnGiaSP.setCellValueFactory(new PropertyValueFactory<>("giaSP"));
        columnMoTa.setCellValueFactory(new PropertyValueFactory<>("moTa"));

        // Gọi phương thức load dữ liệu từ MySQL
        loadProductsFromDatabase();
        btnAdd.setOnAction(event -> {
            try {
                switchToNewScene();
            } catch (IOException e) {
                e.printStackTrace(); // In ra lỗi nếu có
            }
        });
    }

    private void loadProductsFromDatabase() throws SQLException, ClassNotFoundException {
        // Kết nối tới MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demobanhang", "root", "");

        // Câu lệnh SQL để lấy dữ liệu
        String sqlSelect = "SELECT * FROM sanpham";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlSelect);

        // Đọc dữ liệu và thêm vào danh sách
        while (rs.next()) {
            int id = rs.getInt(1);
            String tenSP = rs.getString(2);
            String giaSP = rs.getString(3);
            String moTa = rs.getString(4);

            productList.add(new Product(id, tenSP, giaSP, moTa));
        }

        // Gán danh sách sản phẩm vào TableView
        tableView.setItems(productList);

        // Đóng kết nối
        rs.close();
        stmt.close();
        conn.close();
    }
    @FXML
    private void switchToNewScene() throws IOException {
        // Tải file FXML mới
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addproduct.fxml")); // Đường dẫn tới file FXML mới
        AnchorPane newSceneRoot = loader.load();

        // Tạo một scene mới
        Scene newScene = new Scene(newSceneRoot);

        // Lấy stage từ tableView thay vì btnAdd
        Stage stage = (Stage) tableView.getScene().getWindow(); // Chuyển từ btnAdd sang tableView
        stage.setScene(newScene);
        stage.show();
    }

}