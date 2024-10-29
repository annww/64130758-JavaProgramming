package com.example.demobanhang_64130758;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
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
    private Button btnAdd;

    @FXML
    private void handleButtonClick() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addproduct.fxml"));

            Stage stage = (Stage) btnAdd.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField txtTenSP;

    @FXML
    private javafx.scene.control.TextField txtGiaSP;

    @FXML
    private javafx.scene.control.TextArea txtMoTa;

    private AddProductController databaseManager = new AddProductController();

    @FXML
    private void handleAddProduct() throws SQLException, ClassNotFoundException {
        String tenSP = txtTenSP.getText();
        String giaSP = txtGiaSP.getText();
        String moTa = txtMoTa.getText();

        databaseManager.addProduct(tenSP, giaSP, moTa);

        // Xóa các trường sau khi thêm
        txtTenSP.clear();
        txtGiaSP.clear();
        txtMoTa.clear();
    }

    @FXML
    private java.awt.Button addSP;

    @FXML
    public void addProducttoDB(String tenSP, String giaSP, String moTa) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO sanpham (tenSP, giaSP, moTa) VALUE (?,?,?)";

        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demobanhang", "root", "");
            PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1, tenSP);
            statement.setString(2,giaSP);
            statement.setString(3,moTa);

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0){
                System.out.println("Add succesfully!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void addProduct() throws SQLException, ClassNotFoundException {
        String tenSP = txtTenSP.getText();
        String giaSP = txtGiaSP.getText();
        String moTa = txtMoTa.getText();

        addProducttoDB(tenSP,giaSP,moTa);

        txtTenSP.clear();
        txtGiaSP.clear();
        txtMoTa.clear();
    }
}