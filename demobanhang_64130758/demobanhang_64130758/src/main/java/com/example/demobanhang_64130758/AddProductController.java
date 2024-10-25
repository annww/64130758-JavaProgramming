package com.example.demobanhang_64130758;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;
import java.sql.*;

public class AddProductController {
  @FXML
  private TextField txtTenSP, txtGiaSP, txtMoTa;
  @FXML
  private Button addSP;

  public void addProduct(String tenSP, String giaSP, String moTa) throws ClassNotFoundException, SQLException {
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
}